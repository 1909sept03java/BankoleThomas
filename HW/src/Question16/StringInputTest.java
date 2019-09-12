package Question16;

import static org.junit.Assert.*;
import static Question16.StringInput.*;
import org.junit.Test;

public class StringInputTest {

	@Test
	public void test() {
		assertEquals(11,count("Fire on sight"));
	}
	
	@Test
	public void test2() {
		assertNotEquals(5,count("terminate Person of interest"));
	}

}
