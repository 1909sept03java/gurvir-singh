package project.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import project.beans.User;

public class UserDAOImplTest {

	@Test
	public void testGetUsers() { //Just going to retrieve the list. If any name matches the name I pass in then its retrieving the list from the database.
		UserDAO a = new UserDAOImpl();
		boolean b = false;
		for(User c: a.getUsers()) {
			if(c.getfName().equals("Gurvir"))  
				b = true;
		}
		assertTrue(b);
	}

	@Test
	public void testGetUserByName() {
		UserDAO a = new UserDAOImpl();
		User c = a.getUserByName("gsingh34");
		boolean b = false;
		if(c.getfName().equals("gsingh34"));
			b = true;
		assertTrue(b);
	}


}
