package Question6;

import static org.junit.Assert.*;
import static  Question6.IsEven.*;
import org.junit.Test;

public class IsEvenTest {

	@Test
	public void test() {
		assertTrue(divide(34));
	}

	@Test
	public void test2() {
		assertFalse(divide(37));
	}
}
