import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> wordCharMap = new HashMap<>();
        HashMap<Character, String> charWordMap = new HashMap<>();
        int n = s.length(), m = pattern.length();

        int startWord = 0, j = 0;
        for(int i = 0; i <= n; i++){
            
            if(i == n || s.charAt(i) == ' '){
                String word = "";
                if(j >= m){
                    return false;
                }
                char chPattern = pattern.charAt(j);
                word = s.substring(startWord, i);
                if(wordCharMap.containsKey(word) && wordCharMap.get(word) != chPattern){
                    System.out.println(wordCharMap.get(word) + " " + chPattern +  " " + word);
                    return false;
                }
                else if(charWordMap.containsKey(chPattern) && !word.equals(charWordMap.get(chPattern))){
                    return false;
                }
                else if(!charWordMap.containsKey(chPattern) && !wordCharMap.containsKey(word)){
                    charWordMap.put(chPattern, word);
                    wordCharMap.put(word, chPattern);
                }
                j++;
                startWord = i + 1;
            }
        }
        if(j == m) return true;
        return false;
    }
}