package server.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import server.beans.CardSwipe;
import server.persistence.CardSwipes;
import server.persistence.util.HibernateUtil;

public class CreateSwipe
{
  public Long saveCardSwipe(CardSwipe cs)
  {
    return saveCardClass(cs.getCardNumber(), cs.getClassRoom());
  }

  public Long saveCardClass(String cardNumber, String classRoom)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Long index = null;
    try
    {
      transaction = session.beginTransaction();
      CardSwipes dBase = new CardSwipes();
      dBase.setCardNumber(cardNumber);
      dBase.setClassRoom(classRoom);

      index = (Long) session.save(dBase);
      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return index;
  }

}
