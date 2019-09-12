package Factorial;

public class Factorial {

	
	static int counter(int n) {
		int product = 1;
		for(int i = 2; i <= n; i++) {
			product *= i;
		}
		return product;
	}





	public static void main(String[] args) {
		System.out.println(counter(5));
	}

}
