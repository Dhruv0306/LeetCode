class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        combinationSum(candidates, target, finalList, new ArrayList<>(), 0);
        return finalList;
    }

    public static void combinationSum(int[] nums, int target, List<List<Integer>> ll, List<Integer> l, int start){
        if(target == 0){
            ll.add(new ArrayList<>(l));
            return;
        }
        else{
            for(int i = start; i < nums.length; i++){
                if(target - nums[i] >= 0){
                    l.add(nums[i]);
                    combinationSum(nums,target - nums[i],ll,l,i);
                    l.remove(l.size()-1);
                }
            }
        }
    }
}