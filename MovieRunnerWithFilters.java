
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;
public class MovieRunnerWithFilters {
    
    public void  printAverageRatings(){
         ThirdRatings tr=new ThirdRatings("ratings.csv");
        // System.out.println(tr.getRaterSize());
         
         //MovieDatabase.initialize("ratedmoviesfull.csv");
         
         //System.out.println(MovieDatabase.size());
        ArrayList<Rating>rat=tr.getAverageRatings(35);
        System.out.println(rat.size());
        //Collections.sort(rat);
       //for(Rating r : rat){
         //   System.out.println(r.getValue()+"\t"+ MovieDatabase.getTitle(r.getItem()));
            //System.out.println(r);
        //}
        
        }
        
     public void printAverageRatingsByYear(){
           ThirdRatings tr=new ThirdRatings("ratings.csv");
         System.out.println(tr.getRaterSize());
         
         MovieDatabase.initialize("ratedmoviesfull.csv");
         
         System.out.println(MovieDatabase.size());
        ArrayList<Rating>rat=tr.getAverageRatingsByFilter(20,new YearAfterFilter(2000));
        System.out.println(rat.size());
        //Collections.sort(rat);
      // for(Rating r : rat){
            //System.out.println(r.getValue()+"\t"+ MovieDatabase.getYear(r.getItem()) +"\t"+MovieDatabase.getTitle(r.getItem()) );
            //System.out.println(r);
        //}
        }
        
    public void printAverageRatingsByGenre(){
           ThirdRatings tr=new ThirdRatings("ratings.csv");
         //System.out.println(tr.getRaterSize());
         
         MovieDatabase.initialize("ratedmoviesfull.csv");
         
         //System.out.println(MovieDatabase.size());
         Filter genrefilter = new GenreFilter("Comedy");
        ArrayList<Rating>rat=tr.getAverageRatingsByFilter(20,genrefilter);
        System.out.println(rat.size());
        // Collections.sort(rat);
       //for(Rating r : rat){
         //   System.out.println(r.getValue()+"\t"+MovieDatabase.getTitle(r.getItem()) );
         //   System.out.println(MovieDatabase.getGenres(r.getItem()));
        //}
        }
        
   public void printAverageRatingsByMinutes(){
           ThirdRatings tr=new ThirdRatings("ratings.csv");
         //System.out.println(tr.getRaterSize());
         
         MovieDatabase.initialize("ratedmoviesfull.csv");
         
        // System.out.println(MovieDatabase.size());
         Filter minutefilter = new MinutesFilter(105,135);
        ArrayList<Rating>rat=tr.getAverageRatingsByFilter(5,minutefilter);
        System.out.println(rat.size());
       //  Collections.sort(rat);
       //for(Rating r : rat){
         //   System.out.println(r.getValue()+"\t Time: "+ MovieDatabase.getMinutes(r.getItem())+"\t"+MovieDatabase.getTitle(r.getItem()) );
           
        //}
        }
        
         public void printAverageRatingsByDirectors(){
           ThirdRatings tr=new ThirdRatings("ratings.csv");
       //  System.out.println(tr.getRaterSize());
         
         //MovieDatabase.initialize("ratedmoviesfull.csv");
         
       //  System.out.println(MovieDatabase.size());
         Filter directorfilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating>rat=tr.getAverageRatingsByFilter(4,directorfilter);
        System.out.println(rat.size());
       //  Collections.sort(rat);
      // for(Rating r : rat){
        //     System.out.println(r.getValue()+"\t"+MovieDatabase.getTitle(r.getItem()) );
        //    System.out.println(MovieDatabase.getDirector(r.getItem()));
           
        //}
        

     }
     
     public void printAverageRatingsByYearAfterAndGenre(){
         ThirdRatings tr=new ThirdRatings("ratings.csv");
         //System.out.println(tr.getRaterSize());
         
         MovieDatabase.initialize("ratedmoviesfull.csv");
         //System.out.println(MovieDatabase.size());
         AllFilters all =new AllFilters();
         Filter genrefilter = new GenreFilter("Drama");
         Filter yearafterfilter= new YearAfterFilter(1990) ;
         all.addFilter(genrefilter);
         all.addFilter(yearafterfilter);
        ArrayList<Rating>rat=tr.getAverageRatingsByFilter(8,all);
        System.out.println(rat.size());
         //Collections.sort(rat);
       //for(Rating r : rat){
         //   System.out.println(r.getValue()+"\t"+ MovieDatabase.getYear(r.getItem()) +"\t"+MovieDatabase.getTitle(r.getItem()) );
         //   System.out.println(MovieDatabase.getGenres(r.getItem()));
        //}
        

     }
     
       
     public void printAverageRatingsByDirectorsAndMinutes(){
         ThirdRatings tr=new ThirdRatings("ratings.csv");
         //System.out.println(tr.getRaterSize());
         
         MovieDatabase.initialize("ratedmoviesfull.csv");
         //System.out.println(MovieDatabase.size());
         AllFilters all =new AllFilters();
         Filter directorfilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
         Filter minutefilter = new MinutesFilter(90,180);
         all.addFilter(directorfilter);
         all.addFilter(minutefilter);
        ArrayList<Rating>rat=tr.getAverageRatingsByFilter(3,all);
        System.out.println(rat.size());
         //Collections.sort(rat);
      // for(Rating r : rat){
        //  System.out.println(r.getValue()+"\t Time: "+ MovieDatabase.getMinutes(r.getItem())+"\t"+MovieDatabase.getTitle(r.getItem()) );
          //System.out.println(MovieDatabase.getDirector(r.getItem()));
        //}
        

     }
}
