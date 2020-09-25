package no.hvl.dat250.experiment2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TodoDAO {
	
    private EntityManager em;

    public TodoDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("todos");
        em = factory.createEntityManager();
    }
    
    public List<Todo> read() {
        Query query = em.createQuery("Select t from Todo t");
        return query.getResultList();
    }

    public Todo read(int id) {
        return em.find(Todo.class, id);
    }

    public void create(Todo todo) {
        em.getTransaction().begin();
        em.persist(todo);
        em.getTransaction().commit();
    }

    public void update(Todo todo) {
        em.getTransaction().begin();
        em.merge(todo);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        Todo todo = em.find(Todo.class, id);
        em.getTransaction().begin();
        em.remove(todo);
        em.getTransaction().commit();
    }
}
