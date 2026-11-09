public class Propriedade {
    private String nome;
    private int proprietario;
    private int preco;  
    private int grupo;
    private int aluguel;
    private int precoCasaHotel;
    private int numeroCasas;
    private int valorHipoteca;

    //construtores
    public Propriedade(String nome, int preco, int grupo, int aluguel, int precoCasaHotel, int valorHipoteca){
        this.nome = nome;
        this.proprietario = 0; //cria a propriedade sem proprietario
        this.preco = preco;
        this.grupo = grupo; 
        this.aluguel = aluguel;
        this.precoCasaHotel = precoCasaHotel;
        this.numeroCasas = 0; //começa sem nenhuma casa (5 casas = hotel)
        this.valorHipoteca = valorHipoteca;
    }

    //grupo pode ser 1, 2, 3, 4, 5 ou 6 (conjunto de propriedades separados por cor)
    //1 -> verde 2 -> laranja 3 -> azul claro 4 -> rosa 5 -> roxo 6 -> azul escuro 7 -> amarelo

    public Propriedade(){
        
    }

    //getters 
    public String getNome(){
        return nome;
    }

    public int getProprietario(){
        return proprietario;
    }

    public int getPreco(){
        return preco;
    }

    public int getGrupo(){
        return grupo;
    }

    public int getAluguel(){
        return aluguel;
    }

    public int getPrecoCasaHotel(){
        return precoCasaHotel;
    }

    public int getNumeroCasas(){
        return numeroCasas;
    }

    public int getValorHipoteca(){
        return valorHipoteca;
    }

    //setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setProprietario(int proprietario){
        this.proprietario = proprietario;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    public void setPrecoCasaHotel(int precoCasaHotel) {
        this.precoCasaHotel = precoCasaHotel;
    }

    public void setNumeroCasas(int numeroCasas){
        this.numeroCasas = numeroCasas;
    }

    public void setValorHipoteca(int valorHipoteca){
        this.valorHipoteca = valorHipoteca;
    }

}
