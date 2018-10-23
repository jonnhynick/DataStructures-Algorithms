public class DoublyLinkedList {

    private Node head;
    private int size;

    //Nested Node Class that contains the information blocks.
    private class Node{

        public int data;
        public Node next;
        public Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList(int data){
        Node _newNode = new Node(data);
        head = _newNode;
        this.size++;
    }

    public void pushElement(int data){
        Node _newNode = new Node(data);


        if(head == null){
            head = _newNode;
        }
        else{
            Node current = head;
            Node prev = head;
            if(size == 1 ){
                _newNode.prev = head;
                head.next = _newNode;
            }
            else{
                while(current.next != null){
                    prev = current;
                    current = current.next;
                }
                current.prev = prev;
                _newNode.prev = current;
                current.next = _newNode;

            }
        }
        this.size++;
    }

    public boolean insertAt(int index, int data){
        Node _newNode = new Node(data);
        if(head == null)
            return false;
        else{
            if(index > size -1)
                return false;
            else if(index == 0){
                Node _current = head;
                _newNode.next = _current;
                head = _newNode;
                head.prev = null;
                return true;
            }
            else{
                Node _current = head;
                Node _prev = head;
                for(int i = 0; i < index; i++){
                    _prev = _current;
                    _current = _current.next;
                }

                _newNode.next = _prev.next;
                _prev.next = _newNode;
                _newNode.prev = _prev;

                if(_newNode.next != null)
                    _newNode.next.prev = _newNode;

                return true;
            }
        }
    }

    public void reverseLinkedList(){ //EDIT PLZ
        Node temp = null;
        Node _current = head;
        while(_current != null){
            temp = _current.prev;
            _current.prev = _current.next;
            _current.next = temp;
            _current = _current.prev;
        }
        if(temp != null){
            head = temp.prev;
        }
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
