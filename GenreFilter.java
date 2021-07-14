
/**
 * Write a description of GenreFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GenreFilter implements Filter {
      private String myGenre;
	
	public GenreFilter(String Genre) {
		myGenre = Genre;
	}
	
	
	public boolean satisfies(String id) {
           String str =MovieDatabase.getGenres(id);
           String[] output=str.split(", ");
           for(String s:output){
              if(s.equals(myGenre)) return true; 
         }
         return false;
    }
}
