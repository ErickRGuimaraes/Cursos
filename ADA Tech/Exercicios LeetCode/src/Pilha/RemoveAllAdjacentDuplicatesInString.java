package Pilha;
import java.util.Stack; //to use stack

/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
*/

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String test = "caccasssd";

        System.out.println(removeDuplicates(test));
    }

    //Better using the stack
    public static String stackRemoveDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        //go to wich string caracter 
        for (char c : s.toCharArray()) {
            // compare the current character with the last into the stack
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();  // remove top stack character
            } else {
                stack.push(c);  // add in stack
            }
        }

        // build the result string from rest of stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());  // Isert the character in the same order
        }

        return result.toString();  
    }
    // Better soluction more intelligent 
    public static String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int stackSize = stack.length();
            
            if (stackSize > 0 && stack.charAt(stackSize - 1) == c) {
                stack.deleteCharAt(stackSize - 1);  // remove the last character in the stack
            } else {
                stack.append(c);  // Add in stack
            }
        }
        
        return stack.toString();
    }
    // My resolution with don`t search anything Bad Soluction 
    public static String myRemoveDuplicates(String s) {
        String letter = "";
        double length = s.length();
        while(length>0){
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i-1) == s.charAt(i)){
                    letter = Character.toString(s.charAt(i))+Character.toString(s.charAt(i));
                    s=s.replaceAll(letter,"");
                }
            }
            length--;
        }

        return s;
    }


}