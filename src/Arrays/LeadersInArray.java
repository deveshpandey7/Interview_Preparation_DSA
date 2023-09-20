package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {


    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        int leader = arr[n-1];
        list.add(leader);
        for(int i=n-2; i>=0 ;i--){
            if(arr[i]>=leader){
                leader = arr[i];
                list.add(leader);
            }
        }

        Collections.reverse(list);
        return list;
    }

}
