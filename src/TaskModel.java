import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


public class TaskModel {
	
	public static void createCategory(String categoryName) throws IOException
	{
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
		bw.newLine();
		bw.close();
	}
    
	public static void addTask(TaskBeans bean,String categoryName) throws IOException
	{
		
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt",true));
		bw.write(bean.getTaskName()+"::"+bean.getDescription()+"::"+bean.getPriority()+"::"+bean.getTag()+"::"+bean.getcreateDate()+"::"+bean.getDueDate());
		bw.newLine();
		bw.close();
	}
	
	public static void viewTask(String categoryName) throws IOException
	{
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
		String x;
		while((x = br.readLine()) != null)
		{
			System.out.println(x);
		}
		br.close();
	}
	
	public static void editTask(String categoryName,String taskName,int ch) 
	{
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		BufferedWriter bw = null;
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al1 = new ArrayList<String>();
		try
		{
			String x;
			String c;
		br = new BufferedReader(new FileReader("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
		while((x = br.readLine()) != null)
		{
			al.add(x);
		}
		if(ch == 1)
		{	
abc:		for(int i = 0; i < al.size(); i++)
		{
			String[] s1 = al.get(i).split("::");
			for(int j = 0; j < 1; j++)
			{
				if(s1[j].equals(taskName))
				{
					System.out.println("Enter new taskname");
					String newName = sc.nextLine();
					c = al.get(i).replace(s1[j], newName);
					al1.add(c);
					continue abc;
				}
			}
			al1.add(al.get(i));
		}
		}	
		if(ch == 2)
		{
			abc: for(int i = 0; i < al.size(); i++)
			     {
				String[] s1 = al.get(i).split("::");
				for(int j = 0; j < 1; j++)
				{
					if(s1[j].equals(taskName))
					{
						System.out.println("Enter new description");
						String newdescription = sc.nextLine();
						c = al.get(i).replace(s1[j+1], newdescription);
						al1.add(c);
						continue abc;
					}
				}
				al1.add(al.get(i));
			}
		}
		if(ch == 3)
		{
			abc: for(int i = 0; i < al.size(); i++)
			     {
				String[] s1 = al.get(i).split("::");
				for(int j = 0; j < 1; j++)
				{
					if(s1[j].equals(taskName))
					{
						System.out.println("Enter new priority");
						String newPriority = sc.nextLine();
						c = al.get(i).replace(s1[j+2], newPriority);
						al1.add(c);
						continue abc;
					}
				}
				al1.add(al.get(i));
			}
		}
		if(ch == 4)
		{
			abc: for(int i = 0; i < al.size(); i++)
			     {
				String[] s1 = al.get(i).split("::");
				for(int j = 0; j < 1; j++)
				{
					if(s1[j].equals(taskName))
					{
						System.out.println("Enter new tag");
						String newTag = sc.nextLine();
						c = al.get(i).replace(s1[j+3], newTag);
						al1.add(c);
						continue abc;
					}
				}
				al1.add(al.get(i));
			}
		}
		
		if(ch == 5)
		{
			abc: for(int i = 0; i < al.size(); i++)
			     {
				String[] s1 = al.get(i).split("::");
				for(int j = 0; j < 1; j++)
				{
					if(s1[j].equals(taskName))
					{
						System.out.println("Enter new dueDate(dd/mm/yyyy)");
						String ndt = sc.nextLine();
						java.util.Date dt = null;
						SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy");
						try {
							dt = sd.parse(ndt);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String s2 = dt.toString();
						c = al.get(i).replace(s1[j+5],s2);
						al1.add(c);
						continue abc;
					}
				}
				al1.add(al.get(i));
			}
		}
		  bw = new BufferedWriter(new FileWriter("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
		  for(int k = 0; k < al1.size(); k++)
		  {
			  bw.write(al1.get(k));
			  bw.newLine();
		  }
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
			{
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if(bw != null)
			{
				try {
					bw.close();
				} catch (IOException e) {
			
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void removeTask(String categoryName,String taskName)
	{
		BufferedReader br = null;
		BufferedWriter bw = null;
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al1 = new ArrayList<String>();
		try
		{
			String x;
			String c;
		br = new BufferedReader(new FileReader("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
		while((x = br.readLine()) != null)
		{
			al.add(x);
		}
		
abc:		for(int i = 0; i < al.size(); i++)
		    {
			String[] s1 = al.get(i).split("::");
			for(int j = 0; j < 1; j++)
			{
				if(s1[j].equals(taskName))
				{
				  	continue abc;
				}
			}
			al1.add(al.get(i));
		}
	
		bw = new BufferedWriter(new FileWriter("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
		  for(int k = 0; k < al1.size(); k++)
		  {
			  bw.write(al1.get(k));
			  bw.newLine();
		  }
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
			{
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			if(bw != null)
			{
				try {
					bw.close();
				} catch (IOException e) {
			
					e.printStackTrace();
				}
			}
		}
	}	
	
	public static void listTasks(String categoryName,int ch)
	{
		if(ch == 1)
		{	
		  BufferedReader br = null;
		  TreeSet<String> ts = new TreeSet<String>();
		try
		{
			br = new BufferedReader(new FileReader("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
			String x;
			while((x = br.readLine()) != null)
			{
				ts.add(x);
			}
			for(String c : ts)
			{
				System.out.println(c);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
				try
			    {
					br.close();
				}
			    catch (IOException e)
			    {
					e.printStackTrace();
				}
		 }
	  }	
	}
	public static void search(String categoryName,String find)
	{
		BufferedReader br = null;
		int descriptionCount = 0;
		int nameCount = 0;
		int totalCount = 0;
		int tagCount = 0;
		ArrayList<String> ald = new ArrayList<String>();
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> aln = new ArrayList<String>();
		ArrayList<String> alt = new ArrayList<String>();
		try
		{
			String x;
			
		br = new BufferedReader(new FileReader("C:/Users/Azam/Desktop/My Task Manager/"+categoryName+".txt"));
		while((x = br.readLine()) != null)
		{
			al.add(x);
		}
		
abc:	for(int i = 0; i < al.size(); i++)
        {
	      String[] s2 = al.get(i).split("::");
		
xyz:	   for(int j = 0; j < s2.length; j++)
		   {
              if(j == 0)
              {		
       
            	 if(s2[j].equals(find))
                 {
                	 
                	aln.add(s2[j]);
                	nameCount++;
                	
                    continue xyz;
                  }
                  continue xyz;
               }
              
			if(j == 1)
			{		
				
				String[] s3 = s2[j].split(" ");
				for(int m = 0; m < s3.length; m++)
				{
					 if(s3[m].equals(find))
					 {
						 String form = s2[0]+" - "+s2[j];
						ald.add(form);
						descriptionCount++;
						continue abc;
					 }
				}
			
		   }
			 if(j == 3)
             {		
      
           	 if(s2[j].equals(find))
              {
           		String form = s2[0]+" - "+s2[1]+" - "+s2[2]+" - "+s2[j];
               	alt.add(form);
               	tagCount++;
               	 continue xyz;
                 }
                
              }
		   }
		}
	
		totalCount =  descriptionCount + nameCount + tagCount;
		
		System.out.println("Total number of occurances :"+totalCount);
		System.out.println();
		if(descriptionCount > 0)
		{	
		 System.out.println("Number of occurances in description: "+descriptionCount);
		 System.out.println();
		 System.out.println("Matches found:");
		 System.out.println();
	     for(int k = 0; k < ald.size(); k++)
	     {
	    	System.out.println(ald.get(k));
	    	System.out.println();
	     }
		} 
		if(nameCount > 0)
		{
	     System.out.println("Number of occurances in name: "+nameCount);
	     System.out.println();
		 System.out.println("Matches found:");
		 System.out.println();
	     for(int k = 0; k < aln.size(); k++)
	     {
	    	System.out.println(aln.get(k));
	    	System.out.println();
	     }
		}
		if(tagCount > 0)
		{	
	     System.out.println("Number of occurances in tag: "+tagCount);
	     System.out.println();
		 System.out.println("Matches found:");
		 System.out.println();
	     for(int k = 0; k < alt.size(); k++)
	     {
	    	System.out.println(aln.get(k));
	    	System.out.println();
	     }
		} 
	}	
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				} 
				catch (IOException e)
				{
					
					e.printStackTrace();
				}
			}
			
		}
	}
}	