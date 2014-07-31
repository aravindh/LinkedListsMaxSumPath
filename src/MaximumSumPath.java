public class MaximumSumPath {
    public static Node getMaximumSumPath(Node head1, Node head2){
        Node max_path_head = null;
        Node current1 = head1;
        Node current2 = head2;
        int sum1=0, sum2 =0;
        if(current1 == null && current2 == null) {
            max_path_head = null;
            return max_path_head;
        }
        while(current1 != null && current2 != null) {
            if(current1.data == current2.data) {
                //current1.data = current2.data
                if(sum2 > sum1){
                    //add the list1 path
                    current2.next = getMaximumSumPath(current1.next, current2.next);
                    max_path_head = head2;
                    return max_path_head;

                } else{
                    //add the list2 path
                    current1.next = getMaximumSumPath(current1.next, current2.next);
                    max_path_head = head1;
                    return max_path_head;
                }
            }
            else if(current1.data > current2.data) {
                //move current 2
                sum2 = sum2 + current2.data;
                current2 = current2.next;
            }
            else {
                //move current 1
                sum1 = sum1 + current1.data;
                current1 = current1.next;
            }
        }
        if(current1 == null) {
            while(current2 != null) {
                sum2 = sum2 + current2.data;
                current2 = current2.next;
            }
        }
        else {
            while(current1 != null) {
                sum1 = sum1 + current1.data;
                current1 = current1.next;
            }
        }
        if(sum1 > sum2){
            //add the list1 path
            max_path_head = head1;
        }
        else {
            //add the list2 path
            max_path_head = head2;
        }
        return max_path_head;
    }
    public static Node getMaximumSumPath1(Node head1, Node head2){
        Node current1 = head1;
        Node current2 = head2;
        Node max_path_head = null;
        int sum1 = 0, sum2 =0;
        int prev1_num = 0, prev2_num = 0;
        if(current1 == null && current2 == null) {
            return null;
        }
        while(current1 != null || current2 != null) {
            //int current1_num = (current1 == null)? 0 : current1.data;
            //int current2_num = (current2 == null)? 0 : current2.data;
            if(current1 == null) {
                while(current2 != null) {
                    sum2 = sum2 + current2.data;
                    current2 = current2.next;
                }
            }
            else {
                while(current1 != null) {
                    sum1 = sum1 + current1.data;
                    current1 = current1.next;
                }
            }
            if((current1 == null && current2 == null) || current1.data == current2.data) {
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
            else if(current1.data > current2.data) {
                //move current 2
                sum2 = sum2 + current2.data;
                current2 = current2.next;
            }
            else {
                //move current 1
                sum1 = sum1 + current1.data;
                current1 = current1.next;
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
        for(String num :args[0].split(",")){
            current.next = new Node(Integer.parseInt(num), null);
            current = current.next;
        }
        current = head2;
        for(String num :args[1].split(",")){
            current.next = new Node(Integer.parseInt(num), null);
            current = current.next;
        }
        displayList(head1.next);
        displayList(head2.next);
        Node maxPathHead = getMaximumSumPath(head2.next, head1.next);
        displayList(maxPathHead);
    }

}

