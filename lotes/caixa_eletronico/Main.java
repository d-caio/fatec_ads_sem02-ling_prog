import java.math.BigDecimal;

import menus.*;
import caixa.*;
import exceptions.NotasNaoCarregadasException;
import exceptions.ValorExcedidoException;
import inputs_outputs.InputsEOutputs;

public class Main {
    private static final int MAXIMO_DE_TENTATIVAS = 5;
    private static int tentativas = 0;
    
    private static final String templateDoTituloDaMensagemDeErro = "Erro %d de %d";
    private static String tituloDaMensagemDeErro;
    
    public static void main(String[] args) {
        int opcao;
        
        var caixa = new Caixa();

        Opcao[] opcoesDoMenuPrincipal = new Opcao[] {new Opcao(1, "Carregar notas"), new Opcao(2, "Retirar notas"), new Opcao(3, "Estatísticas"), new Opcao(9, "Fim")};

        var menuPrincipal = new MenuDeOpcoes(
            "Menu Principal",
            opcoesDoMenuPrincipal
        );

        try {
            while (true) {    
                try {
                    opcao = menuPrincipal.selecionarOpcao();

                    tentativas = 0;

                    if (opcao == 9) {
                        InputsEOutputs.mostrarMensagemDeSucesso(
                            "Fim",
                            "Obrigado!"
                        );

                        return;

                    } else if (opcao == 1) {
                        caixa.carregarNotas();

                        var menuDeNotasDisponiveis = new MenuDeInformacoes(
                            "Valores Disponíveis",
                            caixa.relatorioDeNotasDisponiveis()
                        );

                        InputsEOutputs.mostrarMensagemDeSucesso(
                            menuDeNotasDisponiveis.getTitulo(),
                            menuDeNotasDisponiveis.getTexto()
                        );
                    } else if (opcao == 2) {
                        int banco;

                        Banco[] bancos = caixa.getBancos();
                        
                        Opcao[] opcoesDoMenuDeBancos = new Opcao[bancos.length + 1];

                        for (int i = 0; i < bancos.length; i++) {
                            opcoesDoMenuDeBancos[i] = new Opcao(
                                bancos[i].getCodigo(),
                                bancos[i].getNome()
                            );
                        }

                        opcoesDoMenuDeBancos[bancos.length] = new Opcao(9, "Voltar");
                        
                        var menuDeBancos = new MenuDeOpcoes(
                            "Bancos Disponíveis para Saque",
                            opcoesDoMenuDeBancos
                        );
                        
                        while (true) {
                            try {
                                banco = menuDeBancos.selecionarOpcao();

                                tentativas = 0;

                                break;
                            } catch (NumberFormatException e) {
                                tratamentoDeExcecoesInternas(
                                    "A opção selecionada deve ser um número inteiro de acordo com os códigos válidos."
                                );
                            } catch (IllegalArgumentException e) {
                                tratamentoDeExcecoesInternas(e.getMessage());
                            }
                        }

                        if (banco != 9) {
                            BigDecimal valorDeSaque;

                            var menuDeValorDeSaque = new MenuDeEscrita(
                                "Valor de Saque",
                                "Informe o valor que deseja sacar.\n\n" + caixa.relatorioDeNotasDisponiveis()
                            );
                            
                            while (true) {
                                try {
                                    valorDeSaque = menuDeValorDeSaque.informarValor();

                                    tentativas = 0;

                                    break;

                                } catch (NumberFormatException e) {
                                    tratamentoDeExcecoesInternas("Por favor, informe apenas valores numéricos, com decimais separados por ponto.");
                                    
                                }
                            }

                            try {
                                caixa.sacar(valorDeSaque, banco);

                                var menuDeValorSacado = new MenuDeInformacoes(
                                    "Valor Sacado",
                                    "Saque de " + caixa.getValorDoUltimoSaque() + " realizado com sucesso.\n\n" + caixa.relatorioDeNotasDisponiveis()    
                                );

                                menuDeValorSacado.mostrarInformacoes();

                            } catch (NotasNaoCarregadasException | ValorExcedidoException e) {
                                InputsEOutputs.mostrarMensagemDeErro(
                                    "Erro",
                                    e.getMessage()
                                );
                            }
                        }
                    }
                    
                } catch (NumberFormatException e) {
                    tratamentoDeExcecoesInternas("A opção selecionada deve ser um número inteiro de acordo com os códigos válidos.");

                } catch (IllegalArgumentException e) {
                    tratamentoDeExcecoesInternas(e.getMessage());

                }
            }

        } catch (NullPointerException e) {
            InputsEOutputs.mostrarMensagemDeAtencao("Fim", e.getMessage());

        } catch (IllegalStateException e) {
            InputsEOutputs.mostrarMensagemDeErro(tituloDaMensagemDeErro, e.getMessage());

        }
    }

    private static void atualizarTituloDaMensagemDeErro() {
        tituloDaMensagemDeErro = String.format(templateDoTituloDaMensagemDeErro, tentativas, MAXIMO_DE_TENTATIVAS);
    }

    private static void verificarLimiteDeTentativas() {
        if (tentativas == MAXIMO_DE_TENTATIVAS)
            throw new IllegalStateException("Máximo de tentativas atingido. O programa será encerrado.");
    }

    private static void tratamentoDeExcecoesInternas(String mensagem) {
        tentativas++;
                    
        atualizarTituloDaMensagemDeErro();
                    
        verificarLimiteDeTentativas();
                    
        InputsEOutputs.mostrarMensagemDeErro(tituloDaMensagemDeErro, mensagem);
    }
}
