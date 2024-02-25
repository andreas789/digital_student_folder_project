package gr.aueb.mscis.educore.persistence.test.util;

import gr.aueb.mscis.educore.persistence.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.SQLException;
import java.util.List;

public class DBHelper {

    public static void truncateAll() throws SQLException, ClassNotFoundException {
        EntityManager em = JpaUtil.getCurrentEntityManager();
        try {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.createNativeQuery("SET FOREIGN_KEY_CHECKS = false").executeUpdate();
            List<String> tableNames = em.createNativeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = SCHEMA()").getResultList();
            for(String table:tableNames){
                em.createNativeQuery("TRUNCATE TABLE " + table).executeUpdate();
            }
            em.createNativeQuery("SET FOREIGN_KEY_CHECKS = true").executeUpdate();
            tx.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
