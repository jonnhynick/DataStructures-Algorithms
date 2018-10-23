import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.RE;

import java.util.NoSuchElementException;

public class Stack {

    private Node top;
    private int size;
    private class Node{
        public int data;
        public Node link;

        public Node(int data){
            this.data = data;
            link = null;
        }
    }

    public Stack(){
        top = null;
        size = 0;
    }

    public void push(int data){
        Node _newNode = new Node(data);
        if(top == null)
            top = _newNode;
        else{
            _newNode.link = top;
            top = _newNode;
        }
        this.size++;
    }

    public int pop(){
        if(top == null)
            throw new NoSuchElementException();
        else{
            Node _topNode = top;
            top = _topNode.link;
            size--;
            return _topNode.data;
        }
    }

    public int peek(){
        if(top == null)
            throw new NoSuchElementException();
        else{
            return top.data;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        if(top == null)
            return "Empty";
        else{
            Node _topNode = top;
            while(_topNode != null){
                str.append(_topNode.data + " ");
                _topNode = _topNode.link;
            }
            return str.toString();
        }
    }

}
