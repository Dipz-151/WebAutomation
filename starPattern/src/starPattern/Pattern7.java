package starPattern;

public class Pattern7 {
	public static void main(String[] args) 
	{
		int k=1;
		for(int i=1; i<=5; i++)
		{
			for(int j=5; j>i; j--)
			{
				System.out.print(k+"\t");
				k++;
			}
			System.out.println(" ");
		}
	}
}
