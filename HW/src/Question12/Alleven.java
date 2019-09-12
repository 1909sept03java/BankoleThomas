package Question12;

public class Alleven {

	public static void main(String[] args) {
		int nums[]=new int[100];
		for(int i=0;i<100;i++) {
			nums[i]=i+1;
		}
		
		for(int n : nums) {
			//nums[i] is the same thing as n if this was a regular for loop
			if(n%2==0) {
				System.out.println(n);
			}
			
		}
	}

}
