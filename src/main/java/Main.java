import entities.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Session session = getSession();
        Query<User> query = session.createQuery("select u from User u WHERE u.id = 1", User.class);
        User singleResult = query.getSingleResult();
        System.out.println(singleResult.toString());
        System.out.println(singleResult.getPosts());
        session.close();
    }
    private static Session getSession(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory.openSession();
    }
}
