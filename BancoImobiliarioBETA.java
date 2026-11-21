import java.util.Random;
import java.util.Scanner;

public class BancoImobiliarioBETA { // digite (chcp 65001) no terminal pra liberar os caracteres (windows apenas)

    // CONSTANTES
    public static int JOGADORES; // não é final porque muda de acordo com o que o player escolhe
    public static final int GRUPOS = 7;
    public static final int CASAS_TABULEIRO = 40;

    // casas especiais
    public static final int IMPOSTO_DE_RENDA = 200000; // valor que o jogador paga ao cair no imposto de renda
    public static final int LUCROS_E_DIVIDENDOS = 200000; // valor que o jogador recebe ao cair em lucros e dividendos
    public static final int POSICAO_CADEIA = 10; // posição da casa da cadeia no tabuleiro

    // dados
    static Random geradorAleatorio = new Random();
    static int valorDado1;
    static int valorDado2;

    // o que o jogador digita no teclado (opção de menu ou número de um jogador)
    static int entrada;
    static int contador = 0; //pra qualquer coisa que conte

    final static Scanner ler = new Scanner(System.in);

    public static int girarDado() {
        return geradorAleatorio.nextInt(6) + 1;
    } // gira um dado de [1, 6]

    public static int sortearSorteOuReves() {
        return geradorAleatorio.nextInt(20);
    } // método para sortear um número de 0 a 19, cujo é utilizado no método
      // sorteOuReves()

    // variaveis globais de propriedades
    static int[] propriedadesCompradasPorGrupo = propriedadesCompradasPorGrupo();
    static int[] grupo1 = criarProprietariosDoGrupo(3);
    static int[] grupo2 = criarProprietariosDoGrupo(6);
    static int[] grupo3 = criarProprietariosDoGrupo(3);
    static int[] grupo4 = criarProprietariosDoGrupo(2);
    static int[] grupo5 = criarProprietariosDoGrupo(2);
    static int[] grupo6 = criarProprietariosDoGrupo(3);
    static int[] grupo7 = criarProprietariosDoGrupo(3);

    public static void sorteOuReves(int jogadorDaVez, int[] turnosRestantesNaCadeia, int[] dinheiroDosJogadores,
            int[] posicaoDosJogadores) {

        // Casos 0 ao 7: O jogador ganha dinheiro
        // Casos 8 ao 15: O jogador perde dinheiro
        // Casos 16 e 17: Um jogador ganha, outro jogador perde
        // Caso 18: O jogador vai para cadeia
        // Caso 19: O jogador manda outro para cadeia

        int cartaSorteada = sortearSorteOuReves();

        switch (cartaSorteada) {

            case 0:
                System.out.println("Você acabou de ganhar na Lotofácil!");
                System.out.println("Você ganhou R$100.000!");
                dinheiroDosJogadores[jogadorDaVez] += 100000;

                break;

            case 1:
                System.out.println("Você trabalhou por 30 dias! Quanto esforço!");
                System.out.println("Você ganhou R$ 1.741,00!");
                dinheiroDosJogadores[jogadorDaVez] += 1741;

                break;

            case 2:
                System.out.println("Seu pai era dono do jogo do bicho e faleceu, você tomou conta dos negócios.");
                System.out.println("Você ganhou R$270.000!");
                dinheiroDosJogadores[jogadorDaVez] += 270000;

                break;

            case 3:
                System.out.println("Você ganhou um processo na justiça!");
                System.out.println("Você ganhou R$50.000!");
                dinheiroDosJogadores[jogadorDaVez] += 50000;

                break;

            case 4:
                System.out.println("Você fechou um contrato importante, e acabou saindo na frente!");
                System.out.println("Você ganhou R$55.000!");
                dinheiroDosJogadores[jogadorDaVez] += 55000;

                break;

            case 5:
                System.out.println(
                        "Você arrematou um carro exótico no leilão, supostamente usado pelo Ayrton Senna. Você reforma o carro e vende por um preço absurdo!");
                System.out.println("Você ganhou R$70.000!");
                dinheiroDosJogadores[jogadorDaVez] += 70000;

                break;

            case 6:
                System.out.println("Tigrinho soltou a carta, e você ganha o jackpot!");
                System.out.println("Você ganhou R$80.000!");
                dinheiroDosJogadores[jogadorDaVez] += 80000;

                break;

            case 7:
                System.out.println("Você ganhou o campeonato de farmar aura! Moggou todos os betinhas.");
                System.out.println("Você ganhou R$67.667! Quanta aura!");
                dinheiroDosJogadores[jogadorDaVez] += 67667;

                break;

            case 8:
                System.out.println("Você aposta no tigrinho, e ele não soltou a carta.");
                System.out.println("Você perdeu R$90.000.");
                dinheiroDosJogadores[jogadorDaVez] -= 90000;

                break;

            case 9:
                System.out.println(
                        "Em um dia chuvoso, seu carro de luxo acaba derrapando a traseira e bate na barreira da rodovia.");
                System.out.println("Você perdeu R$120.000.");
                dinheiroDosJogadores[jogadorDaVez] -= 120000;

                break;

            case 10:
                System.out.println("Você atropela uma idosa rica e ela acaba te processando. Você perde o processo.");
                System.out.println("Você perdeu R$60.000.");
                dinheiroDosJogadores[jogadorDaVez] -= 60000;

                break;

            case 11:
                System.out.println(
                        "Você perde o campeonato de farmar aura. Para ninguém saber a vergonha que passou, você paga quem fez seus vídeos para eles não postarem.");
                System.out.println("Você perdeu R$67.667.");
                dinheiroDosJogadores[jogadorDaVez] -= 67667;

                break;

            case 12:
                System.out.println("Um tsunami surpresa na praia da Barra(RJ) acaba destruindo sua casa de férias.");
                System.out.println("Você perdeu R$110.000.");
                dinheiroDosJogadores[jogadorDaVez] -= 110000;

                break;

            case 13:
                System.out.println("No trajeto de volta para sua casa, você é encurralado por dois caras em uma moto e acaba sendo assaltado.");
                System.out.println("Você perdeu R$50.000.");
                dinheiroDosJogadores[jogadorDaVez] -= 50000;

                break;

            case 14:
                System.out.println(
                        "No meio do campeonato, você acaba quebrando seu braço e teve que pagar uma cirurgia.");
                System.out.println("Você perdeu R$20.000.");
                dinheiroDosJogadores[jogadorDaVez] -= 20000;

                break;

            case 15:
                System.out.println("Você cai em um golpe na internet, e acaba comprando 10.000 Benjamins.");
                System.out.println("Você perdeu R$60.000.");
                dinheiroDosJogadores[jogadorDaVez] -= 60000;

                break;

            case 16:

                System.out.println("Você planeja um assalto à propriedade de um rival!");
                System.out.println("Quem você quer assaltar?");
                entrada = ler.nextInt();
                entrada = verificarEntradaValida(new int[] { 1, 2, 3, 4 }, entrada);

                // o jogador digita o número (1 a 4), mas o vetor começa no 0, por isso o "- 1"
                while (entrada - 1 == jogadorDaVez || entrada > JOGADORES) {
                    if (entrada - 1 == jogadorDaVez) { // duas mensagens diferentes de acordo com o caso
                        System.out.println("Entrada inválida !!! Você não pode assaltar você mesmo !!!");
                    } else {
                        System.out.println("Entrada inválida !!! Jogador não existe !!!");
                    }

                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] { 1, 2, 3, 4 }, entrada);
                }

