public class Heap {
    private int size;
    private int capacity;
    private int[] heap;
    //implementing a MinHeap
    //In java you can use priority queue but here is how a MinHeap works
    public Heap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    public void insertKey(int key){
        if(size == capacity)
            return;
        else{
            this.size++;
            int index = size - 1;
            heap[index] = key;

            //Fix min heap property
            //While child node is greater than the parent.
            while(index != 0 && heap[getParent(index)] > heap[index]){
                int temp = heap[index];
                heap[index] = heap[getParent(index)];
                heap[getParent(index)] = temp;

                index = getParent(index);
            }
        }
    }

    public int getMin(){
        if(size == 0)
            return 0;
        else{
            if(size == 1){
                size--;
                return heap[0];
            }
            else{
                int root = heap[0];
                heap[0] = heap[size-1];
                size--;
                heapify(0);

                return root;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i< size; i++){
            str.append(heap[i] + " ");
        }

        return str.toString();
    }

    private void heapify(int node){
        int left = getLeft(node);
        int right = getRight(node);
        int root = node;

        if(left < size && heap[left] < heap[node])
            root = left;
        if(right < size && heap[right] < heap[root])
            root = right;
        if(root != node){
            int temp = heap[root];
            heap[root] = heap[getParent(root)];
            heap[getParent(root)] = temp;
            heapify(root);
        }
    }

    private int getParent(int node){
        return (node-1)/2;
    }

    private int getLeft(int node){
        return (2*node + 1);
    }

    private int getRight(int node){
        return (2*node + 2);
    }

}
