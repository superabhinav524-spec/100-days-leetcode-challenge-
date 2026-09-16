class Solution {
    public int maxProfit(int[] prices) {
        int x =0;

        int i=0;//buy
        int j =1;//sell
        while(j<prices.length){
            if(prices[i]<prices[j]){
                int y =prices[j]-prices[i];
                x=Math.max(x,y);
            }
            else{
                i=j;
            }
            j++;
            
        }
        return x;

    }
}