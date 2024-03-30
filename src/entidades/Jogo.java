package entidades;

public class Jogo extends Item {
    private String plataforma;
    private int duracao;
    private int memoria;

    /*Getters */
    public Jogo(int id, String titulo, Categoria categoria) {
        super(id, titulo, categoria);
    }

    public Jogo(Categoria categoria){
        super(categoria);
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

}
