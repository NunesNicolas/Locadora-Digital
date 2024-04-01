package entidades;
import java.util.Date;
import java.util.ArrayList;

public class Locacao {
    private int id;
    private double valor;
    private Date data;
    // private ArrayList<ItemLocacao> itensLocacao;
    private Usuario usuario; 
    private ArrayList<ItemLocacao> itensLocacao = new ArrayList<>();
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public ArrayList<ItemLocacao> getItensLocacao() {
        return itensLocacao;
    }
    public void setItensLocacao(ItemLocacao itemlocacao) {
        this.itensLocacao.add(itemlocacao);
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public String toString() {
        return "Jogo"
            +"\n" + " ID: " + id
            +"\n" + " Valor do carrinho: R$" + valor
            +"\n" + "Data" + data
            +"\n" + " itens alugados: " + itensLocacao;
        }
}
