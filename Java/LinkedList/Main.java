package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list1=new LL();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(3);
        list1.insertLast(5);
        list1.insertLast(7);
//        LL list2=new LL();
//        list2.insertLast(2);
//        list2.insertLast(4);
//        list2.insertLast(4);
//        list2.insertLast(4);
//        list2.insertLast(8);

        LL list2=new LL();
        list2.insertLast(9);
        list2.insertLast(4);
        list2.insertLast(1);
        list2.insertLast(8);
        list2.insertLast(4);
        list2.insertLast(2);

//        list1.merge(list2);
        list2.sort();
        list2.display();

    }
}
