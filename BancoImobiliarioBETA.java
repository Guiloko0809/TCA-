import java.util.Random;
import java.util.Scanner;

public class BancoImobiliarioBETA { //digite (chcp 65001) no terminal pra liberar os caracteres (windows apenas)

    // CONSTANTES
    public static final int JOGADORES = 4;
    public static final int CASAS_TABULEIRO = 40;

    // dados
    static Random dice = new Random();
    static int dado1;
    static int dado2;

    //entradas
    static int entrada ; 

    final static Scanner ler = new Scanner(System.in);

    public static int girarDado() {
        return dice.nextInt(6) + 1;
    } // gira um dado de [1, 6]

    public static int sortearSorteOuReves() {
        return dice.nextInt(20);
    } // método para sortear um número de 0 a 19, cujo é utilizado no método sorteOuReves()

    public static void sorteOuReves(int jogadorDaVez, int[] turnosCadeia, int[] dinheiroJogador){


        //Casos 0 ao 7: O jogador ganha dinheiro
        //Casos 8 ao 15: O jogador perde dinheiro
        // Casos 16 e 17: Um jogador ganha, outro jogador perde
        // Caso 18: O jogador vai para cadeia
        // Caso 19: O jogador manda outro para cadeiaa


        int resultadoSorteOuReves = sortearSorteOuReves();


        switch (resultadoSorteOuReves) {

            case 0:
                System.out.println("Você acabou de ganhar na Lotofácil!");
                System.out.println("Você ganhou R$100.000!");
                dinheiroJogador[jogadorDaVez] += 100000;
    
                break;

            case 1:
                System.out.println("Você trabalhou por 30 dias! Quanto esforço!");
                System.out.println("Você ganohu R$ 1.741,00!");
                dinheiroJogador[jogadorDaVez] += 1741;

                break;

            case 2:
                System.out.println("Seu pai era dono do jogo do bicho e faleceu, você tomou conta dos negócios.");
                System.out.println("Você ganhou R$270.000!");
                dinheiroJogador[jogadorDaVez] += 270000;

                break;

            case 3:
                System.out.println("Você ganhou um processo na justiça!");
                System.out.println("Você ganhou R$50.000!");
                dinheiroJogador[jogadorDaVez] += 50000;

                break;

            case 4:
                System.out.println("Você fechou um contrato importante, e acabou saindo na frente!");
                System.out.println("Você ganhou R$55.000!");
                dinheiroJogador[jogadorDaVez] += 55000;

                break;

            case 5:
                System.out.println("Você arrematou um carro exótico no leilão, supostamente usado pelo Ayrton Senna. Você reforma o carro e vende por um preço absurdo!");
                System.out.println("Você ganhou R$70.000!");
                dinheiroJogador[jogadorDaVez] += 70000;
                
                break;

            case 6:
                System.out.println("Tigrinho soltou a carta, e você ganha o jackpot!");
                System.out.println("Você ganhou R$80.000!");
                dinheiroJogador[jogadorDaVez] += 80000;

                break;

            case 7:
                System.out.println("Você ganhou o campeonato de farmar aura! Moggou todos os betinhas.");
                System.out.println("Você ganhou R$67.667! Quanta aura!");
                dinheiroJogador[jogadorDaVez] += 67667;

                break;

            case 8:
                System.out.println("Você aposta no tigrinho, e ele não soltou a carta.");
                System.out.println("Você perdeu R$90.000.");
                dinheiroJogador[jogadorDaVez] -= 90000;

                break;

            case 9:
                System.out.println("Em um dia chuvoso, seu carro de luxo acaba derrapando a traseira e bate na barreira da rodovia.");
                System.out.println("Você perdeu R$120.000.");
                dinheiroJogador[jogadorDaVez] -= 120000;
                
                break;

            case 10:
                System.out.println("Você atropela uma idosa rica e ela acaba te processando. Você perde o processo.");
                System.out.println("Você perdeu R$60.000.");
                dinheiroJogador[jogadorDaVez] -= 60000;

                break;

            case 11:
                System.out.println("Você perde o campeonato de farmar aura. Para ninguém saber a vergonha que passou, você paga quem fez seus vídeos para eles não postar.");
                System.out.println("Você perdeu R$67.667.");
                dinheiroJogador[jogadorDaVez] -= 67667;

                break;

            case 12:
                System.out.println("Um tsunami surpresa na praia da Barra(RJ) acaba destruindo sua casa de férias.");
                System.out.println("Você perdeu R$110.000.");
                dinheiroJogador[jogadorDaVez] -= 110000;
                
                break;

            case 13:
                System.out.println("No trajeto de volta para sua casa, você é encurralado por dois caras em uma moto e acaba sendo asaltado.");
                System.out.println("Você perdeu R$50.000.");    
            dinheiroJogador[jogadorDaVez] -= 50000;

                break;

            case 14:
                System.out.println("No meio do campeonato, você acaba quebrando seu braço e teve que pagar uma cirurgia.");
                System.out.println("Você perdeu R$20.000.");
                dinheiroJogador[jogadorDaVez] -= 20000;
                
                break;

            case 15:
                System.out.println("Você cai em um golpe na internet, e acaba comprando 10.000 Benjamins.");
                System.out.println("Você perdeu R$60.000.");
                dinheiroJogador[jogadorDaVez] -= 60000;    

                break;

            case 16:
                
                System.out.println("Você planeja um assalto à propriedade de um rival!");
                System.out.println("Quem você quer assaltar?");
                entrada = ler.nextInt();
                entrada = verificarEntradaValida(new int[] {1, 2, 3, 4}, entrada);

                while (entrada - 1 == jogadorDaVez) {
                    System.out.println("Entrada inválida, você não pode assaltar você mesmo!");
                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] {1, 2, 3, 4}, entrada);
                }


