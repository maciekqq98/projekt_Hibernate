package DAO;

import Model.GraEntity;
import Model.WynikiEntity;
import com.company.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeDAO {

    public String saveWyniki(WynikiEntity wynikiEntity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(wynikiEntity);
        transaction.commit();
        session.close();
        return "udało sie dodac rekord !!!";
    }

    public WynikiEntity getWynikiById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        WynikiEntity wyniki = session.get(WynikiEntity.class, id);
        session.close();
        return wyniki;
    }
    public GraEntity getGraById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        GraEntity graEntity2= session.get(GraEntity.class,id);
        session.close();
        return graEntity2;
    }

    public void updatWyniki(WynikiEntity wynikiEntity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(wynikiEntity);
        transaction.commit();
        session.close();
    }
    public void deleteWynik(WynikiEntity wynikiEntity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(wynikiEntity);
        transaction.commit();
        session.close();
    }

    public List<WynikiEntity> getAllWyniki(){
        try(Session session=HibernateUtil.getSessionFactory().openSession()) //.getCurrentSession()
        {
            return session.createNamedQuery("wyniki.findAll",WynikiEntity.class).getResultList();
        }

    }


    public WynikiEntity getByNameAndSurname(String name,String surname)
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession())
        {
            return session.createNamedQuery("wyniki.findByNameAndSurname",WynikiEntity.class)
                    .setParameter("name",name)
                    .setParameter("surname",surname)
                    .getSingleResult();
        }
    }

    public List<WynikiEntity> getPktMore(int pkt)
    {
        try(Session session=HibernateUtil.getSessionFactory().openSession()) {

            return session.createNamedQuery("wyniki.findMore",WynikiEntity.class)
                    .setParameter("pkt",pkt)
                    .getResultList();
        }
    }
}
