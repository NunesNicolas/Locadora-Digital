package entidades;

public class Categoria extends Entidade {

    private char tipo;

    public Categoria(String nome, int id) {
        super(nome, id);
    }

    public Categoria() {
        super();
    }
   
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
   
    public char getTipo() {
        return tipo;
    }

    public String getNomeTipo() {
        return tipo == 'F' ? "Filme" : "Jogo"; // Condicional ternário
        /*
        if (tipo == 'F') {
            return "Filme";
        } else {
            return "Jogo";
        }        
        */
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Categoria other = (Categoria) obj;

        if (id != other.getId()) {
            return false;
        }

        return true;

    }

    @Override
    public String toString() {


        return "Categoria"
            +"\n" + " ID: " + id
            +"\n" + " Nome: " + nome
            +"\n" + " Tipo= " + tipo;     
    }
}

