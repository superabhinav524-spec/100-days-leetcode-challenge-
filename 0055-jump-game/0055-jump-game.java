class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReachableIndex = 0;
      
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            
            if (maxReachableIndex < currentIndex) {
                return false;
            }
          
            maxReachableIndex = Math.max(maxReachableIndex, currentIndex + nums[currentIndex]);
        }
    
        return true;
    }
}
