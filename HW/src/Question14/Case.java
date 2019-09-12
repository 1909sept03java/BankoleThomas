package Question14;

import java.time.LocalDate;

public class Case {
	
	public static void control(int n) {
	
		
		switch(n) {
		case 1: 
			Math.sqrt(n); 
			break;
		case 2:
			LocalDate myObj=LocalDate.now();
			System.out.println(myObj);
			break;
		case 3:String m="I am learning Core Java";
			String[] words= m.split(" ");
		
		}
	}

	public static void main(String[] args) {
		control(1);
		control(2);
		control(3);
	}

}
