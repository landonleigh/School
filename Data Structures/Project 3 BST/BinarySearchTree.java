/**
 * Class to add and search nodes in the tree
 *
 * @author Landon Leigh
 * @version 8/2/2019
 */

import java.util.*;
public class BinarySearchTree {
   private Node root;
   private int size;
   
   //constructor
   public BinarySearchTree()
   {
      root = null;
      size = 0;
   }

   public boolean isEmpty() 
   {
      return root == null;
   }

   public void insert(String a)
   {
      Node same;
      
      if(isEmpty())
      {
          root = new Node(a);//node added to root if root is empty
      }
      else if((same = checkChild(root, a)) == null)//looks through tree to see if a new node should be added
      {
            root.add(a);
      }
      else
      {
          same.getFrequency();
      }
   }
    
   //searches through tree
   public void search(String s)
   {
      Node wordInfo;
      
      if((wordInfo = checkChild(root, s)) == null)
      {
         System.out.println("The word (" + s + ") was not found.");
      }
      else
      {
         System.out.println("The word (" + wordInfo.getWord() + ") was found: " + (wordInfo.getFrequency()) +" times");
      }
    }
    
   //searches the tree using recursive calls
   public Node checkChild(Node child, String info)
   {
       Node wordInfo = null;
       
       if(child != null)
       {
          if((child.getWord()).equals(info))
          {
             return child;
          } 
          else if((wordInfo = checkChild(child.getLeftChild(), info)) != null)
          {
             return wordInfo;
          }
          else
          {
             return checkChild(child.getRightChild(), info);
          }
        }
        
       return wordInfo;
    }
   
   public void preOrder(Node child)
   {
       if(child != null)
       {
          System.out.println(child.getWord() + " ");
          preOrder(child.getLeftChild());
          preOrder(child.getRightChild());
       }
   }
   
   //prints pre order to the user
   public void printPreOrder()
   {
       System.out.println();
       preOrder(root);
   }
    
   public void inOrder(Node child) 
   {
       if(child != null)
       {
           inOrder(child.getLeftChild());
           System.out.println(child.getWord() + " ");
           inOrder(child.getRightChild());
       }
   }
   
   //prints in order to the user.
   public void printInOrder()
   {
       System.out.println();
       inOrder(root);
   }
    
   public void postOrder(Node child)
   {
       if(child != null)
        {
           postOrder(child.getLeftChild());
           postOrder(child.getRightChild());
          System.out.println(child.getWord() + " ");
       }
   }
    
   //prints post order to the user
   public void printPostOrder()
   {
       System.out.println();
       postOrder(root);
   }
}