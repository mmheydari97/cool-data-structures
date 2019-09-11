import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class Main_1 {
    private static int cost = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // vertices
        ArrayList<Node> vertices = new ArrayList<>();

        // vertices to be precessed
        ArrayList<Node> queue = new ArrayList<>();

        // number of vertices
        int sizeN = input.nextInt();

        // matrix of costs
        int[][] a = new int[sizeN][sizeN];

        // dummy node
        Node dummy = new Node(0);
        dummy.key = 0;
        vertices.add(dummy);
        queue.add(dummy);

        // read input
        for (int j = 0; j <sizeN; j++) {
            a[0][j] = input.nextInt();
        }

        for (int i = 1; i < sizeN ; i++) {
            Node temp = new Node(i);
            vertices.add(temp);
            queue.add(temp);
            for (int j = 0; j <sizeN; j++) {
                a[i][j] = input.nextInt();
            }
        }

        Node u;
        build_heap(queue);
        while (!queue.isEmpty()){
            build_heap(queue);
            u = pop_min(queue);

            // update costs matrix
            for (Node v: queue) {
                if (v!=u &&  a[u.id][v.id]< v.key ){
                    v.key = a[u.id][v.id];
                }
            }
        }

        // print total cost
        for (Node v: vertices) {
            cost += v.key;
        }

        System.out.println(cost);

    }


    private static Node pop_min(ArrayList<Node> queue){
        Node min = queue.get(0);
        Collections.swap(queue , 0, queue.size()-1);
        queue.remove(queue.size()-1);
        heapify(queue, 0);
        return min;
    }

    private static void heapify(ArrayList<Node> a, int i){
        int left;
        int right;
        int smallest;
        left = 2*i +1;
        right = 2*i +2;
        if ( left < a.size() && a.get(left).key < a.get(i).key)
            smallest = left;
        else smallest = i;
        if ( right < a.size() && a.get(right).key < a.get(smallest).key)
            smallest = right;
        if (smallest != i) {
            Collections.swap(a, i, smallest);
            heapify(a, smallest);
        }
    }

    // builds min heap
    private static void build_heap(ArrayList<Node> queue){
        for (int i = queue.size()/2; i >=0 ; i--) {
            heapify(queue, i);
        }
    }
}

class Node {
    int id;
    Node(int id){
        this.id = id;
    }
    // at first all edges cost infinity
    int key = Integer.MAX_VALUE;
}