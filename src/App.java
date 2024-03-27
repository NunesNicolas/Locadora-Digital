import data.CategoriaDAO;
import entidades.Categoria;

public class App {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setNome("Batman Arkam");
        categoria.setTipo('J'); // F - Filme J - Jogo
        
        //CategoriaDAO.criar(categoria);
        //categoria.setId(2);
        //System.out.println(CategoriaDAO.atualizar(categoria));
        System.out.println(CategoriaDAO.excluir(1));
        System.out.println(CategoriaDAO.listar());
    }
}
