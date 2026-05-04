package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size=0;
    }

    public void insertFirst(int val){
        Node node=new Node(val);

        if(head==null && tail==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        node.next=head;
        head=node;
        size++;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        if(head==null && tail==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        tail.next=node;
        tail=node;
        size++;
    }
    public void insert(int val,int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node temp=head;
        Node node =new Node(val);

        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size-1){
            insertLast(val);
            return;
        }

        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        size++;
    }
    public void removeFirst(){
        if(head==null && tail==null){
            System.out.println("LL is empty");
            return;
        }

        head=head.next;
        size--;
    }
    public void removeLast(){
        if(head==null && tail==null){
            System.out.println("LL is empty");
            return;
        }
        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        if(temp.next==tail){ //must have condition but better to check
            temp.next=null;
            tail=temp;
        }
        size--;
    }
    public void delete(int index){
        if(index<0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }

        Node temp=head;
        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size - 1) {
            removeLast();
            return;
        }
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        size--;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" --> ");
            temp=temp.next;
        }
            System.out.println("END");

    }
    public void length(){
        System.out.println(size);
    }

    public void insert2(int val,int index){
        head=recursiveInsert(val,index,head);
        size++;
    }
    private Node recursiveInsert(int val,int index,Node temp) {
        if(index==0){
            return new Node(val,temp);
        }

        temp.next=recursiveInsert(val,index-1,temp.next);
        return temp;
    }

    public void merge(LL list2){

        Node head=new Node(0);
        Node temp=head;
        Node temp1=this.head;
        Node temp2=list2.head;

        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=temp1;
                temp=temp.next;
                temp1=temp1.next;
            }else{
                temp.next=temp2;
                temp=temp.next;
                temp2=temp2.next;
            }
        }

        if(temp1!=null) temp.next=temp1;
        if(temp2!=null) temp.next=temp2;

        this.head=head.next;

    }

    public void sort(){
        head=mergeSort(head);
    }

    private Node merge(Node Node1,Node Node2){
        Node dummyHead=new Node(0);
        Node tail=dummyHead;
        while(Node1!=null && Node2!=null){
            if(Node1.val>=Node2.val){
                tail.next=Node2;
                tail=tail.next;
                Node2=Node2.next;
            }else{
                tail.next=Node1;
                tail=tail.next;
                Node1=Node1.next;
            }
        }

        if(Node1!=null) tail.next=Node1;
        if(Node2!=null) tail.next=Node2;

        return dummyHead.next;

    }

    private Node mergeSort(Node first){
        if(first==null || first.next==null) return first;

        Node mid=getMid(first);
        Node rightHead=mid.next;
        mid.next=null;

        Node leftNode=mergeSort(first);
        Node rightNode=mergeSort(rightHead);

        return merge(leftNode,rightNode);

    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void doubleNum(){
        head=doubleIt(head);
    }
    private Node doubleIt(Node head) {
        int num = 0;
        Node temp = head;

        while (temp != null) {
            int value = temp.val;
            num = (num * 10) + value;

            temp = temp.next;
        }

        doubleNumber(num*2);

        return this.head;

    }

    private Node doubleNumber(int num) {
        if (num == 0) {
            return null;
        }
        int value = num % 10;
        num = num / 10;

        Node nex = doubleNumber(num);
        Node prev = new Node(value);
        if(nex!=null){
            nex.next = prev;
            return prev;

        }else{
            head=prev;
        }

        return head;
    }

    private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val=val;
        }

        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }

}
