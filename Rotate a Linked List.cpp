// Given the head of a singly linked list, the task is to rotate the linked list clockwise by k nodes, i.e., left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.
// Examples:
// Input: linkedlist: 2->4->7->8->9 , k = 3
// Output: 8->9->2->4->7
// Explanation:
// Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
// Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
// Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
// Input: linkedlist: 1->2->3->4->5->6->7->8 , k = 4
// Output: 5->6->7->8->1->2->3->4

#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

void printList(Node* node) {
    while (node != NULL) {
        cout << node->data << " ";
        node = node->next;
    }
    cout << "\n";
}
/*

struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

class Solution {
  public:
    // Function to rotate a linked list.
    Node* rotate(Node* head, int k) {
        Node* t1 = new Node(-1),*t2=new Node(-1);
        Node* h1 = t1,*h2 = t2;
        while(head){
            if(k){
                t1->next = head;
                t1 = t1->next;
                k--;
            }else{
                t2->next = head;
                t2 = t2->next;
            }
            head = head->next;
                t1->next = nullptr;
                t2->next = nullptr;
        }
        t2->next = h1->next;
        return h2->next;
    }
};
