/**
 * Class to allow nodes to reference children and contain string and count frequency
 *
 * @author Landon Leigh
 * @version 8/2/2019
 */

public class Node {
   private Node rightNode;
   private Node leftNode;
   private String word;
   private int stringNum;
   
   //constructor
   public Node(String w)
   {
       word = w;
       stringNum = 1;
       leftNode = null;
       rightNode = null;
   }
   
   //counts the frequency of the words
   public void wordFrequency()
   {
      stringNum++;
   }
   
   //returns the frequency of the word
   public int getFrequency()
   {
      return stringNum;
   }
   
   //returns the word/string
   public String getWord(){
      return word;
   }
   
   //gets the left child of the tree 
   public Node getLeftChild()
   {
      return leftNode;
   }
   
   //gets the right child of the tree
   public Node getRightChild()
   {
      return rightNode;
   }
   
   //method that determines where to add the new node
   public int childrenNum(Node child)
   {
      int childNum = 0;
      
      if(child.getLeftChild() != null)//check to see if left child is null
      {
         childNum += 1 + childrenNum(child.getLeftChild());
      }
      if(child.getRightChild() != null)//check to see if right child is null
      {
         childNum += 1 + childrenNum(child.getRightChild());
      }
      
      return childNum;
   }
   
   //method that adds the nodes
   public void add (String wordAdd)
   {
      if (leftNode == null)
      {
         leftNode = new Node(wordAdd);//if the left child is empty add a node
      }
      else if(rightNode == null)
      {
         rightNode = new Node(wordAdd);//if the right child is empty add a node
      }
      else
      {
          if (childrenNum(leftNode) <= childrenNum(rightNode))//comparison to determine where to add the node
          {
              leftNode.add(wordAdd);
          }
          else
          {
              rightNode.add(wordAdd);
          }
      }
   }
}

