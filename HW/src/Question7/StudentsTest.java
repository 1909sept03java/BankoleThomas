package Question7;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class StudentsTest {

	static Students[] unsorted = new Students[5];

	static Students[]sortedByAge = new Students[5];

	static {
		unsorted[0] = new Students("Yinka", "Fire", 14);
		unsorted[1] = new Students("Benji", "Water", 33);
		unsorted[2] = new Students("Nick", "Insect", 20);
		unsorted[3] = new Students("Hilda", "Sound", 21);
		unsorted[4] = new Students("Tsu", "Mist", 20);
	}
	static {
		
		sortedByAge[0] = unsorted[0];
		sortedByAge[1] = unsorted[2];
		sortedByAge[2] = unsorted[4];
		sortedByAge[3] = unsorted[3];
		sortedByAge[4] = unsorted[1];
	}


	@Test
	public void testAgeComparator() {
		Arrays.sort(unsorted, new CompareByAge());

		for(Students s : unsorted) {
			System.out.println(s);
		}
		assertArrayEquals(sortedByAge, unsorted); 
	}

}
