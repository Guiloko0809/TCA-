public class Companhia {
    private String nome;
    private int preco;
    private int proprietario;
    private int valorConta;
    private int valorHipoteca;

    //métodos
    public static Companhia[] criarCompanhias(){
        Companhia[] companhias = new Companhia[6];
        companhias[0] = new Companhia("Copel", 200000, 50000, 100000 );
        companhias[1] = new Companhia("Sanepar", 200000, 50000, 100000 );
        companhias[2] = new Companhia("Petrobras", 200000, 50000, 100000 );
        companhias[3] = new Companhia("Aeroporto Municipal de Cascavel", 200000, 50000, 100000 );
        companhias[4] = new Companhia("Banco do Brasil", 150000, 40000, 75000 );
        companhias[5] = new Companhia("Suap", 15000, 40000, 75000 );
        return companhias;
    }

    //construtores
    public Companhia(String nome, int preco, int valorConta, int valorHipoteca){
        this.nome = nome;
        this.preco = preco;
        this.proprietario = 0; //cria sem proprietário
        this.valorConta = valorConta;
        this.valorHipoteca = valorHipoteca;
    }

    public Companhia(){

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
    
    public int getValorConta(){
        return valorConta;
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

    public void setValorConta(int valorConta){
        this.valorConta = valorConta;
    }

    public void setValorHipoteca(int valorHipoteca){
        this.valorHipoteca = valorHipoteca;
    }

}
