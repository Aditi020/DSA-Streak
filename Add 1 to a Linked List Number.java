// You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 
// Note: The head represents the first element of the given array.
// Examples :
// Input: LinkedList: 4->5->6
// Output: 457
// Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
// Input: LinkedList: 1->2->3
// Output: 124
// Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 


import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public Node addOne(Node head) {
        head = reverse(head);

        Node curr = head;
        Node prev = null;
        int carry = 1;

        while (curr != null) {
            int sum = curr.data + carry;
            carry = sum / 10;
            curr.data = sum % 10;

            prev = curr;
            curr = curr.next;
        }

        if (carry > 0) {
            prev.next = new Node(carry);
        }

        return reverse(head);
    }
}
