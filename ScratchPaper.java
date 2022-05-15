import java.util.*;

public class ScratchPaper {
    static List<List<Character>> ans;
    static List<Character> current;
    public static void main(String [] args){
        Set<String> set = new HashSet<String>();
        char[] array = {'a', 'b', 'c','d'};
        String[] letters = {"a","b","c","d"};
        String str = "abc";
        //System.out.println(powerSet(array, array.length).toString());
        //set.addAll(powerSet(array));
        //set.addAll(combinations(array));
        //System.out.println(set.toString());
       // System.out.println(permutations(array));
        List<List<Character>> temp = combination(array,array.length, 3);
        for(int i =0; i < temp.size(); i++){
            System.out.println(temp.get(i).toString());
        }
    }

    //https://leetcode.com/problems/combinations/discuss/2030259/Easy-Faster-Efficient-Java-Soln
    static List<List<Character>> combination(char[] chars, int n, int k) {
        ans = new ArrayList<>();
        current = new ArrayList<>();
        combinationHelper(chars, 1, n, k);
        return ans;
    }
    static void combinationHelper(char[] chars, int idx, int n, int k){
        if(k == 0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i = idx; i <= n; i++){
            current.add(chars[i-1]);
            combinationHelper(chars, i + 1, n, k - 1);
            current.remove(current.size() - 1);
        }
    }
    

    static List<String> powerSet(char [] chars){
        StringBuilder sb;
        List<String> lst = new ArrayList<>();
        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
            int  j;
            for(int i = 0; i < Math.pow(2, chars.length); i++) {
                sb = new StringBuilder();
                for (j = 0; j < chars.length; j++) {
                    if ((i & (1 << j)) > 0) {
                        sb.append((chars[j]));
                    }
                }
                lst.add(sb.toString());
            }
        return lst;
    }


    // Iterative function to generate all permutations of a string in Java
    // using Collections
    static List<String> permutations(char[] str) {

        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();
       // StringBuilder sb = new StringBuilder();

        // initialize the list with the first character of the string
        partial.add(""+str[0]);
        //sb.append(str[0]);

        // do for every character of the specified string
        for (int i = 1; i < str.length; i++) {
            // consider previously constructed partial permutation one by one
            // (iterate backward to avoid ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0 ; j--) {
                // remove current partial permutation from the ArrayList
                String s = partial.remove(j);

                // Insert the next character of the specified string at all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed strings in the list

                for (int k = 0; k <= s.length(); k++) {
                    // Advice: use StringBuilder for concatenation
                    partial.add(s.substring(0, k) + str[i] + s.substring(k));
                }
            }
        }

        return partial;
    }

    static List<Integer> subStrings(){
        return null;
    }
}
