
/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FourthRatings {

    private  double getAverageByID (String id, int minimalRaters){
        double sum=0;
        double avg=0.0;
        int count=0;
        ArrayList<Rater> myRaters=RaterDatabase.getRaters();
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

    public  ArrayList<Rating> getAverageRatings(int minimalRaters){

        ArrayList<Rating> res=new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String id:movies){
            double avg=getAverageByID(id,minimalRaters);
            if(avg!=0.0){
                Rating rat=new Rating(id,avg);
                res.add(rat);
            }
        }
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
            }
        }
        return res;
    }

    private double  dotProduct(Rater r,Rater me){
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        double sum=0;
        for(String id:movies){
            double x1,x2;
            x1=r.getRating(id)-5.0;
            x2=me.getRating(id)-5.0;
            if( (x1>=-5 && x1<=5 ) && (x2>=-5 && x2<=5 )  ){
                sum=sum+(x1*x2);
            }

        }
        return sum; 
    }

    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> list = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r : RaterDatabase.getRaters()) {
            if(r!=me){
                double res=dotProduct(r,me);
                if(res > 0){
                    list.add(new Rating(r.getID(),res ));
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;

    }

    public ArrayList<Rating> getSimilarRatings(String id,int numSimilarRaters,int minimalRaters){
        ArrayList<Rating> res=new ArrayList<Rating>();
        ArrayList<Rating> AllcloseRaters=getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String movieID : movies) {
            double sum=0.0;
            int count=0;
            double avg;
            for(int k=0; k<numSimilarRaters && k<AllcloseRaters.size(); k++) {
                Rating r = AllcloseRaters.get(k);
                Rater R=RaterDatabase.getRater(r.getItem());
                double temp=R.getRating(movieID);
                if(temp!=-1){
                    double val = temp * r.getValue();
                    sum=sum+val;
                    count++;
                }

            }
            if(count>=minimalRaters){
                avg=sum/(double)count;
                res.add(new Rating(movieID,avg));
            }

        }

        Collections.sort(res, Collections.reverseOrder());
        return res;
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id ,int numSimilarRaters,int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> res=new ArrayList<Rating>();
        ArrayList<Rating> AllcloseRaters=getSimilarities(id);
        // MovieDatabase.initialize("ratedmovies_short.csv");
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String movieID : movies) {
            double sum=0.0;
            int count=0;
            double avg;
            for(int k=0; k<numSimilarRaters && k<AllcloseRaters.size(); k++) {
                Rating r = AllcloseRaters.get(k);
                Rater R=RaterDatabase.getRater(r.getItem());
                double temp=R.getRating(movieID);
                if(temp!=-1){
                    double val = temp * r.getValue();
                    sum=sum+val;
                    count++;
                }
            }
            if(count>=minimalRaters){
                avg=sum/(double)count;
                res.add(new Rating(movieID,avg));
            }

        }

        Collections.sort(res, Collections.reverseOrder());
        return res;
    }

}

        


