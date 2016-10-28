package ua.pp.kaha;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by skokhanenko on 28.10.2016.
 */
public class Main {
    private static final String PERSISTENT_UNIT_NAME = "jpa-test";

    public static void main(String[] args) {
        EntityManager em;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
            em = emf.createEntityManager();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
        User user = em.find(User.class, 1);
        user.addMeasurment(new Measurment(user.getId(),1,2));
        user.addMeasurment(new Measurment(user.getId(),1,3));

        User user1 = new User();
        user1.setName("ololo");
        em.persist(user1);
        System.out.print("User1 id is " + user1.getId() );
        em.close();

    }
}
