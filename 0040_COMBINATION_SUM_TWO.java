class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> finalList = new ArrayList<>();
        Arrays.sort(candidates);
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
                if(i > start && nums[i] == nums[i-1])
                    continue;
                if(target - nums[i] >= 0){
                    l.add(nums[i]);
                    combinationSum(nums,target - nums[i],ll,l,i+1);
                    l.remove(l.size()-1);
                }
            }
        }
    }
}