package Model;

public class Genero {

    private int idDoGenero;
    private String NomeDoGenero;

    public int getIdDoGenero() {
        return idDoGenero;
    }

    public void setIdDoGenero(int idDoGenero) {
        this.idDoGenero = idDoGenero;
    }

    public String getNomeDoGenero() {
        return NomeDoGenero;
    }

    public void setNomeDoGenero(String nomeDoGenero) {
        NomeDoGenero = nomeDoGenero;
    }

    public Genero(int idDoGenero, String nomeDoGenero) {
        this.idDoGenero = idDoGenero;
        NomeDoGenero = nomeDoGenero;
    }

    public Genero(String nomeDoGenero) {
        NomeDoGenero = nomeDoGenero;
    }

    public Genero() {
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idDoGenero=" + idDoGenero +
                ", NomeDoGenero='" + NomeDoGenero + '\'' +
                '}';
    }
}
