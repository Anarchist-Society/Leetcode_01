import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) { 
        int numero = romanToInt_05("MCMXCIV");
        System.out.println(numero);
    } // Primera variante donde donde guardamos los datos con put en el HashMap

    // Estos primeros tres métodos vamos a trabajar con mapas
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
        return numero + map.get(s.charAt(s.length() - 1));
    }

    // Los siguientes métodos vamos a trabajar con switches
    public static int romanToInt_04(String s) {
        int resultado = 0;
        int numero = 0;

        // Recorremos el string de derecha a izquierda
        for (int i = s.length() - 1; i >= 0; i++) {
            // En lugar de usar un Map para establecer el valor de cada letra del número romano usamos un switch
            // Este valor lo almacenamos en una variable temporal que luego se sumará o restará al resultado final
            switch (s.charAt(i)) {
                case 'I':
                    numero = 1;
                    break;
                case 'V':
                    numero = 5;
                    break;
                case 'X':
                    numero = 10;
                    break;
                case 'L':
                    numero = 50;
                    break;
                case 'C':
                    numero = 100;
                    break;
                case 'D':
                    numero = 500;
                    break;
                case 'M':
                    numero = 1000;
                    break;
                default:
                    break;
            }

            // El * 4 es un truco para saber si un símbolo romano se resta en lugar de sumarse
            // En los números romanos, solo se resta cuando el simbolo es mucho más pequeño que el que viene después (como 'I' antes de 'V' o 'X' antes de 'L' o C)
            // Por lo tanto esa regla siempre se cumple cuando el número actual es menor que la cuarta parte del valor que llevamos en 'resultado'

            // Si número * 4 es muy pequeño en comparación con lo que ya sumamos -> resta
            // Si no -> suma
            if (4 * numero < resultado) {
                resultado -= numero; 
            } else {
                resultado += numero;
            }
        }

        return resultado;
    }

    public static int romanToInt_05(String s) {
        int resultado = 0; // Variable que vamos a devolver

        // Bucle con el cual recorremos la frase
        for (int i = 0; i < s.length(); i++)  {
            // Conseguimos el valor del número actual
            int valorActual = getValue(s.charAt(i));

            // Si i es menor que el tamaño de la frase - 1 Y el valor actual es menor que el siguiente (I < V) (1 < 5)
            if (i < s.length() - 1 && valorActual < getValue(s.charAt(i + 1))) {
                resultado -= valorActual; 
            } else {
                resultado += valorActual;
            }
        }

        return resultado;
    }

    // Método con el cual retornamos el valor del número romano
    public static int getValue(char c) {
        switch (c) {
            case 'I': return 1; 
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
