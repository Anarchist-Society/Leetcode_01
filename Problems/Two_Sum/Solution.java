import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(Arrays.toString(twoSum_01(nums, 6)));
        System.out.println(Arrays.toString(twoSum_02(nums, 6)));
        System.out.println(Arrays.toString(twoSum_03(nums, 6)));
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

    // Algoritmo 2: Two-pass Hash Table
    // Usamos un HashMap para poder ahorrar velocidad por memoria
    public static int[] twoSum_02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // En el primer bucle lo que hacemos es guardar los valores y los indices en el HashMap
        // Key: nums[i] i -> índice del array
        // Value: i -> índice del array
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // En el segundo bucle comprobamos si está en el HashMap el segundo sumando (target - nums[i]) de cada elemento del array nums
        for (int i = 0; i < nums.length; i++) {
            int objetivo = target - nums[i];
            // Comprobamos si está el segundo sumando (map.containsKey(objetivo)) y si ese sumando no es el mismo que el primer sumando (map.get(objetivo))
            // Si cumple las condiciones devolvemos un nuevo array con el primer sumando y el segundo sumando
            if (map.containsKey(objetivo) && map.get(objetivo) != i) {
                return new int[] {i, map.get(objetivo)};
            }
        }

        // Si no se encuentra un par válido devuelve una matriz vacía en lugar de NULL.
        return new int[] {};
    }

    // Algoritmo 3: One-pass Hash Table
    // Lo mismo que el Algoritmo 2 pero con un solo bucle
    public static int[] twoSum_03(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // En el primer bucle, mientras estamos iterando, vamos comprobando si ya existe el segundo sumando, si existe lo hemos encontrado, sino lo guardamos en el HashMap
        for (int i = 0; i < nums.length; i++) {
            int objetivo = target - nums[i]; // Almacenamos en una variable el segundo sumando que buscamos
            if (map.containsKey(objetivo)) {
                return new int[] {map.get(objetivo), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
