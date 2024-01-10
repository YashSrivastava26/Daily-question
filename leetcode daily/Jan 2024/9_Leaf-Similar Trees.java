/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> levelOrder(TreeNode root){
        List<Integer> leaves = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        st.push(root);
        while(!st.empty()){

            TreeNode curr = st.pop();
            if(curr.left != null){

                st.push(curr.left);
            }
            if(curr.right != null){

                st.push(curr.right);
            }
            if(curr.left == null && curr.right == null) {
                leaves.add(curr.val);
            }
        }
        return leaves;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return levelOrder(root1).equals((levelOrder(root2)));
    }
}
