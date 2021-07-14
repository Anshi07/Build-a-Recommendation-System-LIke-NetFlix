
/**
 * Write a description of FirstRating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRating {
    public ArrayList <Movie> loadMovies(String filename){
         ArrayList <Movie> res=new  ArrayList <Movie>();
        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        for(CSVRecord record:parser){
            Movie mov=new Movie(record.get("id"),record.get("title"),record.get("year"),record.get("genre"),record.get("director"),
                           record.get("country"),record.get("poster"),Integer.parseInt(record.get("minutes") ) );
                         
            res.add(mov);
        }
        return res;
    }
    
       public ArrayList <Rater> loadRaters(String filename){
         ArrayList<Rater> list = new ArrayList<Rater>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        String prevID="";
        for (CSVRecord record : parser){
             String id=record.get("rater_id");
              if(!id.equals(prevID)){
             // Rater ra= new PlainRater(id);
             Rater ra= new EfficientRater(id);
              ra.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")) );
              list.add(ra);
              prevID=id;
            }
            else{
              for(Rater r : list){
               if(r.getID().equals(id))
               r.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")) ) ;
              }
            }
             
            
          
        }
        
        return list;
    }

}


