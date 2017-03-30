import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;


public class TaskModel {

	public static void createCategory(String categoryName) throws IOException {
		BufferedWriter bw = null;
		bw = new BufferedWriter(new FileWriter(
				"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
						+ ".txt"));
		bw.newLine();
		bw.close();
	}

	public static void addTask(TaskBeans bean, String categoryName)
			 {

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(
					"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
							+ ".txt", true));
			bw.write(bean.getTaskName() + "::" + bean.getDescription() + "::"
					+ bean.getPriority() + "::" + bean.getTag() + "::"
					+ bean.getcreateDate() + "::" + bean.getDueDate());
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(bw!=null)
					bw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	public static boolean currentSize(String categoryName) throws IOException
	{
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(
				"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
						+ ".txt"));
		String x;
		int c = 0;
		
		    int count = 0;
	
			while((x = br.readLine()) != null)
			{
		       if(x.isEmpty())
		       {
		    	   continue;
		       }
		       c = 1;
			}
			br.close();
			   	
	    if(c == 1)
	    	return false;
	    else
	    	return true;
		
		
	}

	public static void viewTask(String categoryName) throws IOException {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(
				"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
						+ ".txt"));
		String x;
		while ((x = br.readLine()) != null) {
			System.out.println(x);
		}
		br.close();
	}

	public static void editTask(String categoryName, String taskName, int ch) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		BufferedReader br = null;
		BufferedWriter bw = null;
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al1 = new ArrayList<String>();
		try {
			String x;
			String c;
			br = new BufferedReader(new FileReader(
					"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
							+ ".txt"));
			while ((x = br.readLine()) != null) {
				al.add(x);
			}
			if (ch == 1) {
				abc: for (int i = 0; i < al.size(); i++) {
					String[] s1 = al.get(i).split("::");
					for (int j = 0; j < 1; j++) {
						if (s1[j].equals(taskName)) {
							System.out.println("Enter new taskname");
							String newName = sc.nextLine();
							CategoryUtil.checkStrings(newName);
						boolean b5 = CategoryUtil.checkIfTaskNameExists(categoryName, newName);
						while(b5 == true)
						{
							System.out.println("This taskname already exist please give another name");
							newName = sc.nextLine();
							b5 = CategoryUtil.checkIfTaskNameExists(categoryName, newName);
						}
						    System.out.println(s1[j]);
							c = al.get(i).replaceFirst(s1[j], newName);
							
							al1.add(c);
							continue abc;
						}
					}
					al1.add(al.get(i));
				}
			}
			if (ch == 2) {
				abc: for (int i = 0; i < al.size(); i++) {
					String[] s1 = al.get(i).split("::");
					String y = "";
					for (int j = 0; j < 1; j++) {
						if (s1[j].equals(taskName)) {
							System.out.println("Enter new description");
							String newdescription = sc.nextLine();
							CategoryUtil.checkStrings(newdescription);
							s1[1] = newdescription;
							for(int k = 0; k < s1.length; k++)
							{
								y = y + s1[k];
								if(k < s1.length-1)
								{
									y = y + "::";
								}
							}
					
						
							al1.add(y);
							continue abc;
						}
					}
					al1.add(al.get(i));
				}
			}
			if (ch == 3) {
				abc: for (int i = 0; i < al.size(); i++) {
					String[] s1 = al.get(i).split("::");
					for (int j = 0; j < 1; j++) {
						if (s1[j].equals(taskName)) {
							System.out.println("Enter new priority");
							int newPriority = CategoryUtil.checkChoice();
							String sn = "";
							sn = sn + newPriority;
							c = al.get(i).replace(s1[j + 2], sn);
							al1.add(c);
							continue abc;
						}
					}
					al1.add(al.get(i));
				}
			}
			if (ch == 4) {
				abc: for (int i = 0; i < al.size(); i++) {
					String[] s1 = al.get(i).split("::");
					for (int j = 0; j < 1; j++) {
						if (s1[j].equals(taskName)) {
							System.out.println("Enter new tag(tag1,)");
							String newTag = sc.nextLine();
							CategoryUtil.checkStrings(newTag);
							c = al.get(i).replace(s1[j + 3], newTag);
							al1.add(c);
							continue abc;
						}
					}
					al1.add(al.get(i));
				}
			}

			if (ch == 5) {
				abc: for (int i = 0; i < al.size(); i++) {
					String[] s1 = al.get(i).split("::");
					for (int j = 0; j < 1; j++) {
						if (s1[j].equals(taskName)) {
							System.out.println("Enter new dueDate(dd/MM/yyyy)");
							String ndt = sc.nextLine();
							SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
						     java.util.Date d4 = sd.parse(ndt);	
						      java.util.Date d5 = sd.parse(s1[4]);
						      boolean by = d4.after(d5);
						      while(by !=  true)
						      { 
						    	  System.out.println("Due Date should come after create date please enter valid date");
						    	   ndt = sc.nextLine();
						    	   d4 = sd.parse(ndt);
						    	    by = d4.after(d5);
						      }  
					
							c = al.get(i).replace(s1[j + 5], ndt);
							al1.add(c);
							continue abc;
						}
					}
					al1.add(al.get(i));
				}
			}
			bw = new BufferedWriter(new FileWriter(
					"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
							+ ".txt"));
			for (int k = 0; k < al1.size(); k++) {
				bw.write(al1.get(k));
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static void removeTask(String categoryName, String taskName) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> al1 = new ArrayList<String>();
		try {
			String x;
			String c;
			br = new BufferedReader(new FileReader(
					"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
							+ ".txt"));
			while ((x = br.readLine()) != null) {
				al.add(x);
			}
             
			abc: for (int i = 0; i < al.size(); i++) {
				String[] s1 = al.get(i).split("::");
				for (int j = 0; j < 1; j++) {
					if (s1[j].equals(taskName)) {
						continue abc;
					}
				}
				al1.add(al.get(i));
			}

			bw = new BufferedWriter(new FileWriter(
					"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
							+ ".txt"));
			for (int k = 0; k < al1.size(); k++) {
				bw.write(al1.get(k));
				bw.newLine();
			}
               
                
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		
		
	}

	public static void listTasks(String categoryName, int ch) throws NumberFormatException, ParseException {
		if (ch == 1) {
			BufferedReader br = null;
			TreeSet<String> ts = new TreeSet<String>();
			try {
				br = new BufferedReader(new FileReader(
						"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
								+ ".txt"));
				String x;
				while ((x = br.readLine()) != null) {
					ts.add(x);
				}
				for (String c : ts) {
					System.out.println(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		if (ch == 2) {
			BufferedReader br = null;
			SimpleDateFormat sd = new SimpleDateFormat();
			ArrayList al = new ArrayList();
			try {
				br = new BufferedReader(new FileReader(
						"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
								+ ".txt"));
				String x;
				TaskBeans bean;
				while ((x = br.readLine()) != null) {
					if(x.isEmpty())
					{
						
						continue;
					}
			      
			      String[] sl = x.split("::");
			     
			    
			     bean = new TaskBeans(sl[0],sl[1],Integer.parseInt(sl[2]),sl[3],sl[4],sl[5]);
			  
			      al.add(bean);				
				}
			//	NameComparator nc = new NameComparator();
				Collections.sort(al,new NameComparator());
				for(int i = 0; i < al.size(); i++)
				{
					System.out.println(al.get(i));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		if (ch == 3) {
			BufferedReader br = null;
			SimpleDateFormat sd = new SimpleDateFormat();
			ArrayList al = new ArrayList();
			try {
				br = new BufferedReader(new FileReader(
						"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
								+ ".txt"));
				String x;
				TaskBeans bean;
				while ((x = br.readLine()) != null) {
					if(x.isEmpty())
					{
						continue;
					}
			      String[] sl = x.split("::");
			      bean = new TaskBeans(sl[0],sl[1],Integer.parseInt(sl[2]),sl[3],sl[4],sl[5]);
			      al.add(bean);				
				}
				
				Collections.sort(al,new DateComaparator());
				for(int i = 0; i < al.size(); i++)
				{
					System.out.println(al.get(i));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		if (ch == 4) {
			BufferedReader br = null;
			SimpleDateFormat sd = new SimpleDateFormat();
			ArrayList al = new ArrayList();
			try {
				br = new BufferedReader(new FileReader(
						"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
								+ ".txt"));
				String x;
				TaskBeans bean;
				while ((x = br.readLine()) != null) {
					if(x.isEmpty())
					{
						continue;
					}
			      String[] sl = x.split("::");
			      bean = new TaskBeans(sl[0],sl[1],Integer.parseInt(sl[2]),sl[3],sl[4],sl[5]);
			      al.add(bean);				
				}
				
				Collections.sort(al,new LongestComparator());
				for(int i = 0; i < al.size(); i++)
				{
					System.out.println(al.get(i));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}

	public static void search(String categoryName, String find) {
		BufferedReader br = null;
		int descriptionCount = 0;
		int nameCount = 0;
		int totalCount = 0;
		int tagCount = 0;
		ArrayList<String> ald = new ArrayList<String>();
		ArrayList<String> al = new ArrayList<String>();
		ArrayList<String> aln = new ArrayList<String>();
		ArrayList<String> alt = new ArrayList<String>();
		try {
			String x;

			br = new BufferedReader(new FileReader(
					"C:/Users/Azam/Desktop/My Task Manager/" + categoryName
							+ ".txt"));
			while ((x = br.readLine()) != null) {
				al.add(x);
			}

			abc: for (int i = 0; i < al.size(); i++) {
				String[] s2 = al.get(i).split("::");

				xyz: for (int j = 0; j < s2.length; j++) {
					if (j == 0) {

						if (s2[j].equals(find)) {

							aln.add(s2[j]);
							nameCount++;

							continue xyz;
						}
						continue xyz;
					}

					if (j == 1) {

						String[] s3 = s2[j].split(" ");
						for (int m = 0; m < s3.length; m++) {
							if (s3[m].equals(find)) {
								String form = s2[0] + " - " + s2[j];
								ald.add(form);
								descriptionCount++;
								continue abc;
							}
						}

					}
					if (j == 3) {

						if (s2[j].equals(find)) {
							String form = s2[0] + " - " + s2[1] + " - " + s2[2]
									+ " - " + s2[j];
							alt.add(form);
							tagCount++;
							continue xyz;
						}

					}
				}
			}

			totalCount = descriptionCount + nameCount + tagCount;

			System.out.println("Total number of occurances :" + totalCount);
			System.out.println();
			if (descriptionCount > 0) {
				System.out.println("Number of occurances in description: "
						+ descriptionCount);
				System.out.println();
				System.out.println("Matches found:");
				System.out.println();
				for (int k = 0; k < ald.size(); k++) {
					System.out.println(ald.get(k));
					System.out.println();
				}
			}
			if (nameCount > 0) {
				System.out
						.println("Number of occurances in name: " + nameCount);
				System.out.println();
				System.out.println("Matches found:");
				System.out.println();
				for (int k = 0; k < aln.size(); k++) {
					System.out.println(aln.get(k));
					System.out.println();
				}
			}
			if (tagCount > 0) {
				System.out.println("Number of occurances in tag: " + tagCount);
				System.out.println();
				System.out.println("Matches found:");
				System.out.println();
				for (int k = 0; k < alt.size(); k++) {
					System.out.println(aln.get(k));
					System.out.println();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}
	}
	public static void listCategory()
	{
		 File f1 = new File("C:/Users/Azam/Desktop/My Task Manager");	
	     File[] f2 = f1.listFiles();
	     for(File f3 : f2)
	     {
	    	 System.out.println(f3);
	     }
	}
}