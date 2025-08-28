public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome_01(121));
        System.out.println(isPalindrome_02(121));
        System.out.println(isPalindrome_03(121));
    }

    // Esto es lo que había pensado yo para resolverlo
    public static boolean isPalindrome_01(int x) {
        String number = Integer.toString(x);
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Una forma de buscar el número reverso de forma matemática
    public static boolean isPalindrome_02(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int reverse = 0;
        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }

        return x == reverse;
    }

    // Otra forma de resolverlo es calculando solo la mitad del número con su mitad reverse
    public static boolean isPalindrome_03(int x) {
        // Si es un número negativo no es palíndromo
        // Si el último dígito es 0 no es palíndromo
        // Pero si x = 0, la segunda regla no se cumple ya que 0 es un palíndromo
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int reverse = 0;
        while (x > reverse) {
            reverse = (reverse * 10) + (x % 10); 
            x /= 10;
        }

        return (x == reverse || x == reverse / 10);
    }
}
