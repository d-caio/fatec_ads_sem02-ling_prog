package caixa;

import java.math.BigDecimal;
import java.util.Random;

import exceptions.*;

public class Caixa {
    private BigDecimal valorDisponivel = new BigDecimal("0.00");
    private BigDecimal totalSacado = new BigDecimal("0.00");
    private BigDecimal valorDoUltimoSaque;
    private int numeroDeSaques = 0;

    private Nota[] notasDisponiveis = new Nota[] {
        new Nota(new BigDecimal("100.00"), 0),
        new Nota(new BigDecimal("50.00"), 0),
        new Nota(new BigDecimal("20.00"), 0),
        new Nota(new BigDecimal("10.00"), 0),
        new Nota(new BigDecimal("5.00"), 0),
        new Nota(new BigDecimal("2.00"), 0)
    };

    private Banco[] bancos = new Banco[] {
        new Banco(1, "Banco do Brasil"),
        new Banco(2, "Caixa Econômica Federal"),
        new Banco(3, "Bradesco"),
        new Banco(4, "Itaú")
    };

    private boolean caixaEstaCarregado = false;

    private final int minimoDeNotas = notasDisponiveis.length;
    private final int maximoDeNotas = 9995;

    public Banco[] getBancos() { return bancos; }

    public BigDecimal getValorDoUltimoSaque() { return valorDoUltimoSaque; }

    public String relatorioDeNotasDisponiveis() {
        var relatorioBuilder = new StringBuilder("Valor total disponível:")
            .append("\n")
            .append(valorDisponivel)
            .append("\n\n")
            .append("Notas disponíveis:");

        for (Nota nota:notasDisponiveis) {
            relatorioBuilder
                .append("\n")
                .append(nota.getValorDaNota())
                .append(" - ")
                .append(nota.getQuantidadeDeNotas());
        }

        String relatorio = relatorioBuilder.toString();

        return relatorio;
    }

    public void carregarNotas() {
        if (!caixaEstaCarregado) {
            var definirQuantidadeDeNotas = new Random();

            int quantidadeDeNotas = definirQuantidadeDeNotas
                .nextInt(maximoDeNotas) + minimoDeNotas;

            int quantidadeDeCadaNota = quantidadeDeNotas / minimoDeNotas;
            int notasRestantes = quantidadeDeNotas % minimoDeNotas;

            for (int i = notasDisponiveis.length - 1; i >= 0; i--) {
                int notaExtra = 0;

                if (notasRestantes > 0) {
                    notaExtra++;
                    notasRestantes--;
                }

                notasDisponiveis[i].adicionarNotas(quantidadeDeCadaNota + notaExtra);

                BigDecimal valorTotalPorNota = notasDisponiveis[i].getValorDaNota()
                    .multiply(BigDecimal.valueOf(notasDisponiveis[i].getQuantidadeDeNotas()));

                valorDisponivel = valorDisponivel
                    .add(valorTotalPorNota);
            }

            caixaEstaCarregado = true;
        }
    }

    public void sacar(BigDecimal valor, int codigoDoBanco) {
        if (!caixaEstaCarregado)
            throw new NotasNaoCarregadasException("As notas devem ser carregadas antes de ser possível sacar.");
        
        if (valor.compareTo(valorDisponivel) == 1)
            throw new ValorExcedidoException();

        boolean valorEhValido = notasDisponiveisPermitemSaqueDoValor(valor);

        if (!valorEhValido)
            throw new ValorExcedidoException("As notas disponíveis não permitem alcançar o valor solicitado.");

        BigDecimal saque = new BigDecimal("0.00");
        
        for (Nota nota:notasDisponiveis) {
            BigDecimal valorDaNota = nota.getValorDaNota();
            int quantidadeDeNotasRetiradas = 0;

            for (int i = 1; i <= nota.getQuantidadeDeNotas(); i++) {
                if (saque.add(valorDaNota).compareTo(valor) > 0)
                    break;

                saque = saque.add(valorDaNota);
                quantidadeDeNotasRetiradas++;
            }
            
            nota.subtrairNotas(quantidadeDeNotasRetiradas);
        }
        
        totalSacado = totalSacado.add(saque);
        valorDoUltimoSaque = saque;
        valorDisponivel = valorDisponivel.subtract(saque);

        for (Banco banco:bancos)
            if (banco.getCodigo() == codigoDoBanco) {
                banco.adicionarAoTotalDeSaques();
                banco.adicionarAoValorSacado(saque);
                break;
            }
    }

    private boolean notasDisponiveisPermitemSaqueDoValor(BigDecimal valor) {
        BigDecimal valorDeComparacao = new BigDecimal("0.00");

        for (Nota nota:notasDisponiveis) {
            BigDecimal valorDaNota = nota.getValorDaNota();
            int quantidadeDeNotas = nota.getQuantidadeDeNotas();

            for (int i = 1; i <= quantidadeDeNotas; i++) {
                if (valorDeComparacao.add(valorDaNota).compareTo(valor) > 0)
                    break;

                valorDeComparacao = valorDeComparacao.add(valorDaNota);
            }
        }

        return valorDeComparacao.compareTo(valor) == 0;
    }
}
