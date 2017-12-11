/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vaght.Service;

import java.util.List;


/**
 *
 * @author armin
 */
public class serviceUtil {

    private static Baseservice bs_service = new Baseservice();

    public static Integer save(Object obj) {
        return bs_service.save(obj);
    }
    public static void update(Object obj) {
        bs_service.update(obj);
    }
    public static Object uniqueQuery(String hql) {
        return bs_service.uniqueQuery(hql);
    }
     public static List findByQuery(String hql) {
        return bs_service.findByQuery(hql);
    }
     public static List findByQuery(String hql,int first,int max) {
        return bs_service.findByQuery(hql, first, max);
    }
     public static List findBySql(String sql) {
        return bs_service.findBySql(sql);
    }
    public static Object uniqueSqlQuery(String sql) {
        return bs_service.uniqueSqlQuery(sql);
    }
  
     
     
    
}
