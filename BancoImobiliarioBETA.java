import java.util.Random;
import java.util.Scanner;

public class BancoImobiliarioBETA {

    // CONSTANTES
    public static final int JOGADORES = 4;
    public static final int CASAS_TABULEIRO = 40;

    // dados
    static Random dice = new Random();
    static int dado1;
    static int dado2;

    final static Scanner ler = new Scanner(System.in);

    public static int girarDado() {
        return dice.nextInt(6) + 1;
    } // gira um dado de [1, 6]

    // cor de cada jogador no terminal: vermelho, azul, verde e amarelo
    static final String[] CORES_JOGADORES = { "\u001B[31m", "\u001B[34m", "\u001B[32m", "\u001B[33m" };
    static final String SEM_COR = "\u001B[0m";

    
    public static String alinharTabuleiro(int numeroCasa, int[] posicaoJogador) {
        String casa = "[ ";
        int jogadoresNaCasa = 0;

        
        for (int i = 0; i < JOGADORES; i++) {
            if (posicaoJogador[i] == numeroCasa) {
                casa += CORES_JOGADORES[i] + "█" + SEM_COR;
                jogadoresNaCasa++;
            }
        }

        if (jogadoresNaCasa == 0) {
            // casa vazia mostra o número dela
            casa += String.format("%-3d", numeroCasa);
        } 
        else {
            
            for (int i = jogadoresNaCasa; i < 3; i++) {
                casa += " ";
            }
        }

        return casa + "] ";
    }

    // imprime o tabuleiro inteiro, as posições -1 são o miolo vazio
    public static void imprimirTabuleiro(int[][] tabuleiro, int[] posicaoJogador) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] >= 0) {
                    System.out.print(alinharTabuleiro(tabuleiro[i][j], posicaoJogador));
                } 
                else {
                    System.out.print("       "); // mesmo tamanho de uma casa
                }
            }

            System.out.println("\n");
        }
    }

    public static int colocarNoDesempate(int maiorResultadoDado, int[] somaDadoJogadores,
            boolean[] considerarDesempate) {
        int jogadoresDesempate = 0;

        for (int i = 0; i < JOGADORES; i++) { // só coloca o jogador no desempate
            if (somaDadoJogadores[i] == maiorResultadoDado) {
                jogadoresDesempate++;
                considerarDesempate[i] = true;
            }

            System.out.println(considerarDesempate[i]); 
        }

        return jogadoresDesempate;
    }

    public static int decidirJogadorQueComeca(int jogadoresDesempate, boolean[] estaDesempate, int[] somaDadoJogadores,
            int maiorResultadoDado) {
        while (jogadoresDesempate > 1) {
            System.out.println("\nDesempate:");
            maiorResultadoDado = 0;
            jogadoresDesempate = 0;
            for (int i = 0; i < JOGADORES; i++) {
                if (estaDesempate[i]) {
                    System.out.printf("Jogador %d:\n", i + 1);
                    dado1 = girarDado();
                    dado2 = girarDado();
                    System.out.println(dado1);
                    System.out.println(dado2);
                    somaDadoJogadores[i] = dado1 + dado2;

                    if (somaDadoJogadores[i] > maiorResultadoDado) {
                        maiorResultadoDado = somaDadoJogadores[i];
                    }
                }
            }

            for (int i = 0; i < JOGADORES; i++) {
                if (estaDesempate[i]) {
                    if (somaDadoJogadores[i] == maiorResultadoDado) {
                        jogadoresDesempate++;
                    } else {
                        estaDesempate[i] = false;
                    }
                }
            }
        }

        for (int i = 0; i < JOGADORES; i++) {
            if (estaDesempate[i]) {
                return i;
            }
        }

        return 0;
    }

    public static void comprarOuPagarPropriedade() {

    }

    public static void main(String[] args) {
        int jogadorDaVez = 0;
        int[] somaDadosJogador = new int[JOGADORES];
        int[] posicaoJogador = new int[JOGADORES];

        // cadeia
        int[] turnosCadeia = new int[JOGADORES];
        int dadosIguais = 0;

        // variaveis usadas para decidir quem começa e desempatar
        int maiorResultadoDado = 0;
        boolean[] estaNoDesempate = new boolean[JOGADORES];
        int jogadoresDesempate = 0;

        // propriedades
        boolean[] ePropriedade = { false, true, true, false, true, true, false, true, false, true, false, false, true,
                true, false, true, false, true, true, true, false, true, false, false, false, true, true, false, true,
                false, false, true, false, true, true, true, false, true, false, true };
        int[] proprietarios = new int[CASAS_TABULEIRO];

        // variaveis representativas
        int[][] tabuleiro = {
                { 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 },
                { 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31 },
                { 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, 32 },
                { 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33 },
                { 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34 },
                { 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35 },
                { 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36 },
                { 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37 },
                { 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38 },
                { 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39 },
                { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }
        };

        for (int i = 0; i < JOGADORES; i++) {
            System.out.printf("Jogador %d:\n", jogadorDaVez + 1);
            dado1 = girarDado();
            dado2 = girarDado();
            somaDadosJogador[i] = dado1 + dado2;
            System.out.println(dado1 + "\n" + dado2);

            if (somaDadosJogador[i] > maiorResultadoDado) {
                maiorResultadoDado = somaDadosJogador[i];
            }

            jogadorDaVez++;
        }

        System.out.println();

        jogadoresDesempate = colocarNoDesempate(maiorResultadoDado, somaDadosJogador, estaNoDesempate);
        jogadorDaVez = decidirJogadorQueComeca(jogadoresDesempate, estaNoDesempate, somaDadosJogador,
                maiorResultadoDado);

        System.out.printf("\nJogador %d começa:\n\n", jogadorDaVez + 1);

        while (true) {

            if (turnosCadeia[jogadorDaVez] > 0) {
                turnosCadeia[jogadorDaVez]--;
            } 
            else {
                System.out.printf("Jogador %d:\n", jogadorDaVez + 1);
                dado1 = girarDado();
                dado2 = girarDado();
                somaDadosJogador[jogadorDaVez] = dado1 + dado2;
                System.out.println(dado1 + "\n" + dado2);

                posicaoJogador[jogadorDaVez] += somaDadosJogador[jogadorDaVez];
                posicaoJogador[jogadorDaVez] %= CASAS_TABULEIRO;

                imprimirTabuleiro(tabuleiro, posicaoJogador);
            }

            jogadorDaVez = (jogadorDaVez + 1) % JOGADORES; // passa a vez

            if (ler.nextInt() == 67) {
                break;
            }
        } // fim do while 
    } // fim do main
} // fim da classe