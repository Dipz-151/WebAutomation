package string;

public class StringProgram {

	public static void main(String[] args) 
	{
		String str = "I am learning Java";
		String str1 = "I am learning Selenium";
		System.out.println("The string is: "+str);
		System.out.println("The length of the given string is: " +str.length());
		System.out.println("The character at index 10 is: " +str.charAt(10));
		System.out.println("The string is now in upper case:" +str.toUpperCase());
		System.out.println(str.compareTo("I am learning Selenium"));
		System.out.println(str.concat(";" +str1));
		System.out.println(str.contains(str1));
		System.out.println(str.endsWith("ava"));
		System.out.println(str.indexOf("l"));
	}

}
