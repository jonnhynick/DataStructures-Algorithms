import java.util.NoSuchElementException;

public class BinaryTree {

    private Node root;
    public enum treeTraversal{
        inOrder,
        preOrder,
        postOrder
    }
    private class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree(){
        root = null;
    }

    public void insert(int data){
        root = insert(root,data);
    }

    private Node insert(Node node, int data){
        if(isEmpty())
            root = new Node(data);
        else{
            if(node.right == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }

        return node;
    }



    public boolean search(int val){
        return search(root, val);
    }

    private boolean search(Node root, int val){
        Node _searchNode = new Node(val);
        if(root.data == val)
            return true;
        if(root.left != null){
            if(search(root.left, val))
                return true;
        }
        if(root.right != null){
            if(search(root.right, val))
                return true;
        }

        return false;
    }

    public String printGraph(treeTraversal traversal){
        String result;
        switch (traversal){
            case inOrder:
                result = inOrder(this.root);
                break;
            case preOrder:
                result = preOrder(this.root);
                break;
            case postOrder:
                result = postOrder(this.root);
                break;
                default:
                    throw new NoSuchElementException();
        }

        return result;
    }

    private String inOrder(Node root){
        if(isEmpty())
            return "";
        else{
            StringBuilder str = new StringBuilder();
            inOrder(root.left);
            str.append(root.data + " ");
            inOrder(root.right);

            return str.toString();
        }
    }

    private String preOrder(Node root){
        if(isEmpty())
            return "";
        else{
            StringBuilder str = new StringBuilder();
            str.append(root.data + " ");
            inOrder(root.left);
            inOrder(root.right);

            return str.toString();
        }
    }

    private String postOrder(Node root){
        if(isEmpty())
            return "";
        else{
            StringBuilder str = new StringBuilder();
            inOrder(root.left);
            inOrder(root.right);
            str.append(root.data + " ");

            return str.toString();
        }
    }

    public boolean isEmpty(){
        return root == null;
    }
}
