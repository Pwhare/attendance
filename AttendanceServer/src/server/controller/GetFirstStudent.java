package server.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import server.persistence.util.HibernateUtil;

public class GetFirstStudent
{

  public String getFirstStudent()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    String student = new String();
    try
    {
      transaction = session.beginTransaction();

      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return student;
  }
}
