import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[nums1.length];

        for (int i = 0; i < nums2.length; i++) {

            for (int j = 0; j < nums1.length; j++) {

                if (nums2[i] == nums1[j] && !used[j]) {
                    result.add(nums2[i]);
                    used[j] = true;
                    break;
                }
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}