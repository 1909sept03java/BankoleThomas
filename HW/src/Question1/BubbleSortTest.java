package Question1;

import static Question1.BubbleSort.bubblesort;
import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {

	@Test
	public void test() {
		int[] expected =  {1,3,4,4, 6, 7, 8, 8};
		int[] param  = {4,4,8,1,7,3,6,8};
		assertArrayEquals(expected, bubblesort(param));
	}

	@Test
	public void test2() {
		int[] result= {-7,0,1, 3,4,4, 6, 8, 9};
		int[] wrong= {3,0,4,1,4,6,-7, 9, 8};
		assertArrayEquals(result,bubblesort(wrong));
	}
}
