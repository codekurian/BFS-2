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
class Problem1 {
    //TC: O(N)
    //SC : (O(N/2)) == O(N)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root!=null){
            q.add(root);
            bfs(q,rightSideView);
        }

        return rightSideView;
    }

    public void bfs(Queue<TreeNode> q,List<Integer> rightSideView){
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left !=null){
                    q.add(node.left);
                }
                if(node.right !=null){
                    q.add(node.right);
                }
                if(i==size-1){
                    //this is the rightmost
                    rightSideView.add(node.val);
                }
            }

        }
    }
}