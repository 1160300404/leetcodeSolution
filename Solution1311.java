//package Solution;
//
//import javafx.util.Pair;
//
//import java.util.Queue;
//import java.util.*;
//
//public class Solution1311 {
//    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
//        Queue<Integer> queue = new LinkedList<Integer>();
//        Set<Integer> people=new HashSet<>();
//        List<String> ans=new ArrayList<>();
//        Map<String,Integer> map=new HashMap<>();
//        queue.offer(id);
//        people.add(id);
//        int count=1;
//        while(!queue.isEmpty()&&level!=0){ //O(n)
//            int tmp=queue.poll();
//            int [] frindss=friends[tmp];
//            for(int i=0;i<frindss.length;i++){
//                if(!people.contains(frindss[i])){
//                    queue.offer(frindss[i]);
//                    people.add(frindss[i]);
//                }
//            }
//            count--;
//            if(count==0){
//                count=queue.size();
//                level--;
//            }
//        }
//        if(queue.isEmpty()){
//            return ans;
//        }
//        while(!queue.isEmpty()){
//            int ren=queue.poll();
//            List<String> videos=watchedVideos.get(ren);
//            for(String s: videos){
//                if(map.containsKey(s)){
//                    map.put(s,map.get(s)+1);
//                }else{
//                    map.put(s,1);
//                }
//            }
//        }
//        PriorityQueue<Pair<String, Integer>> priorityQueue = new PriorityQueue<>((t1, t2) -> {
//            if (t1.getValue().equals(t2.getValue())) {
//                return t1.getKey().compareTo(t2.getKey());
//            } else {
//                return t1.getValue().compareTo(t2.getValue());
//            }
//        });
//        map.forEach((key, value) -> priorityQueue.add(new Pair<>(key, value)));
//        while (!priorityQueue.isEmpty()) {
//            ans.add(priorityQueue.poll().getKey());
//        }
//        return ans;
//    }
//}
