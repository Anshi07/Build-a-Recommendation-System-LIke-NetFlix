
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter {
    
       private String directors;
	
	public DirectorsFilter(String Directors) {
		directors = Directors;
	}
	
	
	public boolean satisfies(String id) {
           String str =MovieDatabase.getDirector(id);
           String[] output1=str.split(", ");
           String[] output2=directors.split(",");
           for(String s2:output2){
               for(String s1:output1){
              if(s2.equals(s1)) return true; 
            }
         }
         return false;
    }
    

}
