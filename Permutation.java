//Heaps algorithm with added Set to prevent duplicates
//Note, failing to add a duplicate to a set structure is
//better than having to call .contains on an arraylist
//https://www.javatpoint.com/permutation-of-numbers-in-java

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    static Set<List<Integer>> set = new HashSet();

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5};
        findPermutation(array, array.length, 5);
        System.out.println(set.size());
    }


    static void findPermutation(int array[], int size, int n) {
// if size becomes 1, it prints the obtained permutation
        List<Integer> row = new ArrayList<>();
        if (size == 1) {
            for(int i = 0; i < n; i++){
                row.add(array[i]);
            }
            set.add(row);
        }

        for (int i = 0; i < size; i++) {
            findPermutation(array, size - 1, n);
//if the length of the array is odd, it swaps the 0th element with the last element
            if (size % 2 == 1) {
//performing swapping
                int temp = array[0];
                array[0] = array[size - 1];
                array[size - 1] = temp;
            }
//if the size of the array is even, it swaps the ith element with the last element
            else {
//taking a temp variable for swapping
                int temp;
//performing swapping
                temp = array[i];
                array[i] = array[size - 1];
                array[size - 1] = temp;
            }
        }
    }
}
