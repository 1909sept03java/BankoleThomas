package Factorial;

import static Factorial.Factorial.counter;

import org.junit.Test;

import junit.framework.TestCase;

public class Ftest extends TestCase {

	@Test
	public void test() {	
		//f(5) = 120
		assertEquals(120, counter(5));

		//f(3) == 6
		assertEquals(6, counter(3));

	}
}	
