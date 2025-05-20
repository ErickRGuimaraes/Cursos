package Fila;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Arrays;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[]  nums = {1,1,1,2,2,3,3,3,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Create a map to count the frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Create a PriorityQueue (max-heap) that orders by highest frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); //change the order if prioritized the number whith most frequency fist 
        //a.getValue() - b.getValue() this form the number bigger is prioritized 

        // Add all entries from the frequency map to the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.add(entry);
        }

        // Extract the k most frequent elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey(); // Get the key of the most frequent element heap.poll remove the head of the queue and getKey() get the element
        }

        return result;
    }
}
