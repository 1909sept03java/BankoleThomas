package Question1;

public class BubbleSort {
	
	static int[] bubblesort(int[] arr) {
		
		int n = arr.length;
		
		int temp =0;
			
			for(int i=0; i < n; i++) {
				for (int j=1; j<(n-i);j++) {
					if (arr[j-1]> arr[j]) {
						
						temp = arr[j-1];
						
						arr[j-1] = arr[j];
						
						arr[j] = temp;
						
						
					
				}
					
				}
			}
			return arr;
	}
	public static void main(String[] args) {
		int arr[]= {1,0,5,6,3,2,3,7,9,8,4};
		
		bubblesort(arr);
		  for(int i=0; i < arr.length; i++){  
              System.out.print(arr[i] + " ");  
      }  

	}

}
