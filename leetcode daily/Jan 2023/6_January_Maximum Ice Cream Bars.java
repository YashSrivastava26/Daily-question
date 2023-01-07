//greedy sorting tc = O(n log n)
// class Solution {
//     public int maxIceCream(int[] costs, int coins) {
//         int n = costs.length;
//         Arrays.sort(costs);
//         int ans = 0;

//         for(int i = 0; i < n; i++){
//             coins -=costs[i];
//             if(coins < 0){
//                 break;
//             }
//             ans++;
//         }
//         return ans;
//     }
// }


//greedy counting sort
//Tc = O(n + m)
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int m = 0;
        for(int it : costs){
            m = Math.max(it, m);
        }
        int freq[] = new int[m + 1];
        int ans = 0;

        for(int i = 0; i < n; i++){
            freq[costs[i]]++;
        }

        for(int i = 0; i < m + 1; i++){
            int currCost = freq[i] * i ;
            if(currCost < coins){
                coins -= currCost;
                ans += freq[i];
            }
            else{
                ans += coins / i;
                break;
            }
        }
        return ans;
    }
}