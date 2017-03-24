import java.awt.List;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StartApp {
    
	public static void main(String[] args) throws ParseException, IOException {
	  	
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		 String taskName;
	     String description;
	     String priority;
	     String tag;
	     String dt;
		 int ch = 0;
		 String categoryName = null;
		 Date d;
		 SimpleDateFormat sd = new SimpleDateFormat("dd/mm/yyyy");
		 TaskBeans bean ;
		  System.out.println("Press 1 to Create Category");
		  System.out.println("Press 2 to Load Category");
		  System.out.println("Press 3 to Search");
          System.out.println("Press 4 to List");
          System.out.println("Press 5 to Exit");
          System.out.println("Enter the choce");
          ch = sc1.nextInt();
		
        switch(ch)
        {
         case 1: 
        	    System.out.println("Enter name of category");
        	    categoryName = sc2.nextLine();
        	    int choice = 0;
         	    boolean b1 = CategoryUtil.checkIfCategoryExists(categoryName);
         	    while(b1 == true)
         	    {
         	    	System.out.println("Name already exist given another name");
         	    	categoryName = sc2.nextLine();
         	    	b1 =  CategoryUtil.checkIfCategoryExists(categoryName);
         	    }	
         	    TaskModel.createCategory(categoryName); 
         	   System.out.println("Category "+categoryName+" created successfully");
         	   for(;;)
         	   {   
         	    System.out.println("Press 1 to Add a Task");
         	    System.out.println("Press 2 to Edit a Task");
         	    System.out.println("Press 3 to Remove a Task");
                System.out.println("Press 4 to List the Tasks");
                System.out.println("Press 5 to Search");
                System.out.println("Press 6 to Go back");
                System.out.println("Enter ur choice");
                choice = sc1.nextInt();
         	    switch(choice)
         	    {
         	    case 1:
         	    	   System.out.println("Enter the task name");
             	       taskName = sc2.nextLine();
             	       boolean b2 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
             	       while(b2 == true)
             	       {
             	    	   System.out.println("Task already exists please give another task name");
             	    	   taskName = sc2.nextLine();
             	    	   b2 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
             	       }
             	       System.out.println("Enter description");
             	       description = sc2.nextLine();
             	       System.out.println("Enter priority");
             	       priority = sc2.nextLine();
             	       System.out.println("Enter tag");
            	       tag = sc2.nextLine();
            	       System.out.println("Enter dueDate(dd/mm/yyyy)");
             	       String due = sc2.nextLine(); 
             	       java.util.Date dueDate = sd.parse(due);
             	       java.util.Date dt1 = new java.util.Date();
             	       java.util.Date dt2 = dt1;
             	       bean = new TaskBeans(taskName,description,priority,tag,dt2,dueDate);
             	       TaskModel.addTask(bean,categoryName);
             	       System.out.println("Task "+taskName+" added successfully");
            	       break;
            	       
         	    case 2:
         	    	     System.out.println("Current tasks are:");
	    	    	     TaskModel.viewTask(categoryName);
         	    	     System.out.println("Enter the Taskname");
         	    	     taskName = sc2.nextLine();
         	    	     boolean b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
  	    	    	     while(b3 == false)
  	    	    	     {
  	    	    		   System.out.println("Task doesnt exist please enter the task from above list");
  	    	    		   taskName = sc2.nextLine();
  	    	    		   b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
  	    	    	     }
         	    	    System.out.println("Enter 1 to edit a taskname");
         	    	    System.out.println("Enter 2 to edit a description");
         	    	    System.out.println("Enter 3 to edit a priority");
         	    	    System.out.println("Enter 4 to edit a tags");
         	    	    System.out.println("Enter 5 to edit a date");
         	    	    System.out.println("Enter 6 to go back");
         	    	    System.out.println("Enter ur choice");
         	    	    ch = sc1.nextInt();
         	    	   TaskModel.editTask(categoryName,taskName,ch);
         	    	    break;
         	    	    
         	    case 3:
         	        	System.out.println("Current tasks are:");
   	    	            TaskModel.viewTask(categoryName);
    	    	        System.out.println("Enter the Taskname to be removed");
    	    	        taskName = sc2.nextLine();
    	    	         b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
	    	    	    while(b3 == false)
	    	    	    {
	    	    		  System.out.println("Task doesnt exist please enter the task from above list");
	    	    		  taskName = sc2.nextLine();
	    	    		  b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
	    	    	     }
    	    	        TaskModel.removeTask(categoryName,taskName);
    	    	       break;
    	    	      
         	    case 4:
         	    	    System.out.println("Current tasks are:");
	    	            TaskModel.viewTask(categoryName);
	    	            System.out.println("Enter 1 to list tasks in alphabetical order of name");
         	    	    System.out.println("Enter 2 to list tasks by due date");
         	    	    System.out.println("Enter 3 to list tasks by created date");
         	    	    System.out.println("Enter 4 to list tasks by longest time");
         	    	    System.out.println("Enter ur choice");
         	    	    ch = sc1.nextInt();
	    	           TaskModel.listTasks(categoryName,ch);
	    	           break;
	    	           
         	    case 5:
         	    	    System.out.println("Current tasks are:");
	    	            TaskModel.viewTask(categoryName);
	    	            System.out.println("Enter the word to be searched");
	    	            String find = sc2.nextLine();
	    	            TaskModel.search(categoryName,find);
	    	            break;
         	    } 
         	    
         	   }   
        	    
         case 2:
        	     System.out.println("2");
        	     break;
        	     
         case 3:
        	     System.out.println("3");
        	     break;
        	     
         case 4:
        	     System.out.println("4");
        	     break;
        	     
         case 5:
        	     System.out.println("5");
        	     break;
        	     
        default:
        	    System.out.println("Press 1 to Create Category");
    		    System.out.println("Press 2 to Load Category");
    		    System.out.println("Press 3 to Search");
                System.out.println("Press 4 to List");
                System.out.println("Press 5 to Exit");
                System.out.println("Enter the choce");
                ch = sc1.nextInt();
        	     
        }
        }
	}

