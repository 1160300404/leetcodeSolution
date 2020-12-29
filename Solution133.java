package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node2 {
    public int val;
    public List<Node2> neighbors;

    public Node2() {
        val = 0;
        neighbors = new ArrayList<Node2>();
    }

    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<Node2>();
    }

    public Node2(int _val, ArrayList<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution133 {
    public Node2 cloneGraph(Node2 node) {
        HashMap<Node2,Node2> map=new HashMap<>();
        return bfs(node,map);
    }
    public Node2 bfs(Node2 node,HashMap<Node2,Node2> map){
        if(node==null)
            return null;
        Node2 node2=null;
        if(!map.containsKey(node)){
            node2=new Node2(node.val);
            map.put(node,node2);
        }else{
            node2=map.get(node);
            return node2;
        }
        for(int i=0;i<node.neighbors.size();i++){
            Node2 tmp=bfs(node.neighbors.get(i),map);
            if(tmp!=null)
                node2.neighbors.add(tmp);
        }
        return node2;
    }
}
