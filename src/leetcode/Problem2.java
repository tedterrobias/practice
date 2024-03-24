package leetcode;

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    void display(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node!=null) {
            sb.append(node.val);
            node = node.next;
        }
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int counter = 1;
        int l1Num = 0;
        int l2Num = 0;
        while(l1.next!=null || l1.next!=null) {
            int placeVal = placeValue(counter);

            if(l1 != null) {
                l1Num = l1Num + (l1.val * placeVal);
                l1 = l1.next;
            }
            if(l2 != null) {
                l2Num = l2Num + (l2.val * placeVal);
                l2 = l2.next;
            }
            counter++;
        }
        counter = 1;

        int sum = l1Num + l2Num;
        if(sum == 0) return new ListNode(0);

        ListNode first;
        ListNode listNode;
        ListNode temp;

        int a = sum % placeValue(counter);
        first = new ListNode(a);
        listNode = first;

        while(a <= sum) {
            a = sum % placeValue(counter);
            temp = new ListNode(a);
            listNode.next = temp;
            listNode = temp;

            counter++;
        }

        return first;
    }

    public int placeValue(int a) {
        return (int) Math.pow(10, a);
    }
}

public class Problem2 {

//test
  public static void main(String [] args) {
      ListNode node1 = new ListNode();
      ListNode node2 = new ListNode();

      node1.val = 2;
      node2.val = 5;


      Solution sol = new Solution();
      ListNode node = sol.addTwoNumbers(node1, node2);

      node.display(node);
  }
}
