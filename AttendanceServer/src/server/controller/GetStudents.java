package server.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import server.persistence.Students;
import server.persistence.util.HibernateUtil;

public class GetStudents
{
  public List<Students> getAllStudents()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    List<Students> results = null;
    try
    {
      transaction = session.beginTransaction();

      String hql = "FROM Students";
      Query query = session.createQuery(hql);
      // String sql = "SELECT * FROM Students";
      // Query query = session.createSQLQuery(sql);
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
