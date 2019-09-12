package Question2;

import static Question2.Fibonacci.*;
import static org.junit.Assert.*;

import org.junit.Test;public class FibonacciTest {

	@Test
	public void test() {

		assertEquals("0 1 1 2 3", fib(5));
	}
	
	public void test2() {
		assertNotEquals("0 6 8 3 4 8 ", fib(6));
	}

}
