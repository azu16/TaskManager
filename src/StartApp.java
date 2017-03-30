import java.awt.List;
import java.io.File;
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
	     int priority;
	     String tag;
	     String dt;
		 int ch = 0;
		 
		
		 String categoryName = null;
		 Date d;
		 SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		 TaskBeans bean ;
		 
		  
abc:         for(;;)
		      {
			  System.out.println("Press 1 to Create Category");
			  System.out.println("Press 2 to Load Category");
			  System.out.println("Press 3 to Search");
	          System.out.println("Press 4 to List");
	          System.out.println("Press 5 to Exit");
	          System.out.println("Enter the choice");
	          ch =  CategoryUtil.checkChoice();
		      
	    
        switch(ch)
        {
         case 1: 
        	    System.out.println("Enter name of category");
        	    categoryName = sc2.nextLine();
        	    CategoryUtil.checkStrings(categoryName);
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
                choice =  CategoryUtil.checkChoice();
                
         	    switch(choice)
         	    {
         	    case 1:
         	    	   System.out.println("Enter the task name");
             	       String taskName1 = sc2.nextLine();
             	       taskName = CategoryUtil.checkStrings(taskName1);
             	       boolean b2 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
             	       while(b2 == true)
             	       {
             	    	   System.out.println("Task already exists please give another task name");
             	    	   taskName = sc2.nextLine();
             	    	   b2 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
             	       }
             	       System.out.println("Enter description");
             	       String description1 = sc2.nextLine();
             	      description = CategoryUtil.checkStrings(description1);
             	       System.out.println("Enter priority(1-5)");
             	       priority =  CategoryUtil.checkChoice();
             	       
             	       System.out.println("Enter tag(tag1,)");
             	       String tag1 = sc2.nextLine();
             	       tag =  CategoryUtil.checkStrings(tag1);
             	       java.util.Date d3 = null;
            	       System.out.println("Enter dueDate(dd/MM/yyyy)");
             	       String due = sc2.nextLine(); 
             	       java.util.Date dueDate = sd.parse(due);
             	      java.util.Date dt1 = new java.util.Date();
             	        boolean bd = dueDate.after(dt1);
             	        while(bd != true)
             	        {
             	        	System.out.println("Due Date should come after create date please enter valid date");
             	        	due = sc2.nextLine(); 
             	        	dueDate = sd.parse(due);
             	        	bd = dueDate.after(dt1);
             	        }
             	      
             	       String dt2 = sd.format(dt1);
             	       bean = new TaskBeans(taskName,description,priority,tag,dt2,due);
             	       TaskModel.addTask(bean,categoryName);
             	       System.out.println("Task "+taskName+" added successfully");
             	        TaskModel.viewTask(categoryName);
            	       break;
            	       
         	    case 2:
         	    	     System.out.println("Current tasks are:");
	    	    	     TaskModel.viewTask(categoryName);
	    	    	     boolean by = TaskModel.currentSize(categoryName);
	    	              if(by == true)
	    	              {
	    	            	  System.out.println("Category is empty please first add task");
	    	            	  break;
	    	              }
	    	              
		    	    	 
	    	    	     int ch1 = 0;
         	    	     System.out.println("Enter the Taskname");
         	    	     taskName1 = sc2.nextLine();
         	    	     taskName = CategoryUtil.checkStrings(taskName1);
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
         	    	    System.out.println("Enter ur choice");
         	    	    ch1 = CategoryUtil.checkChoice();
  	    	    	    
         	    	    TaskModel.editTask(categoryName,taskName,ch1);
         	    	    System.out.println(taskName+" edited successfully");
         	    	    TaskModel.viewTask(categoryName);
  	    	    	     
         	    	    break;
         	    	    
         	    case 3:
         	        	System.out.println("Current tasks are:");
   	    	            TaskModel.viewTask(categoryName);
   	    	             by = TaskModel.currentSize(categoryName);
   	                     if(by == true)
   	                     {
   	            	      System.out.println("Category is empty please first add task");
   	            	       break;
   	                     }
   	                    
    	    	        System.out.println("Enter the Taskname to be removed");
    	    	        taskName1 = sc2.nextLine();
    	    	        taskName = CategoryUtil.checkStrings(taskName1);
    	    	         b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
	    	    	    while(b3 == false)
	    	    	    {
	    	    		  System.out.println("Task doesnt exist please enter the task from above list");
	    	    		  taskName = sc2.nextLine();
	    	    		  b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
	    	    	     }
    	    	        TaskModel.removeTask(categoryName,taskName);
    	    	        System.out.println(taskName+"removed successfully");
         	    	    TaskModel.viewTask(categoryName);
    	    	       break;
    	    	      
         	    case 4:
         	    	    int ch2 = 0;
         	    	     by = TaskModel.currentSize(categoryName);
 	                     if(by == true)
 	                     {
 	            	      System.out.println("Category is empty please first add task");
 	            	       break;
 	                     }
	    	            System.out.println("Enter 1 to list tasks in alphabetical order of name");
         	    	    System.out.println("Enter 2 to list tasks by create date");
         	    	    System.out.println("Enter 3 to list tasks by due date");
         	    	    System.out.println("Enter 4 to list tasks by longest time");
         	    	    System.out.println("Enter ur choice");
         	    	    ch2 = CategoryUtil.checkChoice();
         	    	    TaskModel.listTasks(categoryName,ch2);
         	    	    
	    	           break;
	    	           
         	    case 5:
         	    	     by = TaskModel.currentSize(categoryName);
                        if(by == true)
                         {
            	         System.out.println("Category is empty please first add task");
            	         break;
                         }
         	    	    System.out.println("Current tasks are:");
	    	            TaskModel.viewTask(categoryName);
	    	            System.out.println("Enter the word to be searched");
	    	            String find1 = sc2.nextLine();
	    	            String find = CategoryUtil.checkStrings(find1);
	    	            TaskModel.search(categoryName,find);
	    	            break;
	    	            
         	    case 6:
         	    	         continue abc;
         	   
         	    default:
         	              System.out.println("Please enter valid choices ");
         	              break;
         	    } 
                
         	    }
        	    
         case 2:
        	     System.out.println("Enter the category to load");
        	     String categoryName1 = sc2.nextLine();
        	     categoryName = CategoryUtil.checkStrings(categoryName1);
        	     boolean b4 = CategoryUtil.checkIfCategoryExists(categoryName);
        	      int choice1 = 0;
        	     while(b4 == false)
        	     {
        	    	 System.out.println("Category doesn't exist please give a existing category name");
        	    	 categoryName = sc2.nextLine();
        	    	 b4 = CategoryUtil.checkIfCategoryExists(categoryName);
        	     }
        	         System.out.println("Category "+categoryName+" loaded successfully");
        	         
        	         while(choice1 != 6)
            	     {
        	         System.out.println("Press 1 to Add a Task");
           	         System.out.println("Press 2 to Edit a Task");
           	         System.out.println("Press 3 to Remove a Task");
                     System.out.println("Press 4 to List the Tasks");
                     System.out.println("Press 5 to Search");
                     System.out.println("Press 6 to go back");
                     System.out.println("Enter ur choice");
                     choice1 = CategoryUtil.checkChoice();
                     
                    
                     switch(choice1)
                     {
                     case 1:
           	    	          System.out.println("Enter the task name");
               	              String taskName1 = sc2.nextLine();
               	              taskName = CategoryUtil.checkStrings(taskName1);
               	              boolean b2 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
               	              while(b2 == true)
               	              {
               	    	        System.out.println("Task already exists please give another task name");
               	    	        taskName = sc2.nextLine();
               	    	        b2 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
               	              }
               	                
               	               System.out.println("Enter description");
               	               String description1 = sc2.nextLine();
               	               description = CategoryUtil.checkStrings(description1);
               	               System.out.println("Enter priority(1-5)");
               	               priority =  CategoryUtil.checkChoice();
               	               System.out.println("Enter tag(tag1,)");
              	               String tag1 = sc2.nextLine();
              	               tag = CategoryUtil.checkStrings(tag1);
              	               java.util.Date dt1 = new java.util.Date();
              	               System.out.println("Enter dueDate(dd/mm/yyyy)");
               	               String due = sc2.nextLine(); 
               	               java.util.Date dueDate = sd.parse(due);
                 	           boolean bd = dueDate.after(dt1);
                 	            while(bd != true)
                 	           {
                 	        	System.out.println("Due Date should come after create date please enter valid date ");
                 	        	due = sc2.nextLine(); 
                 	        	dueDate = sd.parse(due);
                 	        	bd = dueDate.after(dt1);
                 	           }
               	            //   java.util.Date dueDate = sd.parse(due);
               	              
               	                 String dt2 = sd.format(dt1);
               	               bean = new TaskBeans(taskName,description,priority,tag,dt2,due);
               	               TaskModel.addTask(bean,categoryName);
               	               System.out.println("Task "+taskName+" added successfully");  
               	               break;
               	               
                     case 2:
                    	  	   System.out.println("Current tasks are:");
	    	    	           TaskModel.viewTask(categoryName);
	    	    	           boolean by = TaskModel.currentSize(categoryName);
	   	                       if(by == true)
	   	                       {
	   	            	        System.out.println("Category is empty please first add task");
	   	            	        break;
	   	                        }
         	    	           System.out.println("Enter the Taskname");
         	    	           taskName1 = sc2.nextLine();
         	    	            int ch3 = 0;
         	    	           taskName = CategoryUtil.checkStrings(taskName1);
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
         	    	          System.out.println("Enter ur choice");
         	    	          ch3 =  CategoryUtil.checkChoice();
         	    	          TaskModel.editTask(categoryName,taskName,ch3);
         	    	          System.out.println(taskName+" edited successfully");
              	    	      TaskModel.viewTask(categoryName);
  	    	    	           
         	    	           break;
         	    	           
                     case 3:
                    	      System.out.println("Current tasks are:");
    	    	              TaskModel.viewTask(categoryName);
    	    	               by = TaskModel.currentSize(categoryName);
    	    	              if(by == true)
    	    	              {
    	    	            	  System.out.println("please first add task and then remove them");
    	    	            	  break;
    	    	              }
     	    	              System.out.println("Enter the Taskname to be removed");
     	    	              taskName1 = sc2.nextLine();
     	    	              taskName = CategoryUtil.checkStrings(taskName1);
     	    	              b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
 	    	    	          while(b3 == false)
 	    	    	          {
 	    	    		       System.out.println("Task doesnt exist please enter the task from above list");
 	    	    		       taskName = sc2.nextLine();
 	    	    		       b3 = CategoryUtil.checkIfTaskNameExists(categoryName,taskName);
 	    	    	          }
     	    	              TaskModel.removeTask(categoryName,taskName);
     	    	              System.out.println(taskName+"removed successfully");
              	    	      TaskModel.viewTask(categoryName);
     	    	              break;
     	    	              
                     case 4:
                    	      int ch4 = 0;
                    	      by = TaskModel.currentSize(categoryName);
      	                      if(by == true)
      	                      {
      	            	       System.out.println("Category is empty please first add task");
      	            	       break;
      	                      }
                    	      System.out.println("Enter 1 to list tasks in alphabetical order of name");
          	    	         System.out.println("Enter 2 to list tasks by create date");
          	    	         System.out.println("Enter 3 to list tasks by due date");
          	    	         System.out.println("Enter 4 to list tasks by longest time");
          	    	         System.out.println("Enter ur choice");
          	    	         ch = CategoryUtil.checkChoice();
          	    	         
 	    	                 TaskModel.listTasks(categoryName,ch);
                    	      
 	    	                 break;
 	    	                 
                     case 5:
                    	      System.out.println("Current tasks are:");
	    	                  TaskModel.viewTask(categoryName);
                    	      by = TaskModel.currentSize(categoryName);
 	                          if(by == true)
 	                          {
 	            	          System.out.println("Category is empty please first add task");
 	            	           break;
 	                          }
                    	    
 	    	                System.out.println("Enter the word to be searched");
 	    	                String find1 = sc2.nextLine();
 	    	                String find = CategoryUtil.checkStrings(find1);
 	    	                TaskModel.search(categoryName,find);
 	    	                break;
 	    	                
                     case 6:
                    	       continue abc;
                    	       
                     default:
                    	        System.out.println("please enter a valid choice");
                     }
           	        }
           	        break;
        	      
        	     
         case 3:
        	     
        	     System.out.println("Enter the category to be searched");
        	     categoryName1 = sc2.nextLine();
        	     categoryName = CategoryUtil.checkStrings(categoryName1);
        	     boolean b6 = CategoryUtil.checkIfCategoryExists(categoryName);
        	     if(b6 == true)
        	     {
        	    	 System.out.println("Category "+categoryName+" found");
        	     }
        	     else
        	    	 System.out.println("Category "+categoryName+" not found");
        	       continue abc;
        	     
         case 4:
        	     System.out.println("List of categories are:");
        	     TaskModel.listCategory();        	     
        	      continue abc;
        	     
         case 5:
        	        
        	        break;
        	     
        default:
        	     System.out.println("please enter correct choice from above menu");
        	      continue abc;
        	
        	   
        	     
        }
           break;
			 } 
		 if(ch == 5)
		 System.out.println("Good Bye");
		 
		 } 
        }

	

