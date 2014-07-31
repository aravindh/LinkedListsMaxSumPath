Question:
---------
1->3->30->90->120->240->511
0->3->12->32->90->125->240->249


Given two sorted linked lists. You start with a one of the two lists and then move till the end. You may switch to the other list only at the point of intersection (which mean the two node with the same value in different lists.) You have to find the path of maximum sum.



Output

1->3->12->32->90->125->240->511

The program takes the command line args in which line 1 contains the list1 and line 2 contains list2, in which the elements of the list are comma seperated.

Sample input args:
1,3,30,90,120,240,511 
0,3,12,32,90,125,240,249


