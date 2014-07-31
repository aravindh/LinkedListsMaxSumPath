public class MaximumSumPath {
    public static Node getMaximumSumPath(Node head1, Node head2){
        Node current1 = head1;
        Node current2 = head2;
        Node max_path_head = null;
        int sum1 = 0, sum2 =0;
        if(current1 == null && current2 == null) {
            return null;
        }
        while(current1 != null || current2 != null) {
            int current1_num = (current1 == null)? 0 : current1.data;
            int current2_num = (current2 == null)? 0 : current2.data;
            if(current2 != null && current1_num > current2_num) {
                //move current 2
                sum2 = sum2 + current2_num;
                current2 = current2.next;
            }
            else if(current1 != null && current1_num < current2_num) {
                //move current 1
                sum1 = sum1 + current1_num;
                current1 = current1.next;
            }
            else {
                //current1.data = current2.data
                if(sum1 > sum2){
                    //add the list1 path
                    current1.next = getMaximumSumPath(current1.next, current2.next);
                    max_path_head = head1;
                }
                else {
                    //add the list2 path
                    current2.next = getMaximumSumPath(current1.next, current2.next);
                    max_path_head = head2;
                }
            }
        }
        return max_path_head;
    }
    public static void displayList(Node head){
        Node current = head;
        System.out.println("\nLinked List:");
        while(current != null){
            System.out.print(" "+current.data);
            current = current.next;
        }
    }
    public static void main(String args[]) {
        Node head1 = new Node(0, null);
        Node head2 = new Node(0, null);
        Node current = head1;
        current.next = new Node(1,null); current = current.next;
        current.next = new Node(3, null); current = current.next;
        current.next = new Node(30,null); current = current.next;
        current.next = new Node(90,null); current = current.next;
        current.next = new Node(120,null); current = current.next;
        current.next = new Node(240, null); current = current.next;
        current.next = new Node(511,null);
        current = head2;
        current.next = new Node(0,null); current = current.next;
        current.next = new Node(3, null); current = current.next;
        current.next = new Node(12,null); current = current.next;
        current.next = new Node(32,null); current = current.next;
        current.next = new Node(90,null); current = current.next;
        current.next = new Node(125,null); current = current.next;
        current.next = new Node(240, null); current = current.next;
        current.next = new Node(249, null);
        displayList(head1.next);
        displayList(head2.next);
        Node maxPathHead = getMaximumSumPath(head2.next, head1.next);
        displayList(maxPathHead);

    }

}

