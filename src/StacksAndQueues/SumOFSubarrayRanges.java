package StacksAndQueues;

import java.util.ArrayList;

public class SumOFSubarrayRanges {

        public static void main(String[] args) {
            int[] nums = {1, 2, 3};
            SumOFSubarrayRanges sol = new SumOFSubarrayRanges();
            long result = sol.subArrayRanges(nums);
            System.out.println(result);
        }
        public long subArrayRanges(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            long sum = 0;
            ArrayList<ArrayList<Integer>> ans = subset(nums);
            for (ArrayList<Integer> temp : ans) {
                for (int i = 0; i < temp.size(); i++) {
                    min = Math.min(min, temp.get(i));
                    max = Math.max(max, temp.get(i));
                }
                sum += Math.abs(max - min);
            }
            return sum;
        }
        public static ArrayList<ArrayList<Integer>> subset(int[] arr) {
            ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
            outer.add(new ArrayList<>());
            for (int num : arr) {
                int n = outer.size();
                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                    internal.add(num);
                    outer.add(internal);
                }
            }
            return outer;
        }
    }

