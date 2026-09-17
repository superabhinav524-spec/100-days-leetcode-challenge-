class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] count = new int[102];
        for (int num : nums) {
            count[num]++;
        }
        
        
        int runningSum = 0;
        for (int i = 0; i <= 100; i++) {
            int temp = count[i];
            count[i] = runningSum;
            runningSum += temp;
        }
        
       
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }
        
        return result;
    }
}
