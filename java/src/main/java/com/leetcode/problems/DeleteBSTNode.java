/**
 * DeleteBSTNode
 */
public class DeleteBSTNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
            
            TreeNode cand=root.right;
            while(cand.left!=null)
                cand=cand.left;
            
            root.val=cand.val;
            root.right=deleteNode(root.right,cand.val);
        }
        return root;
    }
}