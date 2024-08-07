// Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.
// A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.
// Examples :
// Input:
//     3
//   /   \    
//  1     2
// Output: true
// Explanation: The sum of left subtree and right subtree is 1 + 2 = 3, which is the value of the root node. Therefore,the given binary tree is a sum tree.
// Input:
//           10
//         /    \
//       20      30
//     /   \ 
//    10    10
// Output: false
// Explanation: The given tree is not a sum tree. For the root node, sum of elements in left subtree is 40 and sum of elements in right subtree is 30. Root element = 10 which is not equal to 30+40.

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.isSumTree(root));
            // if (g.isSumTree(root) == true)
            //     System.out.println(1);
            // else
            //     System.out.println(0);
            t--;
        }
    }
}

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    private int sumTreeHelper(Node node) {
        // Base cases
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.data;
        }
        int leftSum = sumTreeHelper(node.left);
        int rightSum = sumTreeHelper(node.right);
        if (node.data != leftSum + rightSum) {
            throw new IllegalStateException("Not a sum tree");
        }
        return node.data + leftSum + rightSum;
    }
    boolean isSumTree(Node root) {
        try {
            sumTreeHelper(root);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }
}
