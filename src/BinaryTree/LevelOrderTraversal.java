package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
         }
      }

        public List<List<Integer>> levelOrder(TreeNode root) {


            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<List<Integer>> outer = new ArrayList<>();

            if( root == null ){
                return outer;
            }

            // add first root value in queue
            queue.offer(root);

            // till queue khali nahi hai
            while(!queue.isEmpty()){

                // ek bar me pure level ko bahar lo to print
                int levelnum = queue.size();
                ArrayList<Integer> inner = new ArrayList<>();

                // pure level ke left right ko queue me dalo for next level print
                for(int i=0; i<levelnum; i++){
                    if(queue.peek().left != null) queue.offer(queue.peek().left);
                    if(queue.peek().right != null) queue.offer(queue.peek().right);
                    inner.add(queue.poll().val);
                }
                outer.add(inner);
            }
            return outer;

        }
    }

