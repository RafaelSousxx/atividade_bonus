public class ValidadorMinHeap {

    /**
     * Valida se um array é um Min-Heap válido
     * Complexidade: O(N)
     *
     * Propriedade: para cada nó i, arr[i] <= arr[2*i+1] e arr[i] <= arr[2*i+2]
     */
    public static boolean ehMinHeap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }

        // Verifica cada nó pai com seus filhos
        for (int i = 0; i < arr.length; i++) {
            int esquerda = 2 * i + 1;  // Índice do filho esquerdo
            int direita = 2 * i + 2;   // Índice do filho direito

            // Se tem filho esquerdo, verifica se pai <= filho esquerdo
            if (esquerda < arr.length && arr[i] > arr[esquerda]) {
                return false;
            }

            // Se tem filho direito, verifica se pai <= filho direito
            if (direita < arr.length && arr[i] > arr[direita]) {
                return false;
            }
        }

        return true;
    }

    // Teste
    public static void main(String[] args) {
        int[] minHeap = {1, 2, 3, 4, 5, 6, 7};
        int[] naoMinHeap = {1, 5, 3, 4, 2, 6, 7};
        int[] outro = {10, 20, 30, 40, 50};

        System.out.println("Array [1, 2, 3, 4, 5, 6, 7] é Min-Heap? " + ehMinHeap(minHeap));
        System.out.println("Array [1, 5, 3, 4, 2, 6, 7] é Min-Heap? " + ehMinHeap(naoMinHeap));
        System.out.println("Array [10, 20, 30, 40, 50] é Min-Heap? " + ehMinHeap(outro));
    }
}
