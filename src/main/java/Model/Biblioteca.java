package Model;

public class Biblioteca {

    private int IdDaBiblioteca;
    private String NomeDaBiblioteca;

    public int getIdDaBiblioteca() {
        return IdDaBiblioteca;
    }

    public void setIdDaBiblioteca(int idDaBiblioteca) {
        IdDaBiblioteca = idDaBiblioteca;
    }

    public String getNomeDaBiblioteca() {
        return NomeDaBiblioteca;
    }

    public void setNomeDaBiblioteca(String nomeDaBiblioteca) {
        NomeDaBiblioteca = nomeDaBiblioteca;
    }

    public Biblioteca(String nomeDaBiblioteca) {
        NomeDaBiblioteca = nomeDaBiblioteca;
    }

    public Biblioteca() {
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "IdDaBiblioteca=" + IdDaBiblioteca +
                ", NomeDaBiblioteca='" + NomeDaBiblioteca + '\'' +
                '}';
    }
}
