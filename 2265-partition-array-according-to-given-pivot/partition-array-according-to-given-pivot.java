class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lessThanPivot = 0, moreThanPivot = 0;
        for(int i : nums){
            if(i < pivot) lessThanPivot++;
            else if (i > pivot) moreThanPivot++;
        }

        int i = 0, j = nums.length - moreThanPivot, k = i + lessThanPivot;
        int[] newNums = new int[nums.length];
        for(int z : nums){
            if(z < pivot){
                newNums[i++] = z;
            }else if(z > pivot){
                newNums[j++] = z;
            }else newNums[k++] = z;
        }

        return newNums;
    }
}