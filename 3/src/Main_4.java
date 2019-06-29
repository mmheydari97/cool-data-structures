import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_4 {
    public static void main(String[] args) {
        int sizeN;
        Scanner input = new Scanner(System.in);

        // number of cities
        sizeN = input.nextInt();
        
        // all cities
        ArrayList<node> cities = new ArrayList<>();
        
        // cities to be processed
        ArrayList<node> queue = new ArrayList<>();

        // number of edges
        int sizeM = input.nextInt();
        
        // we also have a dummy node with index 0
        // initial prices of concert tickets equal cost of the edges
        // between the dummy node and each city
        for (int j = 0; j <= sizeN; j++) {
            node v = new node(j);
            cities.add(v);
            queue.add(v);
        }

        // first costs i.e. edges of dummy node
        for (int i = 1; i <= sizeN ; i++) {
            cities.get(0).add_edge(cities.get(i),input.nextInt());
        }

        // edges between cities
        for (int i = 0; i < sizeM ; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int val = input.nextInt();
            
            // if an edge causes improvement we consider it
            if (2*val <= cities.get(0).neighbours.get(cities.get(v)))
                cities.get(u).add_edge(cities.get(v),2*val);

            if (2*val <= cities.get(0).neighbours.get(cities.get(u)))
                cities.get(v).add_edge(cities.get(u),2*val);
        }

        // cities with no neighbors won't be processed
        for (node v : cities) {
            if (v.neighbours.keySet().isEmpty())
                queue.remove(v);
        }


        cities.get(0).key = 0;
        while (queue.size()!=0){
            build_heap(queue);
            node u = pop_min(queue);
            for (node v :cities.get(u.id).neighbours.keySet()) {
                if (v.key > u.key+u.neighbours.get(v)) {
                    v.key = u.key + u.neighbours.get(v);
                }
            }
        }
        
        // remove the dummy city
        cities.remove(0);

        for (node c:cities) {
            System.out.printf("%d ",c.key);
        }
    }

    // builds min heap
    private static void build_heap(ArrayList<node> queue){
        for (int i = queue.size()/2; i >=0 ; i--) {
            heapify(queue, i);
        }
    }

    // recursive min heapify alogorithm
    private static void heapify(ArrayList<node> a, int i){
        int l;
        int r;
        int smallest;
        l = 2*i +1;
        r = 2*i +2;
        if ( l < a.size() && a.get(l).key < a.get(i).key)
            smallest = l;
        else smallest = i;
        if ( r < a.size() && a.get(r).key < a.get(smallest).key)
            smallest = r;
        if (smallest != i) {
            Collections.swap(a, i, smallest);
            heapify(a, smallest);
        }
    }

    private static node pop_min(ArrayList<node> queue){
        node min = queue.get(0);
        Collections.swap(queue , 0, queue.size()-1);
        queue.remove(queue.size()-1);
        return min;
    }

}

// represents a city
class node {
    int id;
    node(int id){
        this.id = id;
    }

    // ar first all edges cost infinity
    int key = Integer.MAX_VALUE;
    HashMap<node, Integer> neighbours = new HashMap<>();
    
    void add_edge(node v, int value){
        neighbours.put(v, value);
    }
}
