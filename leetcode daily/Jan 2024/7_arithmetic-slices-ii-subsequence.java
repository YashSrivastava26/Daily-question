class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> dp[] = new HashMap[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new HashMap<>();
        }
        int ans = 0;    
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                long diff = (long) nums[i] - nums[j];
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE){
                    continue;
                }
                dp[i].put((int)diff, 1 + dp[j].getOrDefault((int)diff, 0) + dp[i].getOrDefault((int)diff, 0));
                ans += dp[j].getOrDefault((int)diff, 0);
            }
        }
        return ans;
    }
}
