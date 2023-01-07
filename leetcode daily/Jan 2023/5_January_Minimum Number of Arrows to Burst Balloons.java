import java.util.Arrays;

// class Solution {
//     public int findMinArrowShots(int[][] points) {
//         int ans = 1;

//         Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));

//         int n = points.length;

//         int currArrow = points[0][1];
//         for(int i = 1; i < n;i++){
//             int currStart = points[i][0];     
//             if(currStart > currArrow){
//                 ans++;
//                 currArrow = points[i][1];
//             }
            
//         }
//         return ans;
//     }
// }

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int n = points.length, ans = 1;
        int currArrow = points[0][1];
        for(int i = 1; i < n;i++){
            int currStart = points[i][0];     
            if(currStart > currArrow){
                ans++;
                currArrow = points[i][1];
            }
            
        }
        return ans;
    }
}
