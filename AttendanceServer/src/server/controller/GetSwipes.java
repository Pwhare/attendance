package server.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import server.persistence.CardSwipes;
import server.persistence.TestJoin;
import server.persistence.util.HibernateUtil;

public class GetSwipes
{

  public List<TestJoin> getAllCardSwipes()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    List<TestJoin> results = new ArrayList<TestJoin>();

    try
    {
      transaction = session.beginTransaction();

      String hql = "FROM TestJoins";
      Query query = session.createQuery(hql);
      results = query.list();

      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return results;
  }

  public List<CardSwipes> getRangeCardSwipes(Date startDate, Date endDate)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    List<CardSwipes> results = new ArrayList<CardSwipes>();

    try
    {
      transaction = session.beginTransaction();

      String hql = "from CardSwipes as card_swipe where card_swipe.swipeTime > :startDate";
      Query query = session.createQuery(hql).setParameter("startDate", startDate);
      results = query.list();

      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return results;
  }

  public List<CardSwipes> getSQLCardSwipes()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    // List<CardSwipes> results = new ArrayList<CardSwipes>();
    List results = null;

    try
    {
      transaction = session.beginTransaction();

      String sql = "SELECT CardNumber FROM CardSwipes";
      Query query = session.createSQLQuery(sql);
      results = query.list();

      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return results;
  }

}
