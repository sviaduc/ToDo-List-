package test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Todo;
import entities.User;

public class UserTest {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("Todo");
		em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() throws Exception {
	    em.close();
	    emf.close();
	}
	
	@Test
	public void test_user_mappings() {
	    User user = em.find(User.class, 1);
	    assertNotNull(user.getId());
	    assertEquals("test@test.com", user.getEmail());
	  }
	
	@Test
	public void test_todo_mappings() {
		Todo todo = em.find(Todo.class, 1);
		System.out.println(todo);
		assertEquals("test33", todo.getTask());
	}

}
