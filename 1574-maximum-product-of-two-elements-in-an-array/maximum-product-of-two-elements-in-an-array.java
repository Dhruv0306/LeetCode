class Solution {
    public int maxProduct(int[] nums) {
        // int first = 0, second = 0;
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i]>first){
        //         second = first;
        //         first = nums[i];
        //     }else if(nums[i]>second){
        //         second = nums[i];
        //     }
        // }
        // return (first-1)*(second-1);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i : nums){
        //     pq.offer(i-1);
        // }
        // return pq.poll()*pq.poll();

        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}