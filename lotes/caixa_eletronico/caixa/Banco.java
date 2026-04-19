package caixa;

import java.math.BigDecimal;

public class Banco {
    private int codigo;
    private String nome;
    private int totalDeSaques = 0;
    private BigDecimal valorSacado = new BigDecimal("0.00");

    public Banco(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() { return codigo; }

    public String getNome() { return nome; }

    protected void adicionarAoTotalDeSaques() { totalDeSaques++; }

    protected void adicionarAoValorSacado(BigDecimal valorSacado){
        this.valorSacado = this.valorSacado.add(valorSacado);
    }
}
