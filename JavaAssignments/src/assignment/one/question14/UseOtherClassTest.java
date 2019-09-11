package assignment.one.question14;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UseOtherClassTest {
	
	int a = 10;
	int b = 2;
	UsingInterface test = new UsingInterface();

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
	public void testAdd() {
		
		assertEquals(12, test.addition(a, b));
		
	}
	
	@Test
	public void testSubtract() {
		
		assertEquals(8, test.subtraction(a, b));
		
	}
	
	@Test
	public void testDivide() {
		
		assertEquals(5, test.division(a, b));
		
	}
	
	@Test
	public void testMultiply() {
		
		assertEquals(20, test.multiplication(a, b));
		
	}

}