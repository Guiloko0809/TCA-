import java.util.Random;
import java.util.Scanner;

public class BancoImobiliarioBETA { //digite (chcp 65001) no terminal pra liberar os caracteres

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

    public static String formatarCasa(int numeroCasa, int[] posicaoJogador, TipoCasa[] tipoCasasTabuleiro,
            Propriedade[] propriedades) {

        final String[] CORES = { "\u001B[31m", "\u001B[34m", "\u001B[32m", "\u001B[33m" };
        final String RESET = "\u001B[0m";

        // fundo de cada grupo, o 0 não é usado (verde, laranja, azul claro, rosa, roxo, azul escuro, amarelo)
        final String[] FUNDOS = { "", "\u001B[30;48;5;40m", "\u001B[30;48;5;208m", "\u001B[30;48;5;117m",
                "\u001B[30;48;5;205m", "\u001B[30;48;5;141m", "\u001B[30;48;5;33m", "\u001B[30;48;5;226m" };

        // mesmos grupos, só que mais escuros
        final String[] FUNDOS_ESCUROS = { "", "\u001B[97;48;5;22m", "\u001B[97;48;5;94m", "\u001B[97;48;5;17m",
                "\u001B[97;48;5;125m", "\u001B[97;48;5;54m", "\u001B[97;48;5;17m", "\u001B[97;48;5;94m" };

        // jogador que tem a cor parecida com a do grupo (-1 = nenhum)
        final int[] JOGADOR_MESMA_COR = { -1, 2, 3, 1, -1, -1, 1, 3 };

        // letra das casas especiais (tipo 4), o 0 não é usado
        // 1 cadeia, 2 imposto de renda, 3 férias, 4 lucros e dividendos, 5 vá pra cadeia
        final String[] CASOS_A_PARTE = { "", "C", "IR", "F", "LD", "VC" };

        TipoCasa casa = tipoCasasTabuleiro[numeroCasa];
        String fundo = RESET; // casa sem cor fica igual
        String letra = "I"; // a casa 0 é o início
        int grupo = 0;

        if (casa.getTipoDaCasa() == 1) {

            letra = "P";
            grupo = propriedades[casa.getPosicaoCartaCasa()].getGrupo();
            fundo = FUNDOS[grupo];

            // se tem jogador da mesma cor do grupo na casa, escurece a casa
            for (int p = 0; p < JOGADORES; p++) {

                if (posicaoJogador[p] == numeroCasa && JOGADOR_MESMA_COR[grupo] == p) {
                    fundo = FUNDOS_ESCUROS[grupo];
                }

            }

        }
        else if (casa.getTipoDaCasa() == 2) {

            letra = "CO";
            fundo = "\u001B[30;48;5;245m"; // companhia fica cinza

        }
        else if (casa.getTipoDaCasa() == 3) {

            letra = "SR";

        }
        else if (casa.getTipoDaCasa() == 4) {

            letra = CASOS_A_PARTE[casa.getPosicaoCartaCasa()];

        }

        StringBuilder blocos = new StringBuilder();
        int ocupados = 0;

        for (int p = 0; p < JOGADORES; p++) {

            if (posicaoJogador[p] == numeroCasa) {

                blocos.append(CORES[p]).append("█").append(fundo); // volta pro fundo da casa
                ocupados++;

            }

        }

        String conteudo;

        if (ocupados > 0) {

            conteudo = " " + blocos + " ".repeat(3 - ocupados);
             // sempre 4 caracteres visíveis
        } 
        else {

            conteudo = String.format(" %-3s", letra);
             // sempre 4 caracteres visíveis
        }

        return fundo + "[" + conteudo + "]" + RESET + " "; // 7 caracteres visíveis no total
    }

    public static int colocarNoDesempate(int maiorResultadoDado, int[] somaDadosJogador,
            boolean[] considerarDesempate) {
        int jogadoresDesempate = 0;

        for (int i = 0; i < JOGADORES; i++) { // só coloca o jogador no desempate
            if (somaDadosJogador[i] == maiorResultadoDado) {
                jogadoresDesempate++;
                considerarDesempate[i] = true;
            }

        }

        return jogadoresDesempate;
    }

    public static int decidirJogadorQueComeca(int jogadoresDesempate, boolean[] estaDesempate, int[] somaDadosJogador,
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
                    somaDadosJogador[i] = dado1 + dado2;
                    DadoAnimado.animarDados(dado1, dado2);
                    System.out.printf("\n---------- RESULTADO FINAL: %d ---------\n", somaDadosJogador[i]);
                    

                    if (somaDadosJogador[i] > maiorResultadoDado) {
                        maiorResultadoDado = somaDadosJogador[i];
                    }
                }
            }

            for (int i = 0; i < JOGADORES; i++) {
                if (estaDesempate[i]) {
                    if (somaDadosJogador[i] == maiorResultadoDado) {
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
        int[] dinheiroJogador = {2558000, 2558000, 2558000, 2558000};
        // cadeia
        int[] turnosCadeia = new int[JOGADORES];
        boolean jogarNovamente = false;
        int dadosIguais = 0;

        // variaveis usadas para decidir quem começa e desempatar
        int maiorResultadoDado = 0;
        boolean[] estaNoDesempate = new boolean[JOGADORES];
        int jogadoresDesempate = 0;


        // variaveis relacionadas ao tabuleiro
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

        TipoCasa[] tipoCasasTabuleiro = TipoCasa.criarTabuleiro(); 
        Propriedade[] propriedades = Propriedade.criarPropriedades();
        Companhia[] companhias = Companhia.criarCompanhias();

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
        }//todos os jogadores jogam dois dados para decidir quem começa

        System.out.println();

        jogadoresDesempate = colocarNoDesempate(maiorResultadoDado, somaDadosJogador, estaNoDesempate);
        jogadorDaVez = decidirJogadorQueComeca(jogadoresDesempate, estaNoDesempate, somaDadosJogador,
                                               maiorResultadoDado);

        System.out.printf("\nJogador %d começa:\n\n", jogadorDaVez + 1);

        while (true) {

            System.out.printf("Jogador %d: R$%d\n", jogadorDaVez + 1, dinheiroJogador[jogadorDaVez]);

            if (turnosCadeia[jogadorDaVez] > 0) {
                System.out.printf("Você está na cadeia, espere mais %d turnos e seja livre !!!\n", turnosCadeia[jogadorDaVez]);
                turnosCadeia[jogadorDaVez]--;
            } 
            else {
                dado1 = girarDado();
                dado2 = girarDado();
                somaDadosJogador[jogadorDaVez] = dado1 + dado2;
                DadoAnimado.animarDados(dado1, dado2); //animação dado
                System.out.printf("\n---------- RESULTADO FINAL: %d ---------\n", somaDadosJogador[jogadorDaVez]);

                posicaoJogador[jogadorDaVez] += somaDadosJogador[jogadorDaVez];
                
                if(posicaoJogador[jogadorDaVez] >= CASAS_TABULEIRO){
                    System.out.println("Você deu uma volta no tabuleiro1, ganhando assim mais R$ 200.000");
                    posicaoJogador[jogadorDaVez] %= CASAS_TABULEIRO;
                    dinheiroJogador[jogadorDaVez] += 200000;
                }

                if(dado1 == dado2){
                    dadosIguais++;

                    if(dadosIguais < 3){
                        System.out.println("Você tirou dados iguais jogue novamente !!!");
                        jogarNovamente = true;
                    }else{
                        System.out.println("Você foi pra cadeia, fique 3 turnos sem jogar !!!");
                        turnosCadeia[jogadorDaVez] = 3;
                        jogarNovamente = false;
                        dadosIguais = 0;
                    }
                }else{
                    jogarNovamente = false;
                    dadosIguais = 0;
                }

                // imprime tabuleiro
                for (int i = 0; i < tabuleiro.length; i++) {

                    for (int j = 0; j < tabuleiro[0].length; j++) {

                        if (tabuleiro[i][j] >= 0) {

                            System.out.print(formatarCasa(tabuleiro[i][j], posicaoJogador, tipoCasasTabuleiro, propriedades));
                            
                        } 
                        else {

                            System.out.print("       ");
                        }
                    }

                    System.out.println("\n");
                }
            }

            if(!jogarNovamente){
                jogadorDaVez = (jogadorDaVez + 1) % JOGADORES;
            }

            if (ler.nextInt() == 67) {
                break;
            }
        } // fim do while 
    } // fim do main
} // fim da classe