class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        int n = nums.length;
        for(int i = n - 1; i >= 0; i--){
            int temp = nums[i];
            while(temp > 0){
                l.add(temp % 10);
                temp /= 10;
            }
        }

        n = l.size();
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = l.get(n - i - 1);
        }

        return answer;
    }
}