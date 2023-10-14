class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){// Null array
            return new int[]{-1,-1};
        }
        if(nums.length == 1){
            if(target == nums[0]){ // Target is same as only element in array
                return new int[]{0,0};
            }else{ // No such element in array
                return new int[]{-1,-1};
            }
        }
        int [] inds = new int[2];
        inds[0] = binary(nums,target);
        if(inds[0] == -1){
            inds[1] = -1;
        }else{
            // Set inds[0] to index Of first appearance.
            while(inds[0] >= 0 && nums[inds[0]] == target){inds[0]--;}
            inds[0] += 1; // Undo last decrement 
            int ind = inds[0];

            // Set ind to index of appearance. 
            while(ind < nums.length && nums[ind] == target){
                ind++;
            }
            inds[1] = ind - 1; // Undo last increment 
        }
        return inds;
    }
    public static int binary(int[] nums, int target){
        int low = 0; // Lower Pointer
        int high = nums.length - 1; // Hige pointer
        while(low <= high){
            int mid = (low + high)/2; // Mid pointer
            if(nums[mid] == target){ // Target Found
                return mid;
            }else if(nums[mid] < target){ // Target is bigger than element
                low = mid + 1;
            }else{ // Element is bigger than target
                high = mid - 1;
            }
        }
        return -1;
    }
}