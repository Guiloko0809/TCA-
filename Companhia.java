public class Companhia {
    private String nome;
    private int preco;
    private int proprietario;
    private int valorConta;

    //construtores
    public Companhia(String nome, int preco, int proprietario, int valorConta){
        this.nome = nome;
        this.preco = preco;
        this.proprietario = proprietario;
        this.valorConta = valorConta;
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

}
