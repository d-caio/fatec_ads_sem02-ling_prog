package menus;

public class Opcao {
    private int codigo;
    private String nome;

    public Opcao(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() { return this.codigo; }

    public String getNome() { return this.nome; }
}
