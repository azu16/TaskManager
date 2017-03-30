import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class LongestComparator implements Comparator<TaskBeans> {

	public int compare(TaskBeans arg0, TaskBeans arg1) {
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d1 = sd.parse(arg0.getCreateDate());
			Date d2 = sd.parse(arg0.getDueDate());
			Date d3 = sd.parse(arg1.getCreateDate());
			Date d4 = sd.parse(arg1.getDueDate());
			int c1 = (int)(d2.getTime()-d1.getTime());
			int c2 = (int )(d4.getTime()-d3.getTime());
			 return c1-(c2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
     
}
