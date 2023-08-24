package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {



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

        public List<Integer> inorderTraversal(TreeNode root) {

            ArrayList<Integer> In = new ArrayList<>();
            InOrder(root,In);
            return In;
        }
        public static void InOrder( TreeNode root, List<Integer> In){

            if( root == null ) {
                return;
            }

            InOrder(root.left, In);
            In.add(root.val);
            InOrder(root.right, In);

        }
    }

