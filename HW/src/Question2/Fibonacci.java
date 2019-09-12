package Question2;

public class Fibonacci {

	public static void main(String[] args) {
		
		System.out.println(fib(10));
	}

	public static String fib(int count) {
		int n1=0;
		int n2=1;
		int n3;
		
		
		String out = "";
		    
		out += n1+" "+n2;   

		for(int i=2;i<count;++i)   
		{    
			n3=n1+n2;    
			out += " "+n3;    
			n1=n2;    
			n2=n3;    

		}
	
	return out;
	
	}

}
