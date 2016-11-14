package ua.pp.kaha;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

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
        User user = em.find(User.class, 1);
        user.addMeasurment(new Date(), 1, 4);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();

//        System.out.println(em.find(User.class, 1));
        System.out.println(user);
        em.close();
        emf.close();

    }
}
