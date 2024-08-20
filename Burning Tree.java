// Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes connected to a given node get burned. That is its left child, right child, and parent.
// Note: The tree contains unique values.
// Examples : 
// Input:      
//           1
//         /   \
//       2      3
//     /  \      \
//    4    5      6
//        / \      \
//       7   8      9
//                    \
//                    10
// Target Node = 8
// Output: 7
// Explanation: If leaf with the value 8 is set on fire. 
// After 1 sec: 5 is set on fire.
// After 2 sec: 2, 7 are set to fire.
// After 3 sec: 4, 1 are set to fire.
// After 4 sec: 3 is set to fire.
// After 5 sec: 6 is set to fire.
// After 6 sec: 9 is set to fire.
// After 7 sec: 10 is set to fire.
// It takes 7s to burn the complete tree.
// Input:      
//           1
//         /   \
//       2      3
//     /  \      \
//    4    5      7
//   /    / 
//  8    10
// Target Node = 10
// Output: 5

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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
			if (i >= ip.length)
				break;

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

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
     private static Map<Node, Node> parentMap = new HashMap<>();

    public static int minTime(Node root, int target) {
        Node targetNode = findParentAndTarget(root, null, target);
        return burnTree(targetNode);
    }

    private static Node findParentAndTarget(Node node, Node parent, int target) {
        if (node == null) return null;
        parentMap.put(node, parent);
        if (node.data == target) return node;
        Node leftResult = findParentAndTarget(node.left, node, target);
        return (leftResult != null) ? leftResult : findParentAndTarget(node.right, node, target);
    }

    private static int burnTree(Node targetNode) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        queue.add(targetNode);
        visited.add(targetNode);
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyNodeBurned = false;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null && visited.add(current.left)) {
                    queue.add(current.left);
                    anyNodeBurned = true;
                }
                if (current.right != null && visited.add(current.right)) {
                    queue.add(current.right);
                    anyNodeBurned = true;
                }
                Node parent = parentMap.get(current);
                if (parent != null && visited.add(parent)) {
                    queue.add(parent);
                    anyNodeBurned = true;
                }
            }

            if (anyNodeBurned) time++;
        }

        return time;
    }
}
