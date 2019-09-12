package Question16;

public class StringInput {
	
	public static int count(String x){
		char[] ch = x.toCharArray();
		int letter = 0;
		for(int i = 0; i < x.length(); i++){
			if(Character.isLetter(ch[i])){
				letter ++ ;
			}
			}
		return letter;
		}
	public static void main(String[] args) {
	
	
		String test = "Fire on Sight";
		count(test);
	}}


