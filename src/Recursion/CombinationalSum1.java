package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationalSum1 {

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();


        List<List<Integer>> p = solve(0, candidates, target, res, new ArrayList<>());

        for (List<Integer> op : p) {
            System.out.println(op);

        }
    }

        static List<List<Integer>> solve(int index, int[] candidates, int target, List<List<Integer>> res, List<Integer> temp  ) {

            if (index >= candidates.length) {
                if (target == 0) {
                    res.add(new ArrayList<>(temp));
                }
                return res;
            }

            if (candidates[index] <= target) {
                temp.add(candidates[index]);
                solve(index, candidates, target - candidates[index], res, temp);
                temp.remove(temp.size() - 1);
            }
            solve(index + 1, candidates, target, res, temp);
      return res;  }

    }