                System.out.printf("Você invadiu a propriedade do Jogador %d e roubou R$60.000!\n", entrada);
                dinheiroDosJogadores[entrada - 1] -= 60000;
                dinheiroDosJogadores[jogadorDaVez] += 60000;

                break;

            case 17:
                System.out.println("Você hackeou o Pix de alguém e fez uma transferência misteriosa!");
                System.out.println("Quem você quer hackear?");
                entrada = ler.nextInt();
                entrada = verificarEntradaValida(new int[] { 1, 2, 3, 4 }, entrada);

                while (entrada - 1 == jogadorDaVez || entrada > JOGADORES) {
                    if (entrada - 1 == jogadorDaVez) { // duas mensagens diferentes de acordo com o caso
                        System.out.println("Entrada inválida !!! Você não pode hackear você mesmo !!!");
                    } else {
                        System.out.println("Entrada inválida !!! Jogador não existe !!!");
                    }

                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] { 1, 2, 3, 4 }, entrada);
                }

                System.out.printf("Você tirou R$45.000 da conta do Jogador %d!\n", entrada);
                dinheiroDosJogadores[entrada - 1] -= 45000;
                dinheiroDosJogadores[jogadorDaVez] += 45000;

                break;

            case 18:
                System.out.println("Você foi pego sonegando impostos e a policia federal bateu na sua porta..");
                System.out.println("Você foi para cadeia, fique 3 turnos sem jogar!");
                posicaoDosJogadores[jogadorDaVez] = POSICAO_CADEIA;
                turnosRestantesNaCadeia[jogadorDaVez] = 3;

                break;

            case 19:
                System.out.println("Você deu propina para um policial federal e mandou ele prender alguem!");
                System.out.println("Quem você quer mandar para a cadeia?");

                entrada = ler.nextInt();
                entrada = verificarEntradaValida(new int[] { 1, 2, 3, 4 }, entrada);

                while (entrada - 1 == jogadorDaVez || entrada > JOGADORES) {
                    if (entrada - 1 == jogadorDaVez) {
                        System.out.println("Entrada inválida !!! Você não pode mandar você mesmo pra cadeia !!!");
                    } else {
                        System.out.println("Entrada inválida !!! Jogador não existe !!!");
                    }

                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] { 1, 2, 3, 4 }, entrada);
                }

                System.out.printf("O Jogador %d foi preso, ficará 3 turnos sem jogar !!!\n", entrada);
                posicaoDosJogadores[entrada - 1] = POSICAO_CADEIA;
                turnosRestantesNaCadeia[entrada - 1] = 3;

                break;

        }

    }

    public static String formatarCasa(int numeroDaCasa, int[] posicaoDosJogadores, TipoCasa[] casasDoTabuleiro,
            Propriedade[] propriedades) {

        // cor de cada jogador: vermelho, azul, verde e amarelo
        final String[] CORES_DOS_JOGADORES = { "\u001B[31m", "\u001B[34m", "\u001B[32m", "\u001B[33m" };
        final String CODIGO_RESETAR_COR = "\u001B[0m";

        // fundo de cada grupo (vermelho, verde, laranja, azul claro, rosa, roxo, azul
        // escuro, amarelo)
        final String[] FUNDO_NORMAL_POR_GRUPO = { "\u001B[101m", "\u001B[30;48;5;40m", "\u001B[30;48;5;208m",
                "\u001B[30;48;5;117m",
                "\u001B[30;48;5;205m", "\u001B[30;48;5;141m", "\u001B[30;48;5;33m", "\u001B[30;48;5;226m" };

        // mesmos grupos, só que mais escuros (usados quando tem qualquer jogador na
        // casa)
        final String[] FUNDO_ESCURO_POR_GRUPO = { "\u001B[48;5;52m", "\u001B[97;48;5;22m", "\u001B[97;48;5;94m",
                "\u001B[97;48;5;17m",
                "\u001B[97;48;5;125m", "\u001B[97;48;5;54m", "\u001B[97;48;5;17m", "\u001B[97;48;5;94m" };

        // sigla das casas especiais (tipo 4), na ordem da posição da carta da casa
        // 0 cadeia, 1 imposto de renda, 2 férias, 3 lucros e dividendos, 4 vá pra
        // cadeia
        final String[] SIGLAS_CASAS_ESPECIAIS = { "CA", "IR", "FE", "LD", "VC" };

        TipoCasa casaAtual = casasDoTabuleiro[numeroDaCasa];
        String fundoDaCasa = CODIGO_RESETAR_COR; // casa sem cor fica igual
        String siglaDaCasa = "I"; // a casa 0 é o início
        int grupoDaPropriedade = 0;

        if (casaAtual.getTipoDaCasa() == 1) {

            siglaDaCasa = "PR";
            grupoDaPropriedade = propriedades[casaAtual.getPosicaoCartaCasa()].getGrupo();
            fundoDaCasa = FUNDO_NORMAL_POR_GRUPO[grupoDaPropriedade];

            // se tem qualquer jogador na casa, escurece a casa pra ele aparecer melhor
            for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) {

                if (posicaoDosJogadores[indiceDoJogador] == numeroDaCasa) {
                    fundoDaCasa = FUNDO_ESCURO_POR_GRUPO[grupoDaPropriedade];
                }

            }

        } else if (casaAtual.getTipoDaCasa() == 2) {

            siglaDaCasa = "CO";
            fundoDaCasa = "\u001B[30;48;5;245m"; // companhia fica cinza

        } else if (casaAtual.getTipoDaCasa() == 3) {

            siglaDaCasa = "SR";
            fundoDaCasa = FUNDO_NORMAL_POR_GRUPO[0];

            for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) {

                if (posicaoDosJogadores[indiceDoJogador] == numeroDaCasa) {
                    fundoDaCasa = FUNDO_ESCURO_POR_GRUPO[0];
                }

            }

        } else if (casaAtual.getTipoDaCasa() == 4) {

            siglaDaCasa = SIGLAS_CASAS_ESPECIAIS[casaAtual.getPosicaoCartaCasa()];

        }

        StringBuilder blocosDosJogadores = new StringBuilder();
        int quantidadeDeJogadoresNaCasa = 0;

        for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) {

            if (posicaoDosJogadores[indiceDoJogador] == numeroDaCasa) {

                blocosDosJogadores.append(CORES_DOS_JOGADORES[indiceDoJogador]).append("█").append(fundoDaCasa); // volta
                                                                                                                 // pro
                                                                                                                 // fundo
                                                                                                                 // da
                                                                                                                 // casa
                quantidadeDeJogadoresNaCasa++;

            }

        }

        String conteudoDaCasa;

        if (quantidadeDeJogadoresNaCasa > 0) {

            String espacoInicial = (quantidadeDeJogadoresNaCasa < 4) ? " " : "";
            conteudoDaCasa = espacoInicial + blocosDosJogadores
                    + " ".repeat(Math.max(0, 3 - quantidadeDeJogadoresNaCasa));
            // sempre 4 caracteres visíveis
        } else {

            conteudoDaCasa = String.format(" %-3s", siglaDaCasa);
            // sempre 4 caracteres visíveis
        }

        return fundoDaCasa + "[" + conteudoDaCasa + "]" + CODIGO_RESETAR_COR + " "; // 7 caracteres visíveis no total
    }// fim do formatar casa

    public static int colocarNoDesempate(int maiorSomaDosDados, int[] somaDadoJogadores,
            boolean[] jogadorEstaNoDesempate) {
        int quantidadeDeJogadoresNoDesempate = 0;

        for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) { // só coloca o jogador no
                                                                                        // desempate
            if (somaDadoJogadores[indiceDoJogador] == maiorSomaDosDados) {
                quantidadeDeJogadoresNoDesempate++;
                jogadorEstaNoDesempate[indiceDoJogador] = true;
            }

        }

        return quantidadeDeJogadoresNoDesempate;
    }

    public static int verificarEntradaValida(int[] opcoesValidas, int entrada) {
        boolean opcaoInvalida = true;
        while (opcaoInvalida) {
            for (int indiceDaOpcao = 0; indiceDaOpcao < opcoesValidas.length; indiceDaOpcao++) {
                if (entrada == opcoesValidas[indiceDaOpcao]) {
                    opcaoInvalida = false;
                    break;
                } else if (indiceDaOpcao == opcoesValidas.length - 1) {
                    System.out.println("Entrada inválida, tente novamente !!!");
                    entrada = ler.nextInt();
                }
            }
        }

        return entrada;
    }

    public static int[][] criarGruposPropriedadesJogador() {
        int[][] gruposPropriedadeJogador = new int[JOGADORES][GRUPOS];

        for (int i = 0; i < gruposPropriedadeJogador.length; i++) {

            for (int j = 0; j < gruposPropriedadeJogador[0].length; j++) {
                gruposPropriedadeJogador[i][j] = -1; // sem proprietario
            }
        }

        return gruposPropriedadeJogador;

    }

    public static int[] criarProprietariosDoGrupo(int nPropriedadesDoGrupo) {
        int[] grupo = new int[nPropriedadesDoGrupo];

        for (int i = 0; i < grupo.length; i++) {
            grupo[i] = -1; // sem proprietario
        }

        return grupo;
    }

    public static int[] propriedadesCompradasPorGrupo() {
        int[] propriedadesCompradasGrupo = new int[GRUPOS];

        for (int i = 0; i < propriedadesCompradasGrupo.length; i++) {
            propriedadesCompradasGrupo[i] = 0; // quantas já foram compradas daquele grupo (inicia com 0)
        }

        return propriedadesCompradasGrupo;
    }

    public static void verificarJogadorDonoGrupo(int[] proprietariosGrupo, int numeroGrupo, int jogadorDaVez,
            int[][] gruposJogadorEhDono) { // verifica se o jogador se tornou dono do grupo (possui todas as
                                           // propriedades dele)
        // guarda o proprietário da última propriedade, se ele for diferente do
        // proprietário da propriedade atual, ninguém é o dono do grupo (quebra o loop)
        int ultimoProprietario = 0; // inicializado com um valor qualquer só pro VS CODE aceitar ele no if

        for (int i = 0; i < proprietariosGrupo.length; i++) {
            if (proprietariosGrupo[i] == -1) {
                break;
            } else {
                if (i > 0) {
                    if (proprietariosGrupo[i] != ultimoProprietario) {
                        break;
                    } else if (i == proprietariosGrupo.length - 1) { // ultimo loop e não quebrou nenhuma vez
                        System.out.printf("PARABÉNS !!! O JOGADOR %d virou dono do GRUPO %d !!!\n", jogadorDaVez + 1,
                                numeroGrupo);

                        for (int j = 0; j < gruposJogadorEhDono[jogadorDaVez].length; j++) {
                            if (gruposJogadorEhDono[jogadorDaVez][j] == -1) {
                                gruposJogadorEhDono[jogadorDaVez][j] = numeroGrupo; // coloca o grupo na primeira
                                                                                    // posição livre
                                break;
                            }
                        }

                    }
                }

                ultimoProprietario = proprietariosGrupo[i];

            }
        }
    }

    public static int decidirJogadorQueComeca(int quantidadeDeJogadoresNoDesempate, boolean[] jogadorEstaNoDesempate,
            int[] somaDadoJogadores,
            int maiorSomaDosDados) {
        while (quantidadeDeJogadoresNoDesempate > 1) {
            System.out.println("\nDesempate:");
            maiorSomaDosDados = 0;
            quantidadeDeJogadoresNoDesempate = 0;
            for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) {
                if (jogadorEstaNoDesempate[indiceDoJogador]) {
                    System.out.printf("Jogador %d:\n", indiceDoJogador + 1);
                    valorDado1 = girarDado();
                    valorDado2 = girarDado();
                    somaDadoJogadores[indiceDoJogador] = valorDado1 + valorDado2;
                    DadoAnimado.animarDados(valorDado1, valorDado2);
                    System.out.printf("\n---------- RESULTADO FINAL: %d ---------\n",
                            somaDadoJogadores[indiceDoJogador]);

                    if (somaDadoJogadores[indiceDoJogador] > maiorSomaDosDados) {
                        maiorSomaDosDados = somaDadoJogadores[indiceDoJogador];
                    }
                }
            }

            for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) {
                if (jogadorEstaNoDesempate[indiceDoJogador]) {
                    if (somaDadoJogadores[indiceDoJogador] == maiorSomaDosDados) {
                        quantidadeDeJogadoresNoDesempate++;
                    } else {
                        jogadorEstaNoDesempate[indiceDoJogador] = false;
                    }
                }
            }
        }

        for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) {
            if (jogadorEstaNoDesempate[indiceDoJogador]) {
                return indiceDoJogador;
            }
        }

        return 0;
    }


    public static void pisarCasa(int[] posicaoDosJogadores, int[] dinheiroDosJogadores, int[] turnosRestantesNaCadeia,
            int[] somaDadoJogadores, int jogadorDaVez, TipoCasa[] casasDoTabuleiro, Propriedade[] propriedades,
            Companhia[] companhias, int[][] gruposJogadorEhDono) {
        TipoCasa casaPisadaPeloJogador = casasDoTabuleiro[posicaoDosJogadores[jogadorDaVez]];
        switch (casaPisadaPeloJogador.getTipoDaCasa()) {
            case 1: // propriedade
                Propriedade propriedadeDaCasa = propriedades[casaPisadaPeloJogador.getPosicaoCartaCasa()];
                if (propriedadeDaCasa.getProprietario() == -1) {
                    System.out.printf("Você quer comprar o(a) %s por R$%d.00\n", propriedadeDaCasa.getNome(),
                            propriedadeDaCasa.getPreco());
                    System.out.println("1 ---> Sim      2 ---> Não");
                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] { 1, 2 }, entrada);

                    if (entrada == 1) {
                        System.out.printf("O(a) %s agora é seu(sua) !!!\n", propriedadeDaCasa.getNome());
                        dinheiroDosJogadores[jogadorDaVez] -= propriedadeDaCasa.getPreco();
                        propriedadeDaCasa.setProprietario(jogadorDaVez);

                        switch (propriedadeDaCasa.getGrupo()) {
                            case 1:
                                //coloca na posição do vetor do grupo de acordo com quantas propriedades dele tem compradas (0, 1, 2) etc.
                                grupo1[propriedadesCompradasPorGrupo[0]] = jogadorDaVez;
                                verificarJogadorDonoGrupo(grupo1, 1, jogadorDaVez, gruposJogadorEhDono); //verifica se ele virou dono do grupo
                                propriedadesCompradasPorGrupo[0]++; // soma mais uma propriedade (mais uma daquele grupo foi comprada)
                                break;
                            case 2:
                                //coloca na posição do vetor do grupo de acordo com quantas propriedades dele tem compradas (0, 1, 2) etc.
                                grupo2[propriedadesCompradasPorGrupo[1]] = jogadorDaVez;
                                verificarJogadorDonoGrupo(grupo2, 2, jogadorDaVez, gruposJogadorEhDono); //verifica se ele virou dono do grupo
                                propriedadesCompradasPorGrupo[1]++; // soma mais uma propriedade (mais uma daquele grupo foi comprada)
                                break;
                            case 3:
                                //coloca na posição do vetor do grupo de acordo com quantas propriedades dele tem compradas (0, 1, 2) etc.
                                grupo3[propriedadesCompradasPorGrupo[2]] = jogadorDaVez;
                                verificarJogadorDonoGrupo(grupo3, 3, jogadorDaVez, gruposJogadorEhDono); //verifica se ele virou dono do grupo
                                propriedadesCompradasPorGrupo[2]++; // soma mais uma propriedade (mais uma daquele grupo foi comprada)
                                break;
                            case 4:
                                //coloca na posição do vetor do grupo de acordo com quantas propriedades dele tem compradas (0, 1, 2) etc.
                                grupo4[propriedadesCompradasPorGrupo[3]] = jogadorDaVez; 
                                verificarJogadorDonoGrupo(grupo4, 4, jogadorDaVez, gruposJogadorEhDono); //verifica se ele virou dono do grupo
                                propriedadesCompradasPorGrupo[3]++; // soma mais uma propriedade (mais uma daquele grupo foi comprada)
                                break;
                            case 5:
                                //coloca na posição do vetor do grupo de acordo com quantas propriedades dele tem compradas (0, 1, 2) etc.
                                grupo5[propriedadesCompradasPorGrupo[4]] = jogadorDaVez;
                                verificarJogadorDonoGrupo(grupo5, 5, jogadorDaVez, gruposJogadorEhDono); //verifica se ele virou dono do grupo
                                propriedadesCompradasPorGrupo[4]++; //soma mais uma propriedade (mais uma daquele grupo foi comprada)
                                break;
                            case 6:
                                //coloca na posição do vetor do grupo de acordo com quantas propriedades dele tem compradas (0, 1, 2) etc.
                                grupo6[propriedadesCompradasPorGrupo[5]] = jogadorDaVez; 
                                verificarJogadorDonoGrupo(grupo6, 6, jogadorDaVez, gruposJogadorEhDono); //verifica se ele virou dono do grupo
                                propriedadesCompradasPorGrupo[5]++; //soma mais uma propriedade (mais uma daquele grupo foi comprada)
                                break;
                            case 7:
                                //coloca na posição do vetor do grupo de acordo com quantas propriedades dele tem compradas (0, 1, 2) etc.
                                grupo7[propriedadesCompradasPorGrupo[6]] = jogadorDaVez;
                                verificarJogadorDonoGrupo(grupo7, 7, jogadorDaVez, gruposJogadorEhDono); //verifica se ele virou dono do grupo
                                propriedadesCompradasPorGrupo[6]++; //soma mais uma propriedade (mais uma daquele grupo foi comprada)
                                break;
                            }


                    }

                } else if (propriedadeDaCasa.getProprietario() != jogadorDaVez) {
                    System.out.printf("Você pisou na propriedade do jogador %d e teve que pagar R$%d.00\n", 
                        propriedadeDaCasa.getProprietario() + 1, propriedadeDaCasa.getAluguel());
                    dinheiroDosJogadores[jogadorDaVez] -= propriedadeDaCasa.getAluguel(); // jogador da vez paga
                    dinheiroDosJogadores[propriedadeDaCasa.getProprietario()] += propriedadeDaCasa.getAluguel(); //proprietário recebe
                }

                break;
            case 2: // companhia
                Companhia companhiaDaCasa = companhias[casaPisadaPeloJogador.getPosicaoCartaCasa()];

                if (companhiaDaCasa.getProprietario() == -1) {
                    System.out.printf("Você quer comprar o(a) %s como companhia por R$%d.00\n",
                            companhiaDaCasa.getNome(), companhiaDaCasa.getPreco());
                    System.out.println("1 ---> Sim      2 ---> Não");
                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] { 1, 2 }, entrada);

                    if (entrada == 1) {
                        System.out.printf("O(a) %s agora é seu(sua)\n", companhiaDaCasa.getNome());
                        dinheiroDosJogadores[jogadorDaVez] -= companhiaDaCasa.getPreco(); //paga (gasta) o preço da companhia
                        companhiaDaCasa.setProprietario(jogadorDaVez); //a companhia agora está sob a posse do jogador da vez
                    }

                } else if (companhiaDaCasa.getProprietario() != jogadorDaVez) {
                    //na companhia paga-se o valor da conta da companhia * o resultado dos dados
                    System.out.printf("Você pisou na companhia do jogador %d e teve que pagar R$%d.00\n",
                        companhiaDaCasa.getProprietario() + 1, companhiaDaCasa.getValorConta() * somaDadoJogadores[jogadorDaVez]);
                    dinheiroDosJogadores[jogadorDaVez] -= companhiaDaCasa.getValorConta() * somaDadoJogadores[jogadorDaVez]; //jogador da vez paga
                    dinheiroDosJogadores[companhiaDaCasa.getProprietario()] += (companhiaDaCasa.getValorConta() * somaDadoJogadores[jogadorDaVez]); //proprietário recebe
                }
                break;
            case 3: // sorte ou revés
                sorteOuReves(jogadorDaVez, turnosRestantesNaCadeia, dinheiroDosJogadores, posicaoDosJogadores);
                break;
            case 4: // casos a parte
                // a posição da carta diz qual caso a parte é (mesma ordem do
                // SIGLAS_CASAS_ESPECIAIS no formatarCasa)
                switch (casaPisadaPeloJogador.getPosicaoCartaCasa()) {
                    case 0: // cadeia (só visitando)
                        if(turnosRestantesNaCadeia[jogadorDaVez] == 0){ //não está preso
                            System.out.println("Você está apenas visitando a cadeia.");
                        }
                        break;
                    case 1: // imposto de renda
                        System.out.printf("Você caiu no Imposto de Renda e teve que pagar R$%d.00\n", IMPOSTO_DE_RENDA);
                        dinheiroDosJogadores[jogadorDaVez] -= IMPOSTO_DE_RENDA;

                        break;
                    case 2: // férias
                        System.out.println("Você está de férias, aproveite o descanso. Nada acontece.");

                        break;
                    case 3: // lucros e dividendos
                        System.out.printf("Você caiu em Lucros e Dividendos e recebeu R$%d.00\n", LUCROS_E_DIVIDENDOS);
                        dinheiroDosJogadores[jogadorDaVez] += LUCROS_E_DIVIDENDOS;

                        break;
                    case 4: // vá pra cadeia
                        System.out.println("Vá para a cadeia! Fique 3 turnos sem jogar !!!");
                        turnosRestantesNaCadeia[jogadorDaVez] = 3;
                        posicaoDosJogadores[jogadorDaVez] = POSICAO_CADEIA; // o jogador vai pra casa da cadeia

                        break;
                }

                break;

        }
    }

    public static void main(String[] args) {
        System.out.println("Com quantos jogadores quer jogar? Respostas de 2 a 4");
        entrada = ler.nextInt();
        entrada = verificarEntradaValida(new int[] { 2, 3, 4 }, entrada);
        JOGADORES = entrada;

        //variaveis do main relacionadas ao grupo da propriedade e construção de casa
        int[][] gruposJogadorEhDono = criarGruposPropriedadesJogador();
        int nGruposPosseJogadorDaVez = 0;
        int[] gruposPosseJogadorDaVez;
        int[] propriedadesDoGrupo = new int[6];

        int jogadorDaVez = 0;
        int[] somaDadoJogadores = new int[JOGADORES];
        int[] posicaoDosJogadores = new int[JOGADORES];
        int[] dinheiroDosJogadores = { 2558000, 2558000, 2558000, 2558000 };
        // cadeia
        int[] turnosRestantesNaCadeia = new int[JOGADORES];
        boolean jogadorJogaDeNovo = false;
        int vezesSeguidasComDadosIguais = 0;

        // variaveis usadas para decidir quem começa e desempatar
        int maiorSomaDosDados = 0;
        boolean[] jogadorEstaNoDesempate = new boolean[JOGADORES];
        int quantidadeDeJogadoresNoDesempate = 0;

        // variaveis relacionadas ao tabuleiro (cada número é a posição da casa, -1 é o
        // meio do tabuleiro, que fica vazio)
        int[][] desenhoDoTabuleiro = {
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

        TipoCasa[] casasDoTabuleiro = TipoCasa.criarTabuleiro();
        Propriedade[] propriedades = Propriedade.criarPropriedades();
        Companhia[] companhias = Companhia.criarCompanhias();

        for (int indiceDoJogador = 0; indiceDoJogador < JOGADORES; indiceDoJogador++) {
            System.out.printf("Jogador %d:\n", jogadorDaVez + 1);
            valorDado1 = girarDado();
            valorDado2 = girarDado();
            somaDadoJogadores[indiceDoJogador] = valorDado1 + valorDado2;
            System.out.println(valorDado1 + "\n" + valorDado2);

            if (somaDadoJogadores[indiceDoJogador] > maiorSomaDosDados) {
                maiorSomaDosDados = somaDadoJogadores[indiceDoJogador];
            }

            jogadorDaVez++;
        } // todos os jogadores jogam dois dados para decidir quem começa

        System.out.println();

        quantidadeDeJogadoresNoDesempate = colocarNoDesempate(maiorSomaDosDados, somaDadoJogadores,
                jogadorEstaNoDesempate);
        jogadorDaVez = decidirJogadorQueComeca(quantidadeDeJogadoresNoDesempate, jogadorEstaNoDesempate,
                somaDadoJogadores,
                maiorSomaDosDados);

        System.out.printf("\nJogador %d começa:\n\n", jogadorDaVez + 1);

        while (true) { // jogo

            System.out.printf("\nJogador %d: R$%d\n", jogadorDaVez + 1, dinheiroDosJogadores[jogadorDaVez]);

            if (turnosRestantesNaCadeia[jogadorDaVez] > 0) {
                System.out.printf("Você está na cadeia, espere mais %d turnos e seja livre !!!\n\n",
                turnosRestantesNaCadeia[jogadorDaVez]);
                turnosRestantesNaCadeia[jogadorDaVez]--;
                jogadorJogaDeNovo = false;
                // se for pra cadeia desativa o jogar de novo, pra não ter risco dele jogar de
                // novo, tirar dados iguais
                // acabar indo pra cadeia de outra forma (sorte ou reves, casa especial etc.) e
                // jogadorJogaDeNovoContinuar

            } else {
                valorDado1 = girarDado();
                valorDado2 = girarDado();
                somaDadoJogadores[jogadorDaVez] = valorDado1 + valorDado2;
                DadoAnimado.animarDados(valorDado1, valorDado2); // animação dado
                System.out.printf("\n---------- RESULTADO FINAL: %d ---------\n", somaDadoJogadores[jogadorDaVez]);

                posicaoDosJogadores[jogadorDaVez] += somaDadoJogadores[jogadorDaVez]; // soma a posição do jogador de
                                                                                      // acordo com o resultado dos
                                                                                      // dados

                if (posicaoDosJogadores[jogadorDaVez] >= CASAS_TABULEIRO) {
                    System.out.println("Você deu uma volta no tabuleiro, ganhando assim mais R$ 200.000");
                    posicaoDosJogadores[jogadorDaVez] %= CASAS_TABULEIRO;
                    dinheiroDosJogadores[jogadorDaVez] += 200000;
                }

                if (valorDado1 == valorDado2) {
                    vezesSeguidasComDadosIguais++;

                    if (vezesSeguidasComDadosIguais < 3) {
                        System.out.println("Você tirou dados iguais jogue novamente !!!");
                        jogadorJogaDeNovo = true;
                    } else {
                        System.out.println("Você foi pra cadeia, fique 3 turnos sem jogar !!!");
                        posicaoDosJogadores[jogadorDaVez] = POSICAO_CADEIA;
                        turnosRestantesNaCadeia[jogadorDaVez] = 3;
                        vezesSeguidasComDadosIguais = 0;
                        jogadorJogaDeNovo = false;
                    }
                } else {
                    jogadorJogaDeNovo = false;
                    vezesSeguidasComDadosIguais = 0;
                }

                // imprime tabuleiro
                for (int linha = 0; linha < desenhoDoTabuleiro.length; linha++) {

                    for (int coluna = 0; coluna < desenhoDoTabuleiro[0].length; coluna++) {

                        if (desenhoDoTabuleiro[linha][coluna] >= 0) {

                            System.out.print(formatarCasa(desenhoDoTabuleiro[linha][coluna], posicaoDosJogadores,
                                    casasDoTabuleiro, propriedades));

                        } else {

                            System.out.print("       ");
                        }
                    }

                    System.out.println("\n");
                }

                pisarCasa(posicaoDosJogadores, dinheiroDosJogadores, turnosRestantesNaCadeia, somaDadoJogadores,
                        jogadorDaVez, casasDoTabuleiro, propriedades, companhias, gruposJogadorEhDono);
                // o que acontece quando o jogador pisar na casa, antes de mudar o jogador da vez

                if (turnosRestantesNaCadeia[jogadorDaVez] > 0) { //para caso o jogador vá pra cadeia por outro meio
                    jogadorJogaDeNovo = false;                   //sorte ou revés, casa especial etc.
                    vezesSeguidasComDadosIguais = 0;
                }


                // opção de construir casas
                construirCasa: while (gruposJogadorEhDono[jogadorDaVez][0] != -1) {
                    System.out.println("Você quer construir casas em alguma das suas propriedades?");
                    System.out.println("1 ---> Sim      2 ---> Não");
                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] { 1, 2 }, entrada);

                    if(entrada == 2){
                        break;
                    }

                    
                    System.out.println("Você pode construir casa na(s) propriedade de grupo(s): ");
                    nGruposPosseJogadorDaVez = 0;
                    for (int j = 0; j < gruposJogadorEhDono[jogadorDaVez].length; j++) {
                            
                        if(gruposJogadorEhDono[jogadorDaVez][j] == -1){
                            break;
                        }
                                
                        nGruposPosseJogadorDaVez++;

                    }

                    gruposPosseJogadorDaVez = new int[nGruposPosseJogadorDaVez];
                        for (int j = 0; j < gruposJogadorEhDono[jogadorDaVez].length; j++) {
                            if(gruposJogadorEhDono[jogadorDaVez][j] == -1){
                                break;
                            }

                            gruposPosseJogadorDaVez[j] = gruposJogadorEhDono[jogadorDaVez][j];
                            System.out.print(gruposPosseJogadorDaVez[j] + "     ");

                        }

                        entrada = ler.nextInt();
                        entrada = verificarEntradaValida(gruposPosseJogadorDaVez, entrada);
                        contador = 0;

                        System.out.printf("Grupo %d:\n", entrada);
                        for (int j = 0; j < propriedades.length; j++) { //percorre todas as propriedades
                            if(propriedades[j].getGrupo() == entrada){
                                System.out.printf("%s - propriedade: %d\n", propriedades[j].getNome(), j); //imprime a propriedade e o número dela
                                propriedadesDoGrupo[contador] = j; //adiciona as propriedades do grupo
                                contador++; //manda pra próxima propriedade do grupo
                            }
                        }

                        for(int j = contador; j < propriedadesDoGrupo.length; j++){
                            //o vetor tem tamanho 6 (número de propriedades do maior grupo), se o grupo tem menos o que sobra vira -1
                            propriedadesDoGrupo[j] = -1;
                        }

                            entrada = ler.nextInt();
                            entrada = verificarEntradaValida(propriedadesDoGrupo, entrada);

                            while(entrada == -1){
                                System.out.println("Entrada inválida, tente novamente !!!");
                                System.out.println("Selecione uma propriedade do grupo");
                                System.out.println("100 ---> Parar construção");
                                entrada = ler.nextInt();

                                if(entrada == 100){
                                    break construirCasa;
                                }

                                entrada = verificarEntradaValida(propriedadesDoGrupo, entrada);
                            }

                            while(propriedades[entrada].getNumeroCasas() == 4){ 
                                System.out.println("Máximo de casas na propriedade atingido");
                                System.out.println("Selecione outra propriedade do grupo");
                                System.out.println("100 ---> Parar construção");
                                entrada = ler.nextInt();

                                if(entrada == 100){
                                    break construirCasa;
                                }

                                entrada = verificarEntradaValida(propriedadesDoGrupo, entrada);

                                while(entrada == -1){
                                    System.out.println("Entrada inválida, tente novamente !!!");
                                    System.out.println("Selecione outra propriedade do grupo");
                                    System.out.println("100 ---> Parar construção");
                                    entrada = ler.nextInt();

                                    if(entrada == 100){
                                        break construirCasa;
                                    }

                                    entrada = verificarEntradaValida(propriedadesDoGrupo, entrada);
                                }

                            }

                            propriedades[entrada].setNumeroCasas(propriedades[entrada].getNumeroCasas() + 1);
                            dinheiroDosJogadores[jogadorDaVez] -= propriedades[entrada].getPrecoCasaHotel();

                            if(propriedades[entrada].getNumeroCasas() <= 2){
                                System.out.println("Você construiu uma casa !!!");
                                propriedades[entrada].setAluguel(propriedades[entrada].getAluguel() * 3);
                            }else if(propriedades[entrada].getNumeroCasas() <= 3){
                                System.out.println("Você construiu uma casa !!!");
                                propriedades[entrada].setAluguel(propriedades[entrada].getAluguel() * 2);
                            }else{
                                System.out.println("Você construiu um hotel !!!");
                                propriedades[entrada].setAluguel((propriedades[entrada].getAluguel() * 3) / 2);
                            }

                            System.out.printf("O aluguel do(a) %s agora custa R$%d\n", propriedades[entrada].getNome(), propriedades[entrada].getAluguel());
                    
                }

                // digite 67 pra encerrar o jogo
                if (ler.nextInt() == 67) {
                    break;
                }
            }
            
            if (!jogadorJogaDeNovo) {
                jogadorDaVez = (jogadorDaVez + 1) % JOGADORES;
            }

        } // fim do while
    } //fim do main
} //fim da classe
