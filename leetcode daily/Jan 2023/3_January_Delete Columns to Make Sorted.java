class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length(), noOfDeletions = 0;

        for(int i = 0; i < m; i++){
            char prev = strs[0].charAt(i);
            for(int j = 1; j < n; j++){
                char ch = strs[j].charAt(i);
                if(ch < prev){
                    noOfDeletions++;
                    break;
                }
                prev = ch;
            }
        }

        return noOfDeletions;
    }
}