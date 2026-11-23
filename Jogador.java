public class Jogador {
    
    private int pontuacaoJogador;
    private int numeroJogador;

    //construtores
    public Jogador(int numeroJogador){
        this.numeroJogador = numeroJogador;
        this.pontuacaoJogador = 0;
    }

    public Jogador(){

    }

    //somador pontuação
    public int somarPontuacaoJogador(int pontuacaoAdicionada){
        return pontuacaoJogador + pontuacaoAdicionada;
    }

    //setters 
    public void setPontuacaoJogador(int pontuacaoJogador){
        this.pontuacaoJogador = pontuacaoJogador;
    }

    public void setNumeroJogador(int numeroJogador){
        this.numeroJogador = numeroJogador;
    }

    //getters
    public int getPontuacaoJogador(){
        return pontuacaoJogador;
    }

    public int getNumeroJogador(){
        return numeroJogador;
    }

}
