class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] x = new int[m + n];

        
        for (int i = 0; i < m; i++) {
            x[i] = nums1[i];
        }

        
        for (int i = 0; i < n; i++) {
            x[m + i] = nums2[i];
        }

       
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length - 1 - i; j++) {

                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }

    
        for (int i = 0; i < x.length; i++) {
            nums1[i] = x[i];
        }
    }
}