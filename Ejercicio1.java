import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        int s = 9;
        int[] arreglo = {91, 99, 29, 0, 10};
        //int[] arreglo = {10, 20, 30, 40, 50};

        System.out.println("--------------------------------------------");
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));

        boolean contieneNueve = contieneNueve(arreglo, s);

        if(contieneNueve==true){
            verificarArreglo(arreglo, s);
        }else{
            invertirArreglo(arreglo);
        }
        
        System.out.println("Arreglo Resultado: " + Arrays.toString(arreglo));
        System.out.println("--------------------------------------------");
    }

    public static void verificarArreglo(int[] arreglo, int s) {
        for (int i = 0; i < arreglo.length; i++) {
            boolean verificarNumero = verificarNumero(arreglo[i], s);

            if (verificarNumero) {
                arreglo[i] = eliminarNumero(arreglo[i], s);
            }
        }
    }

    public static boolean verificarNumero(int numero, int s) {
        while (numero > 0) {
            int digito = numero % 10;
            if (digito >= s) {
                return true;
            }
            numero = numero / 10;
        }
        return false;
    }

    public static int eliminarNumero(int numero, int s) {
        int nuevoNumero = 0;

        while (numero > 0) {
            int digito = numero % 10;
            if (digito < s) {
                nuevoNumero = nuevoNumero * 10 + digito;
            }
            numero = numero / 10;
        }
        return nuevoNumero;
    }

    public static void invertirArreglo(int[] arreglo) {
        int inicio = 0;
        int fin = arreglo.length - 1;

        while (inicio < fin) {
            // Intercambiar elementos
            int temp = arreglo[inicio];
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = temp;

            // Moverse hacia el siguiente par de elementos
            inicio++;
            fin--;
        }
    }

    public static boolean contieneNueve(int[] arreglo, int s) {
        for (int i = 0; i < arreglo.length; i++) {
            if (verificarNumero(arreglo[i], s)) {
                return true;
            }
        }
        return false;
    }
}
