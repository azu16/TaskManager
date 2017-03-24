import java.util.Date;


public class TaskBeans {
	 
	private String taskName;
	private String description;
	private String priority;
	private String tag;
	private Date dueDate;
	private Date createDate;
	public TaskBeans()
	{
		
	}
	public TaskBeans(String taskName,String description,String priority,String tag,Date createDate,Date dueDate)
	{
		this.taskName = taskName;
		this.description = description;
		this.priority = priority;
		this.tag = tag;
		this.createDate = createDate;
		this.dueDate = dueDate;
	}
    public String getTaskName()
    {
    	 return taskName;
    }
    public String getDescription()
    {
    	 return description;
    }
    public String getPriority()
    {
    	 return priority;
    }
    public String getTag()
    {
    	 return tag;
    }
    public Date getcreateDate()
    {
    	return createDate;
    }
    public Date getDueDate()
    {
    	 return dueDate;
    }
}
