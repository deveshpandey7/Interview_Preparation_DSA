package BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {


    public static void main(String[] args) {

    }
  //  **
     //* Definition for a binary tree node.
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

        public List<Integer> preorderTraversal(TreeNode root) {

            ArrayList<Integer> Pre = new ArrayList<>();
            PreOrder(root,Pre);
            return Pre;
        }
        public static void PreOrder(TreeNode root, List<Integer> Pre){

            if( root == null ) {
                return;
            }

            Pre.add(root.val);
            PreOrder(root.left, Pre);
            PreOrder(root.right, Pre);

        }
    }

