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
        Node node =new Node(val,temp.next);

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
        node=temp.next;
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

    private Node merge(Node listNode1,Node listNode2){
        Node dummyHead=new Node(0);
        Node tail=dummyHead;
        while(listNode1!=null && listNode2!=null){
            if(listNode1.val>=listNode2.val){
                tail.next=listNode2;
                tail=tail.next;
                listNode2=listNode2.next;
            }else{
                tail.next=listNode1;
                tail=tail.next;
                listNode1=listNode1.next;
            }
        }

        if(listNode1!=null) tail.next=listNode1;
        if(listNode2!=null) tail.next=listNode2;

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
