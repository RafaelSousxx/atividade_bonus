import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   EXERCÍCIOS DE LISTA DE PRIORIDADE");
        System.out.println("==========================================\n");

        // EXERCÍCIO 1: K Maiores Elementos
        System.out.println("--- EXERCÍCIO 1: K Maiores Elementos ---");
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 3;
        List<Integer> resultado1 = KMaioresElementos.encontrarKMaiores(arr, k);
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("K = " + k);
        System.out.println("K maiores elementos: " + resultado1);
        System.out.println();

        // EXERCÍCIO 2: Mesclagem de K Listas Ordenadas
        System.out.println("--- EXERCÍCIO 2: Mesclagem de K Listas Ordenadas ---");
        List<List<Integer>> listas = new ArrayList<>();
        listas.add(Arrays.asList(1, 4, 5));
        listas.add(Arrays.asList(1, 3, 4));
        listas.add(Arrays.asList(2, 6));
        List<Integer> resultado2 = MescladorListas.mesclarKListas(listas);
        System.out.println("Listas: " + listas);
        System.out.println("Mescladas: " + resultado2);
        System.out.println();

        // EXERCÍCIO 3: Lista de Prioridade Dupla
        System.out.println("--- EXERCÍCIO 3: Lista de Prioridade Dupla ---");
        ListaPrioridadeDupla fila = new ListaPrioridadeDupla();
        fila.inserir(5);
        fila.inserir(3);
        fila.inserir(7);
        fila.inserir(1);
        fila.inserir(9);
        System.out.println("Inseridos: 5, 3, 7, 1, 9");
        System.out.println("Máximo: " + fila.obterMaximo());
        System.out.println("Mínimo: " + fila.obterMinimo());
        System.out.println("Removido máximo: " + fila.removerMaximo());
        System.out.println("Removido mínimo: " + fila.removerMinimo());
        System.out.println("Novo máximo: " + fila.obterMaximo());
        System.out.println("Novo mínimo: " + fila.obterMinimo());
        System.out.println();

        // EXERCÍCIO 4: Validação de Min-Heap
        System.out.println("--- EXERCÍCIO 4: Validação de Min-Heap ---");
        int[] minHeapValido = {1, 2, 3, 4, 5, 6, 7};
        int[] naoMinHeap = {1, 5, 3, 4, 2, 6, 7};
        int[] outro = {10, 20, 30, 40, 50};
        System.out.println("Array [1, 2, 3, 4, 5, 6, 7] é Min-Heap? " + ValidadorMinHeap.ehMinHeap(minHeapValido));
        System.out.println("Array [1, 5, 3, 4, 2, 6, 7] é Min-Heap? " + ValidadorMinHeap.ehMinHeap(naoMinHeap));
        System.out.println("Array [10, 20, 30, 40, 50] é Min-Heap? " + ValidadorMinHeap.ehMinHeap(outro));
        System.out.println();

        // EXERCÍCIO 5: Encontrar Mediana em Fluxo de Dados
        System.out.println("--- EXERCÍCIO 5: Encontrar Mediana em Fluxo de Dados ---");
        EncontradorMediana mediana = new EncontradorMediana();
        mediana.adicionarNumero(1);
        System.out.println("Após adicionar 1: " + mediana.encontrarMediana());
        mediana.adicionarNumero(2);
        System.out.println("Após adicionar 2: " + mediana.encontrarMediana());
        mediana.adicionarNumero(3);
        System.out.println("Após adicionar 3: " + mediana.encontrarMediana());
        mediana.adicionarNumero(4);
        System.out.println("Após adicionar 4: " + mediana.encontrarMediana());
        mediana.adicionarNumero(5);
        System.out.println("Após adicionar 5: " + mediana.encontrarMediana());

        System.out.println("\n==========================================");
        System.out.println("   TODOS OS EXERCÍCIOS EXECUTADOS COM SUCESSO!");
        System.out.println("==========================================");
    }
}
