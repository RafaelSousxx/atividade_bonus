import java.util.*;

public class MescladorListas {

    // Classe auxiliar para armazenar valor, índice da lista e índice do elemento
    static class Elemento implements Comparable<Elemento> {
        int valor;
        int indexLista;
        int indexElemento;

        Elemento(int valor, int indexLista, int indexElemento) {
            this.valor = valor;
            this.indexLista = indexLista;
            this.indexElemento = indexElemento;
        }

        @Override
        public int compareTo(Elemento outro) {
            return Integer.compare(this.valor, outro.valor);
        }
    }

    /**
     * Mescla K listas ordenadas em uma única lista ordenada
     * Complexidade: O(N log K) onde N é o número total de elementos
     */
    public static List<Integer> mesclarKListas(List<List<Integer>> listas) {
        List<Integer> resultado = new ArrayList<>();

        if (listas == null || listas.isEmpty()) {
            return resultado;
        }

        // Min-Heap
        PriorityQueue<Elemento> minHeap = new PriorityQueue<>();

        // Adiciona o primeiro elemento de cada lista
        for (int i = 0; i < listas.size(); i++) {
            List<Integer> lista = listas.get(i);
            if (lista != null && !lista.isEmpty()) {
                Elemento elem = new Elemento(lista.get(0), i, 0);
                minHeap.add(elem);
            }
        }

        // Processa o heap
        while (!minHeap.isEmpty()) {
            Elemento menor = minHeap.poll();
            resultado.add(menor.valor);

            // Adiciona o próximo elemento da mesma lista
            int proximoIndex = menor.indexElemento + 1;
            List<Integer> lista = listas.get(menor.indexLista);

            if (proximoIndex < lista.size()) {
                Elemento proximo = new Elemento(
                        lista.get(proximoIndex),
                        menor.indexLista,
                        proximoIndex
                );
                minHeap.add(proximo);
            }
        }

        return resultado;
    }

    // Teste
    public static void main(String[] args) {
        List<List<Integer>> listas = new ArrayList<>();
        listas.add(Arrays.asList(1, 4, 5));
        listas.add(Arrays.asList(1, 3, 4));
        listas.add(Arrays.asList(2, 6));

        List<Integer> resultado = mesclarKListas(listas);
        System.out.println("Listas: " + listas);
        System.out.println("Mescladas: " + resultado);
    }
}
