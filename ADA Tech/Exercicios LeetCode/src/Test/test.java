package Test;

public class test {
    public static void main(String[] args) {

        int n = 7_500_000;

        while (n>0 && n <= 2_000_000_000) {
            System.out.println();
            System.out.println("Valor de n: " + n);
            int[] vet = new int[n];

            for (int i = 0; i < vet.length; i++) {
                vet[i] = i;
            }
            int x = 0;
            long[] vetTime = new long[5];
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0 ->
                        x = 0;
                    case 1 ->
                        x = n / 2;
                    case 2 ->
                        x = n;
                    default -> {
                    }
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("Execução pesquisa Sequencial numero #" + i + ": ");
                    System.out.println("Pesquisar por: " + x);
                    long tempoInicial = System.nanoTime();
                    
                    System.out.println("Resultado pesquisa: " + pesquisaSequencial(vet, x));
                    
                    long tempoFinal = System.nanoTime() - tempoInicial;
                    System.out.println("Tempo de execucao: " + tempoFinal);
                    vetTime[i] = tempoFinal;
                }

                System.out.println();
                System.out.println("Média aritmética do tempo de execução para n = " + n + ": " + (double) (encontraMaiorMenor(vetTime) / 3));
                System.out.println();
                
                
                System.out.println("");
                
                for (int i = 0; i < 5; i++) {
                    System.out.println("Execução pesquisa Binária numero #" + i + ": ");
                    System.out.println("Pesquisar por: " + x);
                    long tempoInicial = System.nanoTime();
                    
                    System.out.println("Resultado pesquisa binaria: " + pesquisaBinaria(vet, x));
                    
                    long tempoFinal = System.nanoTime() - tempoInicial;
                    System.out.println("Tempo de execucao: " + tempoFinal);
                    vetTime[i] = tempoFinal;
                }
                
                System.out.println();
                System.out.println("Média aritmética do tempo de execução para n = " + n + ": " + (double) (encontraMaiorMenor(vetTime) / 3));
                System.out.println();
            }
            
            System.out.println("---------------------------------------------");

            n *= 2;
        }

    }

    public static long encontraMaiorMenor(long[] vet) {
        int pMaior = 0, pMenor = 0;
        long sum = vet[0];

        for (int i = 1; i < 5; i++) {
            if (vet[i] > vet[pMaior]) {
                pMaior = i;
            }
            if (vet[i] < vet[pMenor]) {
                pMenor = i;
            }
            System.out.println(vet[i]);
            sum += vet[i];
        }

        sum -= vet[pMenor];
        sum -= vet[pMaior];

        return sum;
    }

    public static boolean pesquisaSequencial(int[] vet, int x) {
        boolean resp = false;
        int n = vet.length;
        int cont = 0;
        for (int i = 0; i < n; i++) {
            if (vet[i] == x) {
                resp = true;
                i = n;
            }
            cont++;
        }
        System.out.println("Quantidade de comparacoees: " + cont++);
        return resp;
    }

    public static boolean pesquisaBinaria(int[] vet, int x) {
        int dir = vet.length - 1, esq = 0, cont = 0;
        while (esq <= dir) {
            int meio = esq + (dir - esq) / 2;
            cont++;
            if (x == vet[meio]) {
                System.out.println("Quantidade de comparacoes: " + cont);
                return true;
            } else if (x > vet[meio]) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }
        System.out.println("Quantidade de comparacoes: " + cont);
        return false;
    }

}