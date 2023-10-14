import java.util.AbstractList;
class Solution {
    private List<List<Integer>> list;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return new AbstractList<List<Integer>>(){
            public List<Integer> get(int index) {
                init();
                return list.get(index);
            }
            public int size() {
                init();
                return list.size();
            }
            private void init() {
                if (list != null) 
                    return;
                list = new ArrayList<List<Integer>>();
                Arrays.sort(nums);
            
                if(nums[0] > 0 && target < 0){
                    return;
                }
                for(int i = 0, L = nums.length; i < L-3; i++) {

                    for(int j = L-1; j > i+2; j--) {
                            
                        int rem = target-nums[i]-nums[j];
                        int lo = i+1, hi=j-1;
                        while(lo < hi) {
                            int sum = nums[lo] + nums[hi];
                            if(sum > rem) 
                                --hi;
                            else if(sum<rem) 
                                ++lo;
                            else {
                                long sumCheckOverflow = (long)nums[i] + (long)nums[lo] + (long)nums[hi] + (long)nums[j];
                                // System.out.print("sum = " + sumCheckOverflow);
                                if(sumCheckOverflow > Integer.MAX_VALUE || sumCheckOverflow < Integer.MIN_VALUE)
                                    return;

                                list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
                                while(++lo <= hi && nums[lo-1] == nums[lo]) 
                                    continue;
                                while(--hi >= lo && nums[hi] == nums[hi+1]) 
                                    continue;
                            }
                        }
                        while(j >= 1 && nums[j] == nums[j-1]) 
                            --j;
                    }
                    while(i < L-1 && nums[i] == nums[i+1]) 
                        ++i;
                }
                return;
                }
        };
    }
}