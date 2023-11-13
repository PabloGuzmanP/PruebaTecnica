public class Ejercicio3 {
    public static void main(String[] args) {
        int[] monedas1 = {5, 7, 1, 1, 2, 3, 22};
        //int[] monedas2 = {1, 1, 1, 1, 1};
        //int[] monedas3 = {1, 5, 1, 1, 1, 10, 15, 20, 100};

        System.out.println("Cantidad minima de cambio: " + cantidadMinimaCambio(monedas1));
    }

    public static int cantidadMinimaCambio(int[] monedas){
        for (int i = 0; i < monedas.length - 1; i++) {
            for (int j = 0; j < monedas.length - 1 - i; j++) {
                if (monedas[j] > monedas[j + 1]) {
                    int aux = monedas[j];
                    monedas[j] = monedas[j + 1];
                    monedas[j + 1] = aux;
                }
            }
        }

        int cambioMinimo = 1;

        for (int i = 0; i < monedas.length; i++){
            if(monedas[i] <= cambioMinimo){
                cambioMinimo = cambioMinimo + monedas[i];
            }
            else{
                break;
            }
        }
        return cambioMinimo;
    }
}

