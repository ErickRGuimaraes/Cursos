

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    }

    public static ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        int length = 0;
        
        while (first != null) {
            length++;
            first = first.next;
        }

        ListNode firstNode = head;
        for (int i = 1; i < k; i++) {
            firstNode = firstNode.next;
        }

        ListNode secondNode = head;
        for (int i = 1; i < length - k + 1; i++) {
            secondNode = secondNode.next;
        }

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }
}
