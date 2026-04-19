package caixa;

import java.math.BigDecimal;

class Nota {
    private BigDecimal valorDaNota;
    private int quantidadeDeNotas;

    protected Nota(BigDecimal valorDaNota, int quantidadeDeNotas) {
        this.valorDaNota = valorDaNota;
        this.quantidadeDeNotas = quantidadeDeNotas;
    }

    protected BigDecimal getValorDaNota() { return valorDaNota; }

    protected int getQuantidadeDeNotas() { return quantidadeDeNotas; }

    protected void adicionarNotas(int quantidadeDeNotasASeremIncluidas) {
        quantidadeDeNotas += quantidadeDeNotasASeremIncluidas;
    }

    protected void subtrairNotas(int quantidadeDeNotasASeremIncluidas) {
        quantidadeDeNotas -= quantidadeDeNotasASeremIncluidas;
    }
}
