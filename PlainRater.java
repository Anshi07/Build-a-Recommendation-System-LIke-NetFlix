
/**
 * Write a description of class Rater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class PlainRater implements Rater {
    private String myID;
    private ArrayList<Rating> myRatings;

    public PlainRater(String id) {
        myID = id;
        myRatings = new ArrayList<Rating>();
    }

    public void addRating(String item, double rating) {
        myRatings.add(new Rating(item,rating));
    }

    public boolean hasRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return true;
            }
        }
        
        return false;
    }

    public String getID() {
        return myID;
    }
    
    public double getRating(String item) {
        for(int k=0; k < myRatings.size(); k++){
            if (myRatings.get(k).getItem().equals(item)){
                return myRatings.get(k).getValue();
            }
        }
        
        return -1;
    }

    public int numRatings() {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
         for(int k=0; k < myRatings.size(); k++){
            String str=myRatings.get(k).getItem();
             //Hlist.add(str);
             list.add(str);
            }
         
        return list;
    }
    public ArrayList<Rating> getRatingItemsRated() {
         ArrayList<Rating> list = new ArrayList<Rating>();
            for(int k=0; k < myRatings.size(); k++){
             String s=myRatings.get(k).getItem();
            Rating r=new Rating(s,getRating(s));
            list.add(r);
            }
         
        return list;
    }
}
