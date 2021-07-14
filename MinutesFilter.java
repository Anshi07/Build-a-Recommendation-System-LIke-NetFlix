
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter {
    
     private int Mymin;
     private int Mymax;
	
	public MinutesFilter(int min,int max) {
		Mymin=min;
		Mymax=max;
	}
	
	
	public boolean satisfies(String id) {
		//return MovieDatabase.getYear(id) >= myYear;
		int res=MovieDatabase.getMinutes(id);
		if(res>=Mymin && res<=Mymax){
		    return true;
		  }
		return false;
	}

}
