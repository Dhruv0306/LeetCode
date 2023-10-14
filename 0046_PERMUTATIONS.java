class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        permutations(finalList, new ArrayList<>(), nums);
        return finalList;
    }

    private void permutations(List<List<Integer>> list, List<Integer> l, int [] nums){
        if(l.size() == nums.length){
            list.add(new ArrayList<>(l));
        } else{
            for(int i = 0; i < nums.length; i++){ 
                if(l.contains(nums[i])) continue; // element already exists, skip
                l.add(nums[i]);
                permutations(list, l, nums);
                l.remove(l.size() - 1);
            }
        }
    } 
}