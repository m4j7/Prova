package Model;

public class Livro {

    private int IdDoLivro;
    private Genero generoDoLivro;
    private Biblioteca bibliotecaDoLivro;
    private String NomeDoLivro;

    public int getIdDoLivro() {
        return IdDoLivro;
    }

    public void setIdDoLivro(int idDoLivro) {
        IdDoLivro = idDoLivro;
    }

    public Genero getGeneroDoLivro() {
        return generoDoLivro;
    }

    public void setGeneroDoLivro(Genero generoDoLivro) {
        this.generoDoLivro = generoDoLivro;
    }

    public Biblioteca getBibliotecaDoLivro() {
        return bibliotecaDoLivro;
    }

    public void setBibliotecaDoLivro(Biblioteca bibliotecaDoLivro) {
        this.bibliotecaDoLivro = bibliotecaDoLivro;
    }

    public String getNomeDoLivro() {
        return NomeDoLivro;
    }

    public void setNomeDoLivro(String nomeDoLivro) {
        NomeDoLivro = nomeDoLivro;
    }

    public Livro(Genero generoDoLivro, Biblioteca bibliotecaDoLivro, String nomeDoLivro) {
        this.generoDoLivro = generoDoLivro;
        this.bibliotecaDoLivro = bibliotecaDoLivro;
        NomeDoLivro = nomeDoLivro;
    }

    public Livro() {
    }


    @Override
    public String toString() {
        return "Livro{" +
                "IdDoGenero=" + IdDoLivro +
                ", generoDoLivro=" + generoDoLivro +
                ", bibliotecaDoLivro=" + bibliotecaDoLivro +
                ", NomeDoLivro='" + NomeDoLivro + '\'' +
                '}';
    }
}
