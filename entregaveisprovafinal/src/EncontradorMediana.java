import java.util.*;

public class EncontradorMediana {

    private PriorityQueue<Integer> maxHeap;  // Metade inferior (Max-Heap)
    private PriorityQueue<Integer> minHeap;  // Metade superior (Min-Heap)

    public EncontradorMediana() {
        // Max-Heap para metade inferior
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // Min-Heap para metade superior
        this.minHeap = new PriorityQueue<>();
    }

    /**
     * Adiciona um número ao fluxo
     * Mantém o balance entre os dois heaps
     */
    public void adicionarNumero(int numero) {
        // Primeiro adiciona ao maxHeap
        if (maxHeap.isEmpty() || numero <= maxHeap.peek()) {
            maxHeap.add(numero);
        } else {
            minHeap.add(numero);
        }

        // Balanceia os heaps: maxHeap pode ter no máximo 1 elemento a mais
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    /**
     * Retorna a mediana do fluxo de dados
     */
    public double encontrarMediana() {
        if (maxHeap.isEmpty()) {
            throw new NoSuchElementException("Nenhum número foi adicionado");
        }

        // Se quantidade é ímpar, retorna o topo do maxHeap
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        // Se quantidade é par, retorna a média dos dois topos
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    // Teste
    public static void main(String[] args) {
        EncontradorMediana mediana = new EncontradorMediana();

        mediana.adicionarNumero(1);
        System.out.println("Após adicionar 1: " + mediana.encontrarMediana()); // 1.0

        mediana.adicionarNumero(2);
        System.out.println("Após adicionar 2: " + mediana.encontrarMediana()); // 1.5

        mediana.adicionarNumero(3);
        System.out.println("Após adicionar 3: " + mediana.encontrarMediana()); // 2.0

        mediana.adicionarNumero(4);
        System.out.println("Após adicionar 4: " + mediana.encontrarMediana()); // 2.5

        mediana.adicionarNumero(5);
        System.out.println("Após adicionar 5: " + mediana.encontrarMediana()); // 3.0
    }
}
