
/**
 * Write a description of SecondRating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    
    public SecondRatings(String moviefile,String ratingsfile) {
       FirstRating fr=new FirstRating();
       myMovies=fr.loadMovies(moviefile);
       myRaters=fr.loadRaters(ratingsfile);
       
    }
    
    public int getMovieSize(){
        return myMovies.size();
    }
    
        public int getRaterSize(){
        return myRaters.size();
    }
    
    public String getTitle(String id){
        for(Movie m : myMovies){
          if(m.getID().equals(id)){
             return m.getTitle();
            }
        }
        return " ID was not found";
    }
    
        public String getID(String title){
        for(Movie m : myMovies){
          if(m.getTitle().equals(title)){
             return m.getID();
            }
        }
        return "NO SUCH TITLE.";
    }
      private double getAverageByID (String id, int minimalRaters){
        //FirstRating fr=new FirstRating();
        //ArrayList <Rater> rat=fr.loadRaters("ratings.csv");
        double sum=0;
        double avg=0.0;
        int count=0;
        for(Rater r : myRaters){
            double res=r.getRating(id);
            if(res!=-1){
                sum=sum+res;
                count++;
            }
        }
        if(count>=minimalRaters){
         avg=sum/(double)count;
         return avg;
        }
         return avg;
    }
        public ArrayList<Rating> getAverageRatings(int minimalRaters){
          
        ArrayList<Rating> res=new ArrayList<Rating>();
        //int count=0;
      // System.out.println(mov.size());
       for(Movie m : myMovies){
            double avg=getAverageByID(m.getID(),minimalRaters);
            if(avg!=0.0){
            Rating rat=new Rating(m.getID(),avg);
            res.add(rat);
           // count++;
           }
        }
       // System.out.println(count);
        return res;
    }
}
