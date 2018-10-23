import java.util.NoSuchElementException;

public class Queue {

    private Node front;
    private int size;

    private class Node{
        public Node link;
        public int data;

        public Node(int data){
            this.link = null;
            this.data = data;
        }
    }

    public Queue(){
        this.front = null;
        this.size = 0;
    }

    public void enQueue(int data){
        Node _newNode = new Node(data);
        if(front == null){
            front = _newNode;
            this.size++;
        }
        else{
            Node temp = front;
            while(temp.link != null){
                temp = temp.link;
            }

            temp.link = _newNode;
            this.size++;
        }
    }

    public int peek(){
        if(front == null)
            throw new NoSuchElementException();
        else{
            return front.data;
        }
    }

    public int deQueue(){
        if(front == null)
            throw new NoSuchElementException();
        else{
            Node _frontNode = front;
            front = front.link;

            return _frontNode.data;
        }
    }

    @Override
    public String toString(){
        Node temp = front;
        StringBuilder str = new StringBuilder();
        while(temp != null){
            str.append(temp.data + " ");
            temp = temp.link;
        }
        return str.toString();
    }
}
