
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class MovieRunnerSimilarRatings {
    
     public void  printAverageRatings(){
         FourthRatings fr=new FourthRatings();
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
        ArrayList<Rating>rat=fr.getAverageRatings(35);
        System.out.println(rat.size());
        
        //Collections.sort(rat);
       //for(Rating r : rat){
         //   System.out.println(r.getValue()+"\t"+ MovieDatabase.getTitle(r.getItem()));
            //System.out.println(r);
        //}
        
        }
        
       public void printAverageRatingsByYearAfterAndGenre(){
    
          FourthRatings fr=new FourthRatings();
         
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
         AllFilters all =new AllFilters();
         Filter genrefilter = new GenreFilter("Drama");
         Filter yearafterfilter= new YearAfterFilter(1990) ;
         all.addFilter(genrefilter);
         all.addFilter(yearafterfilter);
        ArrayList<Rating>rat=fr.getAverageRatingsByFilter(8,all);
        System.out.println(rat.size());
         //Collections.sort(rat);
       //for(Rating r : rat){
         //   System.out.println(r.getValue()+"\t"+ MovieDatabase.getYear(r.getItem()) +"\t"+MovieDatabase.getTitle(r.getItem()) );
         //   System.out.println(MovieDatabase.getGenres(r.getItem()));
        //}
        
    }
    
    public void printSimilarRatings(){
        FourthRatings fr=new FourthRatings();
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
         
         ArrayList<Rating>rat=fr.getSimilarRatings("71",20,5);
         System.out.println(MovieDatabase.getTitle(rat.get(0).getItem()));
        //System.out.println(rat.size());
        //for(Rating r : rat){
          // System.out.println(r.getValue()+"\t"+ MovieDatabase.getTitle(r.getItem()));
         // }
    }
    
      public void printSimilarRatingsByGenre(){
        FourthRatings fr=new FourthRatings();
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
         Filter genrefilter = new GenreFilter("Mystery");
         ArrayList<Rating>rat=fr.getSimilarRatingsByFilter("964",20,5,genrefilter);
         System.out.println(MovieDatabase.getTitle(rat.get(0).getItem()));
       // System.out.println(rat.size());
        //for(Rating r : rat){
          // System.out.println(r.getValue()+"\t"+ MovieDatabase.getTitle(r.getItem()));
         // }
    }
     public void printSimilarRatingsByDirector(){
        FourthRatings fr=new FourthRatings();
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
         Filter directorfilter = new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
         ArrayList<Rating>rat=fr.getSimilarRatingsByFilter("120",10,2,directorfilter);
         System.out.println(MovieDatabase.getTitle(rat.get(0).getItem()));
        //System.out.println(rat.size());
        //for(Rating r : rat){
          // System.out.println(r.getValue()+"\t"+ MovieDatabase.getTitle(r.getItem()));
         // }
    }
    
        public void printSimilarRatingsByGenreAndMinutes(){
    
          FourthRatings fr=new FourthRatings();
         
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
         AllFilters all =new AllFilters();
         Filter genrefilter = new GenreFilter("Drama");
         Filter minutefilter = new MinutesFilter(80,160);
         all.addFilter(genrefilter);
         all.addFilter(minutefilter);
          ArrayList<Rating>rat=fr.getSimilarRatingsByFilter("168",10,3,all);
          System.out.println(MovieDatabase.getTitle(rat.get(0).getItem()));
        //System.out.println(rat.size());
        //for(Rating r : rat){
          // System.out.println(r.getValue()+"\t"+ MovieDatabase.getTitle(r.getItem()));
         // }
       
        
    }
     
        public void printSimilarRatingsByYearAfterAndMinutes(){
    
          FourthRatings fr=new FourthRatings();
         
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
         AllFilters all =new AllFilters();
         Filter yearafterfilter= new YearAfterFilter(1975) ;
         Filter minutefilter = new MinutesFilter(70,200);
         all.addFilter(yearafterfilter);
         all.addFilter(minutefilter);
          ArrayList<Rating>rat=fr.getSimilarRatingsByFilter("314",10,5,all);
          System.out.println(MovieDatabase.getTitle(rat.get(0).getItem()));
        //System.out.println(rat.size());
        //for(Rating r : rat){
          // System.out.println(r.getValue()+"\t"+ MovieDatabase.getTitle(r.getItem()));
          //}
       
        
    }

}