                System.out.printf("Você invadiu a propriedade do Jogador %d e roubou R$60.000!\n", entrada);
                dinheiroJogador[entrada - 1] -= 60000;
                dinheiroJogador[jogadorDaVez] += 60000;
                
                break;

            case 17:
                System.out.println("Você hackeou o Pix de alguém e fez uma transferência misteriosa!");
                System.out.println("Quem você quer hackear?");
                entrada = ler.nextInt();
                entrada = verificarEntradaValida(new int[] {1, 2, 3, 4}, entrada);


                while (entrada - 1 == jogadorDaVez) {
                    System.out.println("Entrada inválida, você não pode hackear você mesmo!");
                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] {1, 2, 3, 4}, entrada);
                }


                System.out.printf("Você tirou R$45.000 da conta do Jogador %d!\n", entrada);
                dinheiroJogador[entrada - 1] -= 45000;
                dinheiroJogador[jogadorDaVez] += 45000;
                
                break;

            case 18:
                System.out.println("Você foi pego sonegando impostos e a policia federal bateu na sua porta..");
                System.out.println("Você foi para cadeia, fique 3 turnos sem jogar!");  
                turnosCadeia[jogadorDaVez] = 3;

                break;

            case 19:
                System.out.println("Você deu propina para um policial federal e mandou ele prender alguem!");
                System.out.println("Quem você quer mandar para a cadeia?");
                
                entrada= ler.nextInt();
                entrada =  verificarEntradaValida(new int[] {1, 2, 3, 4}, entrada);


                while (entrada - 1 == jogadorDaVez) {
                    System.out.println("Entrada inválida, você não pode mandar você mesmo para a cadeia!");         
                    entrada= ler.nextInt();
                    entrada = verificarEntradaValida(new int[] {1, 2, 3, 4}, entrada);
                }


                System.out.printf("O Jogador %d foi preso, ficará 3 turnos sem jogar !!!\n", entrada);
                turnosCadeia[entrada - 1] = 3;

                break;

        }


        
    }


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
        final String[] CASOS_A_PARTE = { "", "CA", "IR", "FE", "LD", "VC" };

        TipoCasa casa = tipoCasasTabuleiro[numeroCasa];
        String fundo = RESET; // casa sem cor fica igual
        String letra = "I"; // a casa 0 é o início
        int grupo = 0;

        if (casa.getTipoDaCasa() == 1) {

            letra = "PR";
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
    }//fim do formatar casa

    public static int verificarEntradaValida(int[] entradasValidas, int entradaJogador){
        boolean entradaInvalida = true;
        while(entradaInvalida){
            for(int i = 0; i < entradasValidas.length; i++){
                if(entradaJogador == entradasValidas[i]){
                    entradaInvalida = false;
                    break;
                }else if(i == entradasValidas.length - 1){
                    System.out.println("Entrada inválida, tente novamente !!!");
                    entradaJogador = ler.nextInt();
                }
            }
        }

        return entradaJogador;
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

    public static void pisarCasa(int[] posicaoJogador, int[] dinheiroJogador, int[] turnosCadeia, int jogadorDaVez, TipoCasa[] casasTabuleiro, Propriedade[] propriedades, Companhia[] companhias){
        TipoCasa casaPisadaPeloJogador = casasTabuleiro[posicaoJogador[jogadorDaVez]];
        switch(casaPisadaPeloJogador.getTipoDaCasa()){
            case 1: //propriedade
                Propriedade propriedadeCasa = propriedades[casaPisadaPeloJogador.getPosicaoCartaCasa()];
                if(propriedadeCasa.getProprietario() == -1){
                    System.out.printf("Você quer comprar o(a) %s por R$%d.00\n", propriedadeCasa.getNome(), propriedadeCasa.getPreco());
                    System.out.println("1 ---> Sim      2 ---> Não");
                    entrada = ler.nextInt();
                    entrada = verificarEntradaValida(new int[] {1,2}, entrada);

                    if(entrada == 1){
                        System.out.printf("O(a) %s agora é seu(sua) !!!\n", propriedadeCasa.getNome());
                        dinheiroJogador[jogadorDaVez] -= propriedadeCasa.getPreco();
                        propriedadeCasa.setProprietario(jogadorDaVez);

                        System.out.println(propriedades[casaPisadaPeloJogador.getPosicaoCartaCasa()].getProprietario());
                    }

                }else if(propriedadeCasa.getProprietario() != jogadorDaVez){
                    if(dinheiroJogador[jogadorDaVez] >= propriedadeCasa.getAluguel()){
                        System.out.printf("Você pisou na propriedade do jogador %d e teve que pagar R$%d.00\n", propriedadeCasa.getProprietario(), propriedadeCasa.getAluguel());
                        dinheiroJogador[jogadorDaVez] -= propriedadeCasa.getAluguel(); //jogador da vez paga
                        dinheiroJogador[propriedadeCasa.getProprietario()] += propriedadeCasa.getAluguel(); //proprietario recebe
                    }else{
                        //o cara vai ter que vender as propriedades que tem, ainda não decidimos como vamos fazer isso
                    }
                }

                break;
            case 2: //companhia

                break;
            case 3: //sorte ou revés
                sorteOuReves(jogadorDaVez, turnosCadeia, dinheiroJogador);
                break;
            case 4: //casos a parte

                break;
            
        }
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

        while (true) { //jogo

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

                posicaoJogador[jogadorDaVez] += somaDadosJogador[jogadorDaVez]; //soma a posição do jogador de acordo com o resultado dos dados
                
                if(posicaoJogador[jogadorDaVez] >= CASAS_TABULEIRO){
                    System.out.println("Você deu uma volta no tabuleiro, ganhando assim mais R$ 200.000");
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

                pisarCasa(posicaoJogador, dinheiroJogador, turnosCadeia, jogadorDaVez, tipoCasasTabuleiro, propriedades, companhias);
                //o que acontece quando o jogador pisar na casa, antes de mudar o jogador da vez

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