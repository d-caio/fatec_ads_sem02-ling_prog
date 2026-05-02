package metodos;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

import estatistica.Cidade;

public class Metodos {
    public static Cidade[] cadastrarCidades(int numeroDeCidades) {
        var cidades = new Cidade[numeroDeCidades];

        String entradaNome;
        String entradaNumeroDeAcidentes;

        for (int i = 0; i < numeroDeCidades; i++) {
            int codigo = i + 1;

            entradaNome = JOptionPane.showInputDialog("Digite o nome da cidade " + codigo + ":");

            if (entradaNome == null || entradaNome.trim().isEmpty())
                throw new IllegalArgumentException("O nome da cidade não pode ser vazio.");

            entradaNumeroDeAcidentes = JOptionPane
                    .showInputDialog("Digite o número de acidentes da cidade " + codigo + ":");

            int numeroDeAcidentes;

            if (entradaNumeroDeAcidentes == null || entradaNumeroDeAcidentes.trim().isEmpty())
                numeroDeAcidentes = 0;

            else
                numeroDeAcidentes = Integer.parseInt(entradaNumeroDeAcidentes);

            cidades[i] = new Cidade(codigo, entradaNome, numeroDeAcidentes);
        }

        return cidades;
    }

    public static void cidadesEntre101e499(Cidade[] cidades) {
        String resultado = Arrays
                .stream(cidades)
                .filter(cidade -> cidade.getNumeroDeAcidentes() > 100 && cidade.getNumeroDeAcidentes() < 500)
                .map(cidade -> cidade.getNome() + " - " + cidade.getNumeroDeAcidentes() + " acidentes")
                .reduce((a, b) -> a + "\n" + b)
                .orElse("Nenhuma cidade encontrada.");

        JOptionPane.showMessageDialog(
                null,
                resultado,
                "Cidades com número de acidentes entre 101 e 499",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cidadesMaiorEMenor(Cidade[] cidades) {
        Cidade cidadeMaior = Arrays
                .stream(cidades)
                .max(Comparator.comparingInt(Cidade::getNumeroDeAcidentes))
                .orElse(null);

        Cidade cidadeMenor = Arrays
                .stream(cidades)
                .min(Comparator.comparingInt(Cidade::getNumeroDeAcidentes))
                .orElse(null);

        String resultado = "Cidade com maior número de acidentes:\n" +
                (cidadeMaior != null ? cidadeMaior.getNome() + " - " + cidadeMaior.getNumeroDeAcidentes() + " acidentes"
                        : "Nenhuma cidade encontrada.")
                +
                "\n\nCidade com menor número de acidentes:\n" +
                (cidadeMenor != null ? cidadeMenor.getNome() + " - " + cidadeMenor.getNumeroDeAcidentes() + " acidentes"
                        : "Nenhuma cidade encontrada.");

        JOptionPane.showMessageDialog(
                null,
                resultado,
                "Cidades com maior e menor número de acidentes",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cidadesAcimaDaMedia(Cidade[] cidades) {
        double media = Arrays
                .stream(cidades)
                .mapToInt(Cidade::getNumeroDeAcidentes)
                .average()
                .orElse(0);

        String resultado = Arrays
                .stream(cidades)
                .filter(cidade -> cidade.getNumeroDeAcidentes() > media)
                .map(cidade -> cidade.getNome() + " - " + cidade.getNumeroDeAcidentes() + " acidentes")
                .reduce((a, b) -> a + "\n" + b)
                .orElse("Nenhuma cidade encontrada.");

        JOptionPane.showMessageDialog(
                null,
                resultado,
                "Cidades com número de acidentes acima da média (" + media + " acidentes)",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void escreverArquivoEstatisticas(Cidade[] cidades) throws IOException {
        String nomeDoArquivo = "estatisticas_transito.txt";
        var arquivo = new FileWriter(nomeDoArquivo);
        var buffer = new BufferedWriter(arquivo);

        buffer.write("Estatísticas de Trânsito\n");

        for (Cidade cidade : cidades) {
            buffer.write("\n" + cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getNumeroDeAcidentes() + " acidentes");
        }

        buffer.close();
    }
}
