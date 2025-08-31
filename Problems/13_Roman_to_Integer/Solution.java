import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int numero = romanToInt_01("MCMXCIV");
        System.out.println(numero);
    }

    // Primera variante donde donde guardamos los datos con put en el HashMap
    public static int romanToInt_01(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Variable a devolver
        int numero = 0;

        // Recorremos el String
        for (int i = 0; i < s.length(); i++) {
            // Aquí guardamos el actual número romano (el valor numérico)
            int actual = map.get(s.charAt(i));

            // Aquí guardamos el siguiente número romano (el valor numérico)
            // Pero con la condición de que si se sobrepasa del tamaño del String se le añade un 0
            int siguiente = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;

            // Si el número actual es menor que el siguiente número
            // Se le resta a la suma total
            // Si no se le suma el número actual
            if (actual < siguiente) {
                numero -= actual;
            } else {
                numero += actual;
            }
        }
        return numero;
    }

    // Segunda variante (solo usamos Map)
    public static int romanToInt_02(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        int numero = 0;
        for (int i = 0; i < s.length(); i++) {
            int actual = map.get(s.charAt(i));

            int siguiente = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;

            if (actual < siguiente) {
                numero -= actual;
            } else {
                numero += actual;
            }
        }
        return numero;
    }

    // Tercera variante
    // Similar que la primera, pero no usamos variables ni el operador ternario
    public static int romanToInt_03(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int numero = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                numero -= map.get(s.charAt(i));
            } else {
                numero += map.get(s.charAt(i));
            }
        }
        return map.get(s.charAt(s.length() - 1));
    }
}
