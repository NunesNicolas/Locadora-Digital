package entidades;

public class Jogo extends Item {
    private String plataforma;
    private int duracao;

    public Jogo(int id, String titulo, Categoria categoria) {
        super(id, titulo, categoria);
    }

    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
