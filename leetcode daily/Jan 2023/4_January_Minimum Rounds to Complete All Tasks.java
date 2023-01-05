import java.util.HashMap;

class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap < Integer , Integer > difficultyFreq = new HashMap<>();
        int n = tasks.length;

        for(int i = 0; i < n; i++){
            difficultyFreq.put(tasks[i], difficultyFreq.getOrDefault(tasks[i], 0) + 1);
        }
        int ans = 0;
        for(Integer it : difficultyFreq.values()){
            if(it == 1) return -1;
            if(it % 3 == 0){
                ans += it / 3;
            }
            else{
                int lastMulOf3 = (it - 2) / 3;
                ans += lastMulOf3;
                ans += (it - lastMulOf3) / 2;
            }
        }
        return ans;
    }
}