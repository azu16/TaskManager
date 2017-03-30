import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CategoryUtil {
	
	public static int checkChoice()
	{
		Scanner sc1 = new Scanner(System.in);
		int m = 0;
		 while(!sc1.hasNextInt())
         {
      	   System.out.println("please enter a valid arguement");
      	    sc1.next();
         }
		 int ch = sc1.nextInt();
		 return ch;
		 
	}
	public static String checkStrings(String s2)
	{
		
		Scanner sc2 = new Scanner(System.in);
		char[] a = s2.toCharArray();
		if(s2 != null && (!s2.trim().equals("") && (!Character.isDigit(s2.charAt(0)))))
		{
			
			return s2;
		}
		else
		{				
		 while(s2 == null || s2.trim().equals("") || (Character.isDigit(s2.charAt(0))))
         {
      	   System.out.println("please enter a valid arguement");
      	    s2 = sc2.nextLine();
         }
		 return s2;
		} 
	}
	public static boolean checkIfCategoryExists(String category) {
		if (category == null || category.trim().equals(""))
			return false;
		else {
			File f = new File("C:/Users/Azam/Desktop/My Task Manager/"
					+ category + ".txt");
			boolean b = f.exists();
			return b;
		}

	}

	public static boolean checkIfTaskNameExists(String category, String taskName)
			throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(
				"C:/Users/Azam/Desktop/My Task Manager/" + category + ".txt"));
		String x;
	
		while ((x = br.readLine()) != null) {
			String[] s = x.split(":");
			int j = 0;
			if (taskName.equals(s[j])) {
				return true;
			}

		}
		br.close();
		return false;
	}

}
