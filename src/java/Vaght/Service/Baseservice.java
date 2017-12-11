package Vaght.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.management.Query;
import Vaght.Models.HibernateSessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.hibernate.type.TextType;


public class Baseservice {

    public static Integer save(Object obj) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        //System.out.println(s.save(obj));
        Integer id = (Integer) s.save(obj);
        t.commit();
        s.close();
        return id;
    }

    public void update(Object obj) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        //Long id =
        s.update(obj);
        t.commit();
        s.close();
    }

    public void merge(Object obj) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        //Long id =
        s.merge(obj);
        t.commit();
        s.close();
        //return id;
    }

    public void delete(Object obj) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.delete(obj);
        t.commit();
        s.close();
    }

    public Object loadById(long id) {
        return null;
    }

    public Object loadById(long id, Class clazz) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        Object o = s.get(clazz, id);
        s.close();
        return o;
    }

    public static List findByQuery(String hql) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        List l = s.createQuery(hql).list();
        tx.commit();
        s.close();
        return l;
    }

    public List findBySql(String sql) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        List l = s.createSQLQuery(sql).list();
        s.close();
        return l;
    }

    public List findBySql(String sql, String resultSetMappingName, int first, int max) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        SQLQuery q = s.createSQLQuery(sql);
        q = q.setResultSetMapping(resultSetMappingName);
        q.setFirstResult(first);
        q.setMaxResults(max);
        List l = q.list();
        s.close();
        return l;
    }

    public List findByQuery(String hql, int first, int max) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        org.hibernate.Query q = s.createQuery(hql);
        if (first != -1) {
            q.setFirstResult(first);
        }
        if (max != -1) {
            q.setMaxResults(max);
        }
        List l = q.list();
        s.close();
        return l;
    }

    public static Object uniqueQuery(String hql) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        org.hibernate.Query q = s.createQuery(hql);
        Object o = q.uniqueResult();
        s.close();
        return o;
    }
    public Object uniqueSqlQuery(String sql) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        SQLQuery q = s.createSQLQuery(sql);
        Object o=q.uniqueResult();
        return o;
    }
    
    public void executeQuery(String hql) {
        Session s = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        org.hibernate.Query q = s.createQuery(hql);
        q.executeUpdate();
        t.commit();
        s.close();
    }

    public String correctString(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("ي", "ی").replaceAll("ك", "ک").replaceAll("ى", "ی");
    }

    public String dropErab(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("[ًٌٍَُِّ]", "");
    }
}

   