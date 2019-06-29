import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_2 {
    // it holds total moves
    private static int cnt = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeN = input.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < sizeN  ; i++) {
            arr.add(input.nextInt());
        }

        // build max heap
        for (int i = (sizeN-1)/2; i >= 0 ; i--) {
            heapify(arr, i);
        }

        // heap sort by removing root
        for (int i = sizeN-1 ; i >= 1 ; i--) {
            Collections.swap(arr,i,0);
            arr.remove(i);
            heapify(arr,0);
        }

        System.out.println(cnt);
    }

    // recursive implementation of heapify
    private static void heapify(ArrayList<Integer> a, int i){
        int left;
        int right;
        int largest;

        // i is the parent
        left = 2*i +1;
        right = 2*i +2;

        if ( left< a.size() && a.get(left)>a.get(i))
            largest = left;
        else largest = i;
        if ( right<a.size() && a.get(right)>a.get(largest))
            largest = right;

        // if root of subtree change
        if (largest != i) {
            Collections.swap(a, i, largest);
            cnt++;
            heapify(a, largest);
        }
    }
}