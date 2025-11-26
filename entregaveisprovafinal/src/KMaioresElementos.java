import java.util.*;

public class KMaioresElementos {

    /**
     * Encontra os K maiores elementos de um array
     * Complexidade: O(N log K)
     */
    public static List<Integer> encontrarKMaiores(int[] arr, int k) {
        if (k <= 0 || arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        k = Math.min(k, arr.length);

        // Min-Heap com capacidade k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Adiciona os primeiros k elementos
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        // Para cada elemento restante
        for (int i = k; i < arr.length; i++) {
            // Se o elemento é maior que o menor do heap
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // Retorna lista ordenada
        List<Integer> resultado = new ArrayList<>(minHeap);
        Collections.sort(resultado, Collections.reverseOrder());
        return resultado;
    }

    // Teste
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 3;

        List<Integer> resultado = encontrarKMaiores(arr, k);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("K = " + k);
        System.out.println("K maiores elementos: " + resultado);
    }
}
