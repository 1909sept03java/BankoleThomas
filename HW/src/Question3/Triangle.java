package Question3;

public class Triangle {

	public static void generate() {
		
		int i,j;
		for(i=1; i<=5; i++){
			  for(j=1; j<=i; j++){
			  if((i+j)%2==1){
			      System.out.print("1");
			  }
			  else{
			      System.out.print("0");
			  }
			  
			}
			System.out.println();
	}}
	
	public static void main(String[] args) {
		generate();

	}

}
