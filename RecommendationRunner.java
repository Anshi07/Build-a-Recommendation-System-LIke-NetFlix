
/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class RecommendationRunner implements Recommender{
    
   public ArrayList<String> getItemsToRate (){
       ArrayList<String> movies=new ArrayList<String>();
     ArrayList<String> list = MovieDatabase.filterBy(new TrueFilter());
       for(String id:list){
           if(movies.size()<=10){
               movies.add(id);
            }
       }
       
       return movies;
    }
    
   public void printRecommendationsFor (String webRaterID){
         FourthRatings fr=new FourthRatings();
         RaterDatabase.initialize("ratings.csv");
         MovieDatabase.initialize("ratedmoviesfull.csv");
         ArrayList<Rating>rat=fr.getSimilarRatings(webRaterID,10,5);
         if(rat.size()==0){
            System.out.print("<html><h3>No Movies were Found.Try Again !!!</h3></html>"); 
         }
         else{
         
         for(int i=0;i<=10 && i<rat.size();i++){
          //System.out.println(MovieDatabase.getTitle(rat.get(i).getItem()));
          System.out.println("<style>.movieTitle{color:blue;text-align:center;border-color:grey;border-style:outset;font-size:20px;border-width:2px;}");
          System.out.println(".movTab{border-collapse: collapse} </style>");
          String MovieTitle=MovieDatabase.getTitle(rat.get(i).getItem());
          System.out.print("<html><table class=\"movTab\">");
          System.out.print("<tr class=\"movieTitle\"><th class=\"movHead\">" + MovieTitle +"</th></tr>");
          System.out.print("</table></html>");
          
        }
     }
       
    }
   
   
}
