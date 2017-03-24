import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CategoryUtil {

	 public static boolean checkIfCategoryExists(String category)
	 {
		if(category == null || category.trim().equals(""))
		  return false;
		else
		{		
	    File f = new File("C:/Users/Azam/Desktop/My Task Manager/"+category+".txt");
	    boolean b = f.exists();
	    return b;
		}
	    
	 }
	 public static boolean checkIfTaskNameExists(String category,String taskName) throws IOException
	 {
		 BufferedReader br = null;
		 br = new BufferedReader(new FileReader("C:/Users/Azam/Desktop/My Task Manager/"+category+".txt"));
		 String x;
		 while((x = br.readLine()) != null)
		 {
			 String[] s = x.split(":");
			 int j = 0;
				 if(taskName.equals(s[j]))
				 {
					 return true;
				 }
			 
		 }
		 br.close();
		 return false;
	 }
	 
}
