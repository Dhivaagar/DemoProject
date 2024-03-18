import java.util.Scanner;
class Vowels {

	public static boolean isThereVowels(String str){ 
		boolean flag = false;
		if(str.contains("a")||str.contains("e")||str.contains("i")||str.contains("o")||str.contains("u"))
			flag = true;
		return flag;
	}

	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(Vowels.isThereVowels(str.toLowerCase()));
		
	} 
}