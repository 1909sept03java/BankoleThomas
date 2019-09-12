package Question17;
import java.util.Scanner;

public class Interest {

	public static int Calculate() {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Give Principal");
		int Principal = myObj.nextInt();
		System.out.println("Give Rate");
		int Rate = myObj.nextInt();
		System.out.println("Give Time");
		int Time = myObj.nextInt();
		int Interest = Principal*Rate*Time;
		
		return Interest;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
