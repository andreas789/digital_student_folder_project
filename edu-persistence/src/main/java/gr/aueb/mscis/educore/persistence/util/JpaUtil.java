package gr.aueb.mscis.educore.persistence.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManager em;
    public static EntityManager getCurrentEntityManager() {
        if(em==null) {
            em = JpaUtil.createEntityManager();
        }
        return em;
    }

    private static EntityManager createEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gr.aueb.mscis.educore.model");
        return emf.createEntityManager();
    }
}
