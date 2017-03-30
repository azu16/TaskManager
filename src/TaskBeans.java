import java.util.Date;


public class TaskBeans {
	 
	private String taskName;
	private String description;
	private int priority;
	private String tag;
	private String due;
	private String createDate;
	public TaskBeans()
	{
		
	}
	public TaskBeans(String taskName,String description,int priority,String tag,String createDate,String due)
	{
		this.taskName = taskName;
		this.description = description;
		this.priority = priority;
		this.tag = tag;
		this.createDate = createDate;
		this.due = due;
	}
    public String getTaskName()
    {
    	 return taskName;
    }
   
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setDueDate(String due) {
		this.due = due;
	}
	public String getDescription()
    {
    	 return description;
    }
    public int getPriority()
    {
    	 return priority;
    }
    public String getTag()
    {
    	 return tag;
    }
    public String getcreateDate()
    {
    	return createDate;
    }
    public String getDueDate()
    {
    	 return due;
    }
    
    @Override
   	public String toString() {
   		// TODO Auto-generated method stub
   		return taskName + "::" + description + "::" + priority + "::" + tag + "::" + createDate + "::" + due;
   				 
   				
   	}
}
