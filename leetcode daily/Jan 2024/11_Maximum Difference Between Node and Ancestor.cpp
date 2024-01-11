/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private: 
    int ans = -1; 
    pair<int, int> postOrder(TreeNode* root){ // return max and min of sub tree pair.first => max and pair.min => min

        int maxVal = root->val, minVal = root->val;
        if(root->left){
            pair<int, int> leftPair = postOrder(root->left);
            maxVal = max(leftPair.first, maxVal);
            minVal = min(leftPair.second, minVal);
            ans = max(ans, max( abs(root->val - leftPair.first), abs(root->val - leftPair.second)));
        }
        
        if(root->right){
            pair<int, int> rightPair = postOrder(root->right);
            maxVal = max(rightPair.first, maxVal);
            minVal = min(rightPair.second, minVal);
            ans = max(ans, max( abs(root->val - rightPair.first), abs(root->val - rightPair.second)));

        }
        return {maxVal, minVal};
    }
public:
    int maxAncestorDiff(TreeNode* root) {
        postOrder(root);
        return ans;
    }
};
