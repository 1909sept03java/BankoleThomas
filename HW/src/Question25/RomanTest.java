package Question25;

import static org.junit.Assert.*;
import static Question25.Roman.*;

import org.junit.Test;

public class RomanTest {

	@Test
	public void test() {
		assertEquals("XXIII", Numeral(23));
	}

	@Test
	public void test2() {
		assertNotEquals("XX", Numeral(23));
	}

}
