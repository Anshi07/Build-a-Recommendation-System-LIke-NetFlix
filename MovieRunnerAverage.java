
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;
public class MovieRunnerAverage {

    public void  printAverageRatings(){
         SecondRatings sr=new SecondRatings();
        // System.out.println(sr.getMovieSize());
        //System.out.println(sr.getRaterSize());
       // System.out.println(sr.getID("Identity Thief") );
        //System.out.println(sr.getTitle("2024432") );
        // SecondRatings sr=new SecondRatings("ratedmovies_short.csv","ratings_short.csv");
        
        
        ArrayList<Rating>rat=sr.getAverageRatings(20);
        Collections.sort(rat);
        for(Rating r : rat){
            System.out.println(r.getValue()+"\t"+ sr.getTitle(r.getItem()) );
            //System.out.println(r);
        }
        
        }
      
      private double getAverage(String id){
        FirstRating fr=new FirstRating();
        ArrayList <Rater> rat=fr.loadRaters("ratings.csv");
        double sum=0;
        double avg=0.0;
        int count=0;
        for(Rater r : rat){
            double res=r.getRating(id);
            if(res!=-1){
                sum=sum+res;
                count++;
            }
        }
        if(count>1){
         avg=sum/(double)count;
        }
         return avg;
    }
   
    public void getAverageRatingOneMovie(){
        SecondRatings sr=new SecondRatings("ratedmoviesfull.csv","ratings.csv");
        String id= sr.getID("Vacation");
        double avg=getAverage(id);
        System.out.println(avg);
      
    }
    
  
    
    
}
