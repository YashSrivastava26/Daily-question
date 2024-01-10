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
class InfectionTime{
    int infectionTimeInSubTree = -1, infectionToReachCurr = -1;
    InfectionTime(int infectionTimeInSubTree, int infectionToReachCurr){
        this.infectionToReachCurr = infectionToReachCurr;
        this.infectionTimeInSubTree = infectionTimeInSubTree;
    }
}
class Solution {
    private InfectionTime findInfectedTime(TreeNode root, int infection){
        if(root == null){
            return new InfectionTime(0, -1);
        }
        InfectionTime left = findInfectedTime(root.left, infection);
        InfectionTime right = findInfectedTime(root.right, infection);
        InfectionTime curr = new InfectionTime(-1, -1);


        //found infection in leftSubTree
        if(left.infectionToReachCurr != -1){
            curr.infectionToReachCurr = left.infectionToReachCurr + 1;
            curr.infectionTimeInSubTree = Math.max(left.infectionTimeInSubTree, left.infectionToReachCurr + right.infectionTimeInSubTree);
        }
        else if(right.infectionToReachCurr != -1){
            curr.infectionToReachCurr = right.infectionToReachCurr + 1;
            curr.infectionTimeInSubTree = Math.max(right.infectionTimeInSubTree, right.infectionToReachCurr + left.infectionTimeInSubTree);
        }
        else if(root.val == infection){
            curr.infectionToReachCurr = 1;
            curr.infectionTimeInSubTree = Math.max(left.infectionTimeInSubTree , right.infectionTimeInSubTree);
        }
        else{
            curr.infectionTimeInSubTree = 1 + Math.max(left.infectionTimeInSubTree , right.infectionTimeInSubTree);
        }
        return curr;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        return findInfectedTime(root, start).infectionTimeInSubTree;
    }
}
