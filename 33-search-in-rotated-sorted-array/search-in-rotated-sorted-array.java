class Solution {
    public int search(int[] nums, int target) {
        int i = 0, len = nums.length;
        if(len == 1){
            if(nums[0] == target)return 0;
            else return -1;
        }

        while(i < len-1 && nums[i] < nums[i+1]){i++;}
        
        if(i < len){
            if(nums[i] == target)return i;
        }
        if(nums[0] <= target && nums[i] >= target){
            return search(nums,target,i,0);
        }else{
            return search(nums,target,len-1,i+1);
        }
    }

    public static int search(int[] nums,int target, int right, int left){
        int l = left, r = right;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                l = mid + 1; 
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}