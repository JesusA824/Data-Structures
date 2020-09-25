import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class PlayersWin {
    public static void main(String[] args){
        List<Integer> mahlist=new ArrayList<Integer>();

            mahlist.add(33);
            mahlist.add(21);
            mahlist.add(5);
            mahlist.add(5);
            mahlist.add(2);
            int k=3;

        System.out.println(numPlayers(k,mahlist));

    }
    /*
    the idea of this code was to grab the highest scores of the players in the
    game. That is, given a k=n(some number) the highest n scores will be the players
    who receive points. In this case is 3 so 4 players will receive points with scores
    33,21,5,5. A way to think about is have 1st 2nd and 3rd place. Here the numPlayers
    will return 4 because two players tied for the score 5.
    The passing scores here are 33,21,5,5.
     */
    public static int numPlayers(int k, List<Integer> scores){
        Collections.reverse(scores); //sort the list so the highest scores are first

        int count =0; //counter variable to get the passing players
        for(int i=0; i< scores.size();i++){
            for(int j=i+1; j< scores.size();j++){ //nested loop to iterate through the list
                //if the count is less than k since we start from 0 and or is two scores are the same (tied)
                //count the number of passing players
                if(count<k || scores.get(i)==scores.get(j)) {
                    count++;
                }
            }

        }
        return count;
    }
}

