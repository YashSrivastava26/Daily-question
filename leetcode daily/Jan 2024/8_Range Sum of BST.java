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
    void inOrder(int low, int high, TreeNode* root, int &sum){
        if(root == NULL){
            return;
        }
        inOrder(low, high, root->left, sum);
        cout << root->val << "\n";
        if(root->val >= low && root->val <= high){
            sum += root->val;
        }
        else if(root->val > high){
            return;
        }
        inOrder(low, high, root->right, sum);
    }
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        int sum = 0;
        inOrder(low, high, root, sum);
        return sum;
    }
};
