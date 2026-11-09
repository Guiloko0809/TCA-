public class TipoCasa {
    private int tipoDaCasa; // 1 = propriedade 2 = companhia 3 = sorteReves 4 = caso a parte
    private int posicaoCartaCasa;

    //métodos
    public static TipoCasa[] criarTabuleiro(){ //método para criar todas as casas do tabuleiro
        TipoCasa[] tipoCasasTabuleiro = new TipoCasa[40];
        tipoCasasTabuleiro[0] = new TipoCasa(0, 0); //0 0 porque mão importa
        tipoCasasTabuleiro[1] = new TipoCasa(1, 0);
        tipoCasasTabuleiro[2] = new TipoCasa(1, 1);
        tipoCasasTabuleiro[3] = new TipoCasa(2, 0);
        tipoCasasTabuleiro[4] = new TipoCasa(1, 2);
        tipoCasasTabuleiro[5] = new TipoCasa(1, 3);
        tipoCasasTabuleiro[6] = new TipoCasa(3, 0);
        tipoCasasTabuleiro[7] = new TipoCasa(1, 4);
        tipoCasasTabuleiro[8] = new TipoCasa(2, 1);
        tipoCasasTabuleiro[9] = new TipoCasa(1, 5);
        tipoCasasTabuleiro[10] = new TipoCasa(4, 1);
        tipoCasasTabuleiro[11] = new TipoCasa(3, 0);
        tipoCasasTabuleiro[12] = new TipoCasa(1, 6);
        tipoCasasTabuleiro[13] = new TipoCasa(1, 7);
        tipoCasasTabuleiro[14] = new TipoCasa(2, 2);
        tipoCasasTabuleiro[15] = new TipoCasa(1, 8);
        tipoCasasTabuleiro[16] = new TipoCasa(4, 2);
        tipoCasasTabuleiro[17] = new TipoCasa(1, 9);
        tipoCasasTabuleiro[18] = new TipoCasa(1, 10);
        tipoCasasTabuleiro[19] = new TipoCasa(1, 11);
        tipoCasasTabuleiro[20] = new TipoCasa(4, 3);
        tipoCasasTabuleiro[21] = new TipoCasa(1, 12);
        tipoCasasTabuleiro[22] = new TipoCasa(2, 3);
        tipoCasasTabuleiro[23] = new TipoCasa(4, 4);
        tipoCasasTabuleiro[24] = new TipoCasa(3, 0);
        tipoCasasTabuleiro[25] = new TipoCasa(1, 13);
        tipoCasasTabuleiro[26] = new TipoCasa(1, 14);
        tipoCasasTabuleiro[27] = new TipoCasa(3, 0);
        tipoCasasTabuleiro[28] = new TipoCasa(1, 15);
        tipoCasasTabuleiro[29] = new TipoCasa(2, 4);
        tipoCasasTabuleiro[30] = new TipoCasa(4, 5);
        tipoCasasTabuleiro[31] = new TipoCasa(1, 16);
        tipoCasasTabuleiro[32] = new TipoCasa(3, 0);
        tipoCasasTabuleiro[33] = new TipoCasa(1, 17);
        tipoCasasTabuleiro[34] = new TipoCasa(1, 18);
        tipoCasasTabuleiro[35] = new TipoCasa(1, 19);
        tipoCasasTabuleiro[36] = new TipoCasa(2, 5);
        tipoCasasTabuleiro[37] = new TipoCasa(1, 20);
        tipoCasasTabuleiro[38] = new TipoCasa(3, 0);
        tipoCasasTabuleiro[39] = new TipoCasa(1, 21);

        return tipoCasasTabuleiro;
    }

    public TipoCasa(int tipoDaCasa, int posicaoCartaCasa){
        this.tipoDaCasa = tipoDaCasa;
        this.posicaoCartaCasa = posicaoCartaCasa;
    }
    
    public TipoCasa(){

    }
    
    //getters
    public int getTipoDaCasa(){
        return tipoDaCasa;
    }

    public int getPosicaoCartaCasa(){
        return posicaoCartaCasa;
    }

    //setters
    public void setTipoDaCasa(int tipoDaCasa){
        this.tipoDaCasa = tipoDaCasa;
    }

    public void setPosicaoCartaCasa(int posicaoCartaCasa){
        this.posicaoCartaCasa = posicaoCartaCasa;
    }
}
