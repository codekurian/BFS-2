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
class Problem2 {
    boolean fnd_x;
    boolean fnd_y;
    TreeNode x_prnt;
    TreeNode y_prnt;
    public boolean isCousins(TreeNode root, int x, int y) {
        return isCousinsBFS(root,x,y);
    }
    //TC :O(N)
    //SC(O(2(N/2)) == O(N) because we have 2 queue and at max we can have 
    //n/2 children
    public boolean isCousinsBFSwithQ(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentq = new LinkedList<>();
        if(root==null) return false;
        q.add(root);
        parentq.add(null);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode polled = q.poll();
                TreeNode parent = parentq.poll();

                if(polled != null && (polled.val == x)){
                    fnd_x = true;
                    x_prnt = parent;
                }

                if(polled != null && (polled.val == y)){
                    fnd_y = true;
                    y_prnt = parent;
                }

                if(polled.left != null){
                    q.add(polled.left);
                    parentq.add(polled);
                }

                if(polled.right != null){
                    q.add(polled.right);
                    parentq.add(polled);
                }
            }
            if(fnd_x && fnd_y){
                return x_prnt != y_prnt;
            }else if (fnd_x || fnd_y) return false;
        }

        return false;
    }
    //TC :O(N)
    //SC(O(N/2)) == O(N)
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();

        if(root==null) return false;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode polled = q.poll();

                //If the right and left child both are found and belong to the same parent
                // they are not cousins so we do not need parent object
                if(polled.left != null &&  polled.right != null){
                    if(polled.left.val == x && polled.right.val == y )return false;
                    if(polled.left.val == y && polled.right.val == x) return false;

                }

                if(polled.val == x ){
                    fnd_x = true;
                }
                if(polled.val == y ){
                    fnd_y = true;
                }
                if(polled.left != null){
                    q.add(polled.left);
                }
                //since we didnt return false we know that right and left
                //that we are adding to the q are not having same parents
                if(polled.right != null){
                    q.add(polled.right);
                }

            }
            if(fnd_x && fnd_y) return true;
            if(fnd_x || fnd_y) return false;
        }

        return false;
    }

}