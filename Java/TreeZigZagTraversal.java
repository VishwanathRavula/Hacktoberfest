/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String []args)
    {
        Solution s=new Solution();
        TreeNode root=new TreeNode(10);
        //create your own tree
        List<List<Integer>> l=s.zigzagLevelOrder(root);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
            return list;
        Deque <TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int level=1;
        while(deque.isEmpty()==false)
        {
            List<Integer> res=new ArrayList<>();
            int size=deque.size();
            if(level%2==1)
            {
                
                for(int i=0;i<size;i++)
                {
                    TreeNode temp=deque.pollFirst();
                    res.add(temp.val);
                    if(temp.left!=null)
                    {
                        deque.offerLast(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        deque.offerLast(temp.right);                        
                    }
                }
            }
            else
            {
                for(int i=0;i<size;i++)
                {
                    TreeNode temp=deque.pollLast();
                    res.add(temp.val);
                    
                    if(temp.right!=null)
                    {
                        deque.offerFirst(temp.right);
                    }
                    if(temp.left!=null)
                    {
                        deque.offerFirst(temp.left);                        
                    }
                }
            }
            list.add(res);
            level++;
        }
        return list;
    }
  
}
