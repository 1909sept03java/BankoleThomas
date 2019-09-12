package Question5;

public class IndexString {
	
	public static String subString(String str,int index) {
		String out= "";
		for(int i=0;i<index;i++) {
			out+=str.charAt(i);
		}
		return out;
	}
	
	public static void main(String[] args) {
		double num = 37.0;
		int inum = 37;
		System.out.println(num/2);
		System.out.println((num/2)==(inum/2));

	}

}
