import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    private void traversal(Node node, int level, ArrayList < Integer > ans){
        if(node == null) return;
        if(ans.size() <= level){
            ans.add(node.data);
        }
        else{
            ans.set(level, Math.max(ans.get(level), node.data));
        }
        
        traversal(node.left, level + 1, ans);
        traversal(node.right, level + 1, ans);
    }
    ArrayList<Integer> maximumValue(Node node) {
        ArrayList < Integer > ans = new ArrayList<>();
        
        traversal(node, 0, ans);
        return ans;
    }
}