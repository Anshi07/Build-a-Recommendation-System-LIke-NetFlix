
/**
 * Write a description of SecondRating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class ThirdRatings {
      private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    
    public ThirdRatings(String ratingsfile) {
       FirstRating fr=new FirstRating();
       myRaters=fr.loadRaters(ratingsfile);
       
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    
      private double getAverageByID (String id, int minimalRaters){
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
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
           for(String id:movies){
           double avg=getAverageByID(id,minimalRaters);
            if(avg!=0.0){
            Rating rat=new Rating(id,avg);
            res.add(rat);
           // count++;
           }
        }
       // System.out.println(count);
        return res;
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria ){
       ArrayList<Rating> res=new ArrayList<Rating>(); 
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
           for(String id:movies){   
           double avg=getAverageByID(id,minimalRaters);
            if(avg!=0.0){
            Rating rat=new Rating(id,avg);
            res.add(rat);
           // count++;
           }
        }
        return res;
    }
    
   
}
