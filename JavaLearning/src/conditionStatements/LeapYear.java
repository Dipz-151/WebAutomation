package conditionStatements;
import java.util.*;         // util package contains the Scanner class
public class LeapYear       // user defined class
{
    public static void main(String args[]) 
    {
        int year;                            			  // variable declared
        Scanner sc = new Scanner(System.in);  			 // A new object 'sc' created to call the method in the scanner class
        System.out.println("Please enter the year:");    // to get the input from the user
        year = sc.nextInt();    						// nextInt() method is called using object 'sc' for the variable year
        if(year%400==0)
        {
            System.out.println("The year" +year +"is a leap year");
        }
        else if(year%4==0 && year%100!=0)
        {
            System.out.println("The year" +year +"is a leap year");
        }
        else
        {
            System.out.println("The year" + year + "is not a leap year");
        }
    }
}