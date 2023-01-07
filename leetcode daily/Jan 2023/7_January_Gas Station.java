class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, start = 0;
        int totalGas_Cost = 0, currAvailGas = 0;

        for(int i = 0; i < n; i++){
            currAvailGas += (gas[i] - cost[i]);
            if(currAvailGas < 0){
                currAvailGas = 0;
                start = i + 1;
            }
            totalGas_Cost += gas[i] - cost[i];
            
        }
        if(totalGas_Cost < 0){
            return -1;
        }
        return start;
    }
}