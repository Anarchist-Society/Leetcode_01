import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum_01(nums, 6)));
        System.out.println(Arrays.toString(twoSum_02(nums, 6)));
    }

    // Algoritmo 1: Fuerza bruta
    // El enfoque de fuerza bruta: recorrer cada elemento x y encontrar si hay otro valor que es igual a target - x.
    public static int[] twoSum_01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i,j};
                }
            }
        }

        // Si no se encuentra un par válido devuelve una matriz vacía en lugar de NULL.
        return new int[] {};
    }

    // Algoritmo 2: Hash Table
    public static int[] twoSum_02(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int objetivo = target - nums[i];
            if (map.containsKey(objetivo) && map.get(objetivo) != i) {
                return new int[] {i, map.get(objetivo)};
            }
        }

        return new int[] {};
    }
}
