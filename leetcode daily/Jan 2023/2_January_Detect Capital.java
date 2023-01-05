// class Solution {
//     public boolean detectCapitalUse(String word) {
//         int n = word.length();
//         if(n == 1) return true;

//         boolean allSmall = false;
//         if(word.charAt(0) >= 'a'){
//             allSmall = true;
//         }

//         boolean allCapital = false;
//         if(!allSmall && word.charAt(1) <= 'Z'){
//             allCapital = true;
//         }

//         if(allSmall){
//             for(int i = 1; i < n; i++){
//                 char ch = word.charAt(i);
//                 if(ch < 'a'){
//                     return false;
//                 }
//             }
//             return true;
//         }
//         else if(allCapital){
//             for(int i = 2; i < n; i++){
//                 char ch = word.charAt(i);
//                 if(ch > 'Z'){
//                     return false;
//                 }
//             }
//             return true;
//         }
//         else{
//             for(int i = 2; i < n; i++){
//                 char ch = word.charAt(i);
//                 if(ch < 'a'){
//                     return false;
//                 }
//             }
//             return true;
//         }
//     }
// }


class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isFirstCharCapital = word.charAt(0) <= 'Z' ? true: false;

        int n = word.length();
        int capitalCount = 0;

        for(int i = 0; i < n; i++){
            if(word.charAt(i) <= 'Z'){
                capitalCount ++;
            }
        } 

        if((isFirstCharCapital && capitalCount == 1) || capitalCount == 0 || capitalCount == n){
            return true;
        }
        return false;
    }
}