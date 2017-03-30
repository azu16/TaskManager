import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class DateComaparator implements Comparator<TaskBeans> {

	public int compare(TaskBeans arg0, TaskBeans arg1) {
		 String s1 = arg0.getDueDate();
		 String s2 = arg1.getDueDate();
		 Date d1 = null;
		 Date d2 = null;
		  SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		  try {
			   d1 = sd.parse(s1);
			   d2 = sd.parse(s2);
			   return d1.compareTo(d2);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
		  
		
	//	  long d3 = d1.getTime();
	//	  long d4 = d2.getTime();
		 // return d1.compareTo(d2);
	}
	

}