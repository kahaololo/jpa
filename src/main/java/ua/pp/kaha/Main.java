package ua.pp.kaha;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by skokhanenko on 28.10.2016.
 */
public class Main {
    private static final String PERSISTENT_UNIT_NAME = "jpa-test";
    private static EntityManager em;
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
            em = emf.createEntityManager();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Arrays.asList(1,2,3);


        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        for (int i=0; i < 5; i++) {
            User user = new User();
            user.setName("ololo " + i);
            em.persist(user);
        }
        em.flush();
        transaction.commit();
        em.close();
        emf.close();

    }
}
