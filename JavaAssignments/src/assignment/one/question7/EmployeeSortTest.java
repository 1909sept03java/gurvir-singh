package assignment.one.question7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		ArrayList<Employee> myList = new ArrayList<Employee>();
		myList.add(new Employee("Gurvir", "Biology", 25));
		myList.add(new Employee("Jeremy", "Finance", 21));
		myList.add(new Employee("Pavi", "Anthropology", 27));
		
		Collections.sort(myList, new DepartmentSort());
		
		String expected = "Pavi, Anthropology, 27";
		String actual = myList.get(0).toString();
		assertEquals(expected, myList.get(0).toString());
		
	}

}