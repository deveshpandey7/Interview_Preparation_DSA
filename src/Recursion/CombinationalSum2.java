package Recursion;

import java.util.*;

public class CombinationalSum2 {

    public static void main(String[] args) {

        int[] candidates = { 2,3,7,9,2,4};
        int target = 7;
        combinationSum2(candidates,target);

    }
            public static List<List<Integer>> combinationSum2(int[] candidates, int target) {


                List<List<Integer>> res = new ArrayList<>();
                Arrays.sort(candidates);
                solve(0, candidates, target, res, new ArrayList<>());
                return res;
            }

            public static void solve(int index, int[]candidates, int target, List<List<Integer>> res, List<Integer> temp){

                if( target == 0){
                    res.add(new ArrayList<>(temp));
                    return;
                }

                for( int i = index; i<candidates.length; i++){
                    if( i > index && candidates[i] == candidates[i-1]) continue;
                    if(candidates[i] > target) break;

                    temp.add(candidates[i]);
                    solve(i+1, candidates, target - candidates[i], res, temp);
                    temp.remove(temp.size() - 1);

                }
            }
        }


