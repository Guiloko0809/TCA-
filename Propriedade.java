public class Propriedade {
    private String nome;
    private int proprietario;
    private int preco;  
    private int grupo;
    private int alugel;
    private int precoCasa;
    private int precoHotel;

    //construtores
    public Propriedade(String nome, int proprietario, int preco, int grupo, int alugel, int precoCasa, int precoHotel){
        this.nome = nome;
        this.proprietario = proprietario;
        this.preco = preco;
        this.grupo = grupo;
        this.alugel = alugel;
        this.precoCasa = precoCasa;
        this.precoHotel = precoHotel; 
    }

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

    public int getAlugel(){
        return alugel;
    }

    public int getPrecoCasa(){
        return precoCasa;
    }

    public int getPrecoHotel(){
        return precoHotel;
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

    public void setAlugel(int alugel) {
        this.alugel = alugel;
    }

    public void setPrecoCasa(int precoCasa) {
        this.precoCasa = precoCasa;
    }

    public void setPrecoHotel(int precoHotel) {
        this.precoHotel = precoHotel;
    }

}
