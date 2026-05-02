package estatistica;

public class Cidade {
    private int codigo;
    private String nome;
    private int numeroDeAcidentes;

    public Cidade() {
        this(0, "", 0);
    }
    
    public Cidade(int codigo, String nome, int numeroDeAcidentes) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroDeAcidentes = numeroDeAcidentes;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNumeroDeAcidentes() {
        return numeroDeAcidentes;
    }    
}
