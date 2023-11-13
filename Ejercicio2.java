import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        int[] entrada = {5, 9, 29, 0, 10};
        int S = 9;

        int[] resultado = obtenerCuadradosOrdenados(entrada, S);

        System.out.println("Matriz original: " + Arrays.toString(entrada));
        System.out.println("Resultado: " + Arrays.toString(resultado));
    }

    public static int[] obtenerCuadradosOrdenados(int[] matriz, int S) {
        int[] cuadrados = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            cuadrados[i] = matriz[i] * matriz[i];
        }
        
        for (int i = 0; i < cuadrados.length - 1; i++) {
            for (int j = 0; j < cuadrados.length - 1 - i; j++) {
                if (cuadrados[j] > cuadrados[j + 1]) {
                    int aux = cuadrados[j];
                    cuadrados[j] = cuadrados[j + 1];
                    cuadrados[j + 1] = aux;
                }
            }
        }

        int[] resultado = eliminarFueraDeRango(cuadrados, S);

        return resultado;
    }

    public static int[] eliminarFueraDeRango(int[] matriz, int S) {
        int cantidadValida = 0;

        // Contar la cantidad de elementos válidos
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] >= 0 && matriz[i] <= S * S) {
                cantidadValida++;
            }
        }

        // Crear un nuevo array con el tamaño adecuado
        int[] resultado = new int[cantidadValida];
        int index = 0;

        // Copiar los elementos válidos al nuevo array
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] >= 0 && matriz[i] <= S * S) {
                resultado[index++] = matriz[i];
            }
        }

        return resultado;
    }
}
