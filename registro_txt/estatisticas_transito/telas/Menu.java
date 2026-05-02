package telas;

import java.io.IOException;
import javax.swing.JOptionPane;

import estatistica.Cidade;
import metodos.Metodos;

public class Menu {
    private static final int NUMERO_DE_CIDADES = 10;
    private static final int MAXIMO_DE_TENTATIVAS = 5;

    private static int tentativas = 0;
    private static String tituloDeErro = "Erro %d de %d";

    private static Cidade[] cidades;

    public static void exibirMenu() {
        while (true) {
            try {
                String menu = "Menu de Opções:\n" +
                        "1. Cadastrar Cidades\n" +
                        "2. Cidades com número de acidentes entre 101 e 499\n" +
                        "3. Cidades com maior e menor número de acidentes\n" +
                        "4. Cidades com número de acidentes acima da média\n" +
                        "5. Escrever arquivo com as estatísticas\n" +
                        "0. Sair";

                String opcaoStr = JOptionPane.showInputDialog(
                    null,
                    menu,
                    "Menu Principal",
                    JOptionPane.QUESTION_MESSAGE
                );

                if (opcaoStr == null)
                    throw new NullPointerException("Entrada cancelada pelo usuário.");

                int opcao = Integer.parseInt(opcaoStr);

                switch (opcao) {
                    case 1:
                        cidades = Metodos.cadastrarCidades(NUMERO_DE_CIDADES);
                        break;

                    case 2:
                        isCidadesNull();
                        Metodos.cidadesEntre101e499(cidades);
                        break;

                    case 3:
                        isCidadesNull();
                        Metodos.cidadesMaiorEMenor(cidades);
                        break;

                    case 4:
                        isCidadesNull();
                        Metodos.cidadesAcimaDaMedia(cidades);
                        break;

                    case 5:
                        isCidadesNull();
                        Metodos.escreverArquivoEstatisticas(cidades);
                        break;

                    case 0:
                        encerradoPeloUsuario();

                    default:
                        throw new IllegalArgumentException("Opção inválida.");
                }

            } catch (IllegalStateException e) {
                mensagemDeErro(e.getMessage());

            } catch (NumberFormatException e) {
                mensagemDeErro("Número inválido.");

            } catch (IllegalArgumentException e) {
                mensagemDeErro(e.getMessage());

            } catch (NullPointerException e) {
                encerradoPeloUsuario();

            } catch (IOException e) {
                mensagemDeErro("Erro ao escrever o arquivo.");
                
            }
        }
    }

    private static void isCidadesNull() {
        if (cidades == null) {
            throw new IllegalStateException("Nenhuma cidade cadastrada.");
        }
    }

    private static void mensagemDeErro(String mensagem) {
        tentativas++;

        if (tentativas >= MAXIMO_DE_TENTATIVAS) {
            JOptionPane.showMessageDialog(
                null,
                "Número máximo de tentativas atingido. Encerrando o programa.",
                String.format(tituloDeErro, tentativas, MAXIMO_DE_TENTATIVAS),
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(1);
        }
        
        JOptionPane.showMessageDialog(
            null,
            mensagem,
            String.format(tituloDeErro, tentativas, MAXIMO_DE_TENTATIVAS),
            JOptionPane.ERROR_MESSAGE
        );
    }

    private static void encerradoPeloUsuario() {
        JOptionPane.showMessageDialog(
            null,
            "Encerrando o programa. Até mais!",
            "Saída",
            JOptionPane.INFORMATION_MESSAGE
        );
        System.exit(0);
    }
}
