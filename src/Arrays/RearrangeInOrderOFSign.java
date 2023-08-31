package Arrays;

public class RearrangeInOrderOFSign {

    public static void main(String[] args) {

    }
        public int[] rearrangeArray(int[] nums) {
            int  l=nums.length;
            int even=0;
            int odd=1;

            int ans[]=new int[l];

            for( int i=0; i< nums.length; i++)
            {
                if( nums[i] > 0)
                {
                    ans[even] = nums[i];
                    even+=2;
                }
                else
                {
                    if( nums[i] < 0)
                    {
                        ans[odd] = nums[i];
                        odd+=2;
                    }
                }

            }
            return ans;
        }
    }


