package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;



public class PostOrderTraversal {




     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;this.right = right;
          }
      }

        public List<Integer> postorderTraversal(TreeNode root) {

            ArrayList<Integer> Post = new ArrayList<>();
            PostOrder(root,Post);
            return Post;
        }
        public static void PostOrder( TreeNode root, List<Integer> Post){

            if( root == null ) {
                return;
            }

            PostOrder(root.left, Post);
            PostOrder(root.right, Post);
            Post.add(root.val);

        }
    }


