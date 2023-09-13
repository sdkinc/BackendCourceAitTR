package hibernate;

import hibernate.domain.Event;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

public class EntityManagerDemo {

  static EntityManager em;

  public static void main(String[] args) {
    EntityManagerFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();
    em = factory.createEntityManager();
    Event event = findById(1);
    System.out.println(event);
    Event newEvent = add(new Event("Berlin", "Rock-n-roll"));
    System.out.println(newEvent);
    event = findById(2);
    System.out.println(event);
    event.setName("Elwis Presley memorials...");
    event.setCity("Hamburg");
    event = update(event);
    System.out.println(event);
    delete(event);
    List<Event> events = findAll();
    System.out.println(events);
  }

  private static Event findById(Integer id) {
    return em.find(Event.class, id);
  }

  static Event add(Event event) {
    em.getTransaction().begin();
    em.persist(event);
    em.getTransaction().commit();
    return event;
  }

  static Event update(Event event) {
    em.getTransaction().begin();
    em.merge(event);
    em.getTransaction().commit();
    return event;
  }

  static void delete(Event event) {
    em.getTransaction().begin();
    em.remove(event);
    em.getTransaction().commit();
  }

  static List<Event> findAll() {
    return em.createNamedQuery("findAll", Event.class).getResultList();
  }
}
