
public class SinglyLinkedList {

    //Nested Node Class that contains the information blocks.
    private class Node{

        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    private int size;

    public SinglyLinkedList(int data){
        Node _newNode = new Node(data);
        this.head = _newNode;
        this.size = 1;
    }

    public void insertElement(int data){
        //Create new node
        Node _newNode = new Node(data);
        //if head is null assign it to head.
        if(head == null)
            head = _newNode;
        else{
            //traverse until last node reached and append new node.
            Node lastNode = head;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = _newNode;
            this.size++;
        }
    }

    public boolean insertElementAt(int index, int data){
        Node _newNode = new Node(data);
        if(head == null){
            return false;
        }
        else{
            if(index > this.size - 1){
                return false;
            }
            else if(index == 0){
                Node _current = head;
                _newNode.next = _current;
                head = _newNode;
                return true;
            }
            else{
                Node _current = head;
                Node _prev = head;
                for(int i = 0; i < index; i++){
                    _prev = _current;
                    _current = _current.next;
                }
                _prev.next = _newNode;
                _newNode.next = _current;
                this.size++;
                return true;
            }
        }
    }

    public void reverseLinkedList(){
        Node _prev = null;
        Node _next = null;
        Node _current = head;
        while(_current != null){
            _next = _current.next;
            _current.next = _prev;
            _prev = _current;
            _current = _next;
        }
        head = _prev;
    }

    public void deleteLinkedList(){
        head = null;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node printList = head;
        int index = 0;
        while(printList != null){
            str.append("Index: " + index + " Value: " + printList.data + "\n");
            printList = printList.next;
            index++;
        }

        return str.toString();
    }
}
