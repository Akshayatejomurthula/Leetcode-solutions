import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] temp = new Integer[arr.length];
        
        // Step 1: Convert int[] to Integer[]
        for(int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        
        // Step 2: Custom sorting
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if(countA == countB) {
                return a - b;   // sort by number
            }
            
            return countA - countB;  // sort by bit count
        });
        
        // Step 3: Convert back to int[]
        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        
        return arr;
    }
}