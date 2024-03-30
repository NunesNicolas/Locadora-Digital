package entidades;

public class Item {

    int id;
    String titulo;
    String descricao;
    int numdias;
    double preco;

    private Categoria categoria;

    public Item(int id, String titulo, Categoria categoria) {
        this.categoria = categoria;
        this.id = id;
        this.titulo = titulo;
    }

    public Item(Categoria categoria){
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getNumdias() {
        return numdias;
    }
    public void setNumdias(int numdias) {
        this.numdias = numdias;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
