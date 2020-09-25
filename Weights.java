
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Weights {
    public static void main(String[] args) {

        List<Integer> mahlist =new ArrayList<Integer>();
        mahlist.add(2);
        mahlist.add(7);
        mahlist.add(8);
        mahlist.add(9);
        mahlist.add(10);
        int maxkey=20;
        System.out.println(numPlayers(maxkey, mahlist));
/*
Given a List of numbers and a max limit. Return the highest weight that one can carry given that limit.
 */

    }
    public static int numPlayers(int max, List<Integer> scores){
        int sum =0; //sum variable to keep track of the carried weight
        Collections.reverse(scores); //the idea here is to sort the list in reverse so we can started from the largest weights
        for(int i=0; i< scores.size();i++){
            for(int j=i+1; j< scores.size();j++){ //iterate through this list 2 pointers
                sum= scores.get(i)+scores.get(j); //sum the 2 pointers given that its sorted in descending order
                if(sum<=max) { //checking that if we reached the limit or just under it return the sum
                    return sum; //this method works because the list is sorted
                }
            }

        }
        return -1; //if we could not obtain the limit or close to it then return -1
    }
}
