package entidades;

public class Jogo extends Item {
    private String plataforma;
    private int duracao;
    private int memoria;

    /*Getters */
    public Jogo(int id, String titulo, String descricao, int numdias, double preco, String plataforma, int duracao, int memoria){
        super(id, titulo, descricao, numdias, preco);
        
        this.plataforma = plataforma;
        this.duracao = duracao;
        this.memoria = memoria;
    }
    
    public Jogo(int id, String titulo, Categoria categoria) {
        super(id, titulo, categoria);
    }

    public Jogo(Categoria categoria){
        super(categoria);
    }
    public Jogo(){
        super();
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getMemoria() {
        return memoria;
    }

    /*Setters */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public String toString() {


        return "Categoria"
            +"\n" + " ID: " + id
            +"\n" + " Titulo: " + titulo
            +"\n" + " Preco= " + preco
                +"\n" + " Descricao: " + descricao
                +"\n" + " NumeroDias: " + numdias
                +"\n" + " Plataforma: " + plataforma
                +"\n" + " Espaço de memoria: " + memoria + " GB"
                +"\n" + " Duracao: " + duracao;     
        }

}
