package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.

 

Example 1:

Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned. 
 */
public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        String[] test = {"d","b","c","b","c","a"};
        int termPosition = 1;

        System.out.println(kthDistinct(test,termPosition));
    }

    public static String kthDistinct(String[] arr, int k) { // Corrigi o nome do método aqui
        HashMap<String, Integer> frequencyMap = new HashMap<>(); 

        // frequency count
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // search the K valeu 
        int count = 0;
        for (String str : arr) {
            if (frequencyMap.get(str) == 1) { 
                count++;
                if (count == k) { 
                    return str;
                }
            }
        }

        // if dont encounter 
        return "";
    }

    public static String firstKthDistinct(String[] arr, int k) { // Corrigi o nome do método para seguir a convenção camelCase
        List<String> distinct = new ArrayList<>(); // Armazena strings distintas
        List<String> repeated = new ArrayList<>(); // Armazena strings repetidas

        for(String str : arr){ // Percorre o array
            if(distinct.contains(str)){ // Se a string é repetida, armazenar em uma lista diferente
                distinct.remove(str);
                repeated.add(str);
            } else if(!distinct.contains(str) && !repeated.contains(str)){
                distinct.add(str); // Se for única, armazena-a
            }
        }

        if(distinct.size() < k) return "";

        return distinct.get(k-1);
    }
}