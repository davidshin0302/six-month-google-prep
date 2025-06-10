package leetCodeChallenges.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZag {
    public List<List<Integer>> zigzagLevelOrder(StackTreeNode root){
        List<List<Integer>> output = new ArrayList<>();
        Queue<StackTreeNode> queue = new ArrayDeque<>();
        boolean zigZag = false;

        if(root != null){
            return output;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> currentLevelVal = new ArrayList<>();
            int level = queue.size();

            for(int i = 0; i < level; i++){
                StackTreeNode currentNode = queue.poll();
                currentLevelVal.add(currentNode.val);

                if(zigZag){
                    if(currentNode.right != null){
                        queue.offer(currentNode.right);
                    }
                    if(currentNode.left != null){
                        queue.offer(currentNode.left);
                    }
                }else{
                    if(currentNode.left != null){
                        queue.offer(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.offer(currentNode.right);
                    }
                }
                zigZag = !zigZag;
            }
            output.add(currentLevelVal);
        }
        return output;
    }
}
