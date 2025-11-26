import java.util.*;

public class ListaPrioridadeDupla {

    private PriorityQueue<Integer> maxHeap;  // Max-Heap
    private PriorityQueue<Integer> minHeap;  // Min-Heap
    private Map<Integer, Integer> frequencia; // Rastreia elementos removidos

    public ListaPrioridadeDupla() {
        // Max-Heap usando comparador reverso
        this.maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        this.minHeap = new PriorityQueue<>();
        this.frequencia = new HashMap<>();
    }

    /**
     * Adiciona um valor à fila de prioridade dupla
     */
    public void inserir(int valor) {
        maxHeap.add(valor);
        minHeap.add(valor);
        frequencia.put(valor, frequencia.getOrDefault(valor, 0) + 1);
    }

    /**
     * Retorna o maior valor sem remover
     */
    public int obterMaximo() {
        // Remove elementos inválidos do topo
        while (!maxHeap.isEmpty() && frequencia.getOrDefault(maxHeap.peek(), 0) <= 0) {
            maxHeap.poll();
        }

        if (maxHeap.isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        return maxHeap.peek();
    }

    /**
     * Retorna o menor valor sem remover
     */
    public int obterMinimo() {
        // Remove elementos inválidos do topo
        while (!minHeap.isEmpty() && frequencia.getOrDefault(minHeap.peek(), 0) <= 0) {
            minHeap.poll();
        }

        if (minHeap.isEmpty()) {
            throw new NoSuchElementException("Fila vazia");
        }
        return minHeap.peek();
    }

    /**
     * Remove e retorna o maior valor
     */
    public int removerMaximo() {
        int maximo = obterMaximo();
        frequencia.put(maximo, frequencia.get(maximo) - 1);
        return maximo;
    }

    /**
     * Remove e retorna o menor valor
     */
    public int removerMinimo() {
        int minimo = obterMinimo();
        frequencia.put(minimo, frequencia.get(minimo) - 1);
        return minimo;
    }

    // Teste
    public static void main(String[] args) {
        ListaPrioridadeDupla fila = new ListaPrioridadeDupla();

        fila.inserir(5);
        fila.inserir(3);
        fila.inserir(7);
        fila.inserir(1);
        fila.inserir(9);

        System.out.println("Máximo: " + fila.obterMaximo()); // 9
        System.out.println("Mínimo: " + fila.obterMinimo()); // 1

        System.out.println("Removido máximo: " + fila.removerMaximo()); // 9
        System.out.println("Removido mínimo: " + fila.removerMinimo()); // 1

        System.out.println("Novo máximo: " + fila.obterMaximo()); // 7
        System.out.println("Novo mínimo: " + fila.obterMinimo()); // 3
    }
}
