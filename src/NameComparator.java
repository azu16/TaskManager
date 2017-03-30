import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class NameComparator implements Comparator<TaskBeans> {

	public int compare(TaskBeans arg0, TaskBeans arg1) {
		String s1 = arg0.getCreateDate();
		String s2 = arg1.getCreateDate();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d1 = sd.parse(s1);
			Date d2 = sd.parse(s2);
			return d1.compareTo(d2);
		} catch (ParseException e) {
   
			e.printStackTrace();
		}
		
	     return 0;
		
	
	}

	

	

}
