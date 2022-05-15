package PackageOne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScratchPaper {
    public static void main(String [] args){
        Set<String> set = new HashSet<String>();
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f'};
        //System.out.println(powerSet(array, array.length).toString());
        set.addAll(powerSet(array, array.length));
        System.out.println(set.size());
    }

    static List<String> powerSet(char [] chars, int size){
        StringBuilder sb;
        List<String> lst = new ArrayList<>();
        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
            int  j;
            for(int i = 0; i < Math.pow(2, size); i++) {
                sb = new StringBuilder();
                for (j = 0; j < size; j++) {
                    if ((i & (1 << j)) > 0) {
                        sb.append((chars[j]));
                    }
                }
                lst.add(sb.toString());
            }
        return lst;
    }

    static List<Integer> combinations(){
        return null;
    }

    static List<Integer> permutations(){
        return null;
    }

    static List<Integer> subStrings(){
        return null;
    }
}
