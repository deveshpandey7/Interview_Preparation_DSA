package StacksAndQueues;

public class TrappingRainWater {


    public static void main(String[] args) {

    }
        public int trap(int[] height) {

            int res = 0;
            int n = height.length;
            int[] prefixmax = new int[n];
            int[] suffixmax = new int[n];

// previous greater
            prefixmax[0] = height[0];
            for( int i=1; i<n; i++){
                prefixmax[i] = Math.max(height[i], prefixmax[i-1]);
            }
// next greater
            suffixmax[n-1] = height[n-1];
            for( int i=n-2; i>=0; i--){
                suffixmax[i] = Math.max(height[i], suffixmax[i+1]);
            }
// capacity for every building to hold water
            for( int i = 0; i<n; i++){
                // total unit of water is saved
                res += Math.min(prefixmax[i], suffixmax[i]) - height[i];
            }

            return res;
        }
    }
