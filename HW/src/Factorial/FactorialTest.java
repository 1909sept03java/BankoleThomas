package Factorial;

import static Factorial.Factorial.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {


	@Test
	public void test() {	
		//f(5) = 120
		assertEquals(120, counter(5));
		
		//f(3) == 6
		assertEquals(6, counter(3));
	}

}
