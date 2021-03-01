/*

请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class Solution_剑指Offer37序列化二叉树 {
    int index=0;
    public String serialize(TreeNode root) {
        index=0;
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        dfs(root,res);
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }
    public void dfs(TreeNode root,StringBuilder srb){
        if(root==null){
            srb.append("null,");
            return;
        }
        srb.append(root.val+",");
        dfs(root.left,srb);
        dfs(root.right,srb);
    }
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        return  dedfs( vals);
    }
    public TreeNode dedfs(String[] vals){
        if(index>vals.length||vals[index]=="null") return null;
        TreeNode node=new TreeNode(Integer.parseInt(vals[index]));
        index++;
        node.left=dedfs(vals);
        node.right=dedfs(vals);
        return node;
    }
}
