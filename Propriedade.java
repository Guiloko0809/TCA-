public class Propriedade {
    private String nome;
    private int proprietario;
    private int preco;  
    private int grupo;
    private int aluguel;
    private int precoCasaHotel;
    private int numeroCasas;
    private int valorHipoteca;

    //métodos
    public static Propriedade[] criarPropriedades(){ //método para criar todas as propriedades
        Propriedade[] propriedades = new Propriedade[22];
        propriedades[0] = new Propriedade("Avenida Brasil", 100000, 1, 6000, 50000);
        propriedades[1] = new Propriedade("Avenida Rocha Pombo", 75000, 1, 2000, 50000);
        propriedades[2] = new Propriedade("Praça do Imigrante", 60000, 1, 4000, 50000);
        propriedades[3] = new Propriedade("Avenida Tancredo Neves", 240000, 2, 20000, 150000);
        propriedades[4] = new Propriedade("Praça Getúlio Vargas", 220000, 2, 18000, 150000);
        propriedades[5] = new Propriedade("Rua São Paulo", 220000, 2, 16000, 150000);
        propriedades[6] = new Propriedade("Ecopark Morumbi", 200000, 3, 16000, 100000);
        propriedades[7] = new Propriedade("Don Riter", 180000, 3, 14000, 100000);
        propriedades[8] = new Propriedade("Irani Floresta", 180000, 3, 14000, 100000);
        propriedades[9] = new Propriedade("Panorâmica", 400000, 4, 35000, 200000);
        propriedades[10] = new Propriedade("Catedral Nossa Senhora Aparecida", 350000, 4, 50000, 200000);
        propriedades[11] = new Propriedade("Avenida Carlos Gomes", 120000, 5, 6000, 50000);
        propriedades[12] = new Propriedade("Shopping Catuai", 100000, 5, 8000, 50000);
        propriedades[13] = new Propriedade("Avenida Assunção", 140000, 6, 8000, 50000);
        propriedades[14] = new Propriedade("Avenida Sabiá, 610 ", 160000, 6, 10000, 100000);
        propriedades[15] = new Propriedade("UPA Veneza", 140000, 6, 10000, 100000);
        propriedades[16] = new Propriedade("Avenida Tito Muffato", 320000, 2, 28000, 200000);
        propriedades[17] = new Propriedade("Eleodoro", 300000, 2, 26000, 200000);
        propriedades[18] = new Propriedade("Galego's", 300000, 2, 26000, 200000);
        propriedades[19] = new Propriedade("Rua Paraná", 280000, 7, 26000, 150000);
        propriedades[20] = new Propriedade("Rua Maranhão", 260000, 7, 22000, 150000);
        propriedades[21] = new Propriedade("Rua Laranja, 130", 260000, 7, 22000, 150000);
        return propriedades;
    }

    //construtores
    public Propriedade(String nome, int preco, int grupo, int aluguel, int precoCasaHotel){
        this.nome = nome;
        this.proprietario = -1; //cria a propriedade sem proprietario
        this.preco = preco;
        this.grupo = grupo; 
        this.aluguel = aluguel;
        this.precoCasaHotel = precoCasaHotel;
        this.numeroCasas = 0; //começa sem nenhuma casa (4 casas = hotel)
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
}
