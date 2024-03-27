package entidades;

public class Entidade {

        protected int id;
        protected String nome;

        public Entidade(String nome, int id) {
            this.nome = nome;
            this.id = id;
        }

        public Entidade(){

        }
    
        public void setId(int id) {
            this.id = id;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        
        public int getId() {
            return id;
        }
        public String getNome() {
            return nome;
        }
}
