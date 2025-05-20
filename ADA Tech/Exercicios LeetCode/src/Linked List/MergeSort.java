package LinkedList;

// Classe contendo o algoritmo Merge Sort para lista encadeada
public class MergeSort {

    // Classe para definir a estrutura de um nó da lista encadeada (agora estática)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Exemplo 1: Lista [4, 2, 1, 3]
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);

        MergeSort solution = new MergeSort();
        ListNode sortedList1 = solution.sortList(head1);
        System.out.print("Lista ordenada 1: ");
        printList(sortedList1);

        // Exemplo 2: Lista [-1, 5, 3, 4, 0]
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);

        ListNode sortedList2 = solution.sortList(head2);
        System.out.print("Lista ordenada 2: ");
        printList(sortedList2);

        // Exemplo 3: Lista []
        ListNode head3 = null;
        ListNode sortedList3 = solution.sortList(head3);
        System.out.print("Lista ordenada 3 (vazia): ");
        printList(sortedList3);
    }

    // Função para ordenar a lista usando Merge Sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Passo 1: dividir a lista ao meio usando dois ponteiros (slow e fast)
        ListNode mid = getMid(head);

        // Passo 2: aplicar merge sort nas duas metades
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Passo 3: mesclar as duas metades ordenadas
        return merge(left, right);
    }

    // Função para encontrar o meio da lista encadeada e dividi-la
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Fast avança 2 passos e slow avança 1 passo, até que fast atinja o final
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Desconectar a primeira metade da segunda metade
        if (prev != null) {
            prev.next = null;
        }

        return slow; // slow é o início da segunda metade
    }

    // Função para mesclar duas listas encadeadas ordenadas
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(); // Nó temporário para começar a mesclagem
        ListNode current = dummy;

        // Mesclar as duas listas, comparando os valores
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Adicionar os nós restantes (se houver) de uma das listas
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next; // Retorna a lista mesclada, ignorando o nó dummy inicial
    }

    // Função auxiliar para imprimir a lista encadeada
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
