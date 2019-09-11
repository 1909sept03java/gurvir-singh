package assignment.one.question1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleTest {

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
	public void testBubble() {
		
		Bubble b = new Bubble();
		int[] testArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9}; //Setting up everything to compare the arrays.
		int[] actual = b.bubbleSort(testArray);
		assertArrayEquals(expected, actual);
		
	}

}