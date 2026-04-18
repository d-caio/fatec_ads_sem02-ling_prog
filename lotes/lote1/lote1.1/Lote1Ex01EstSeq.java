//Coletar o valor do lado de um quadrado, calcular sua área e apresentar o resultado.

import javax.swing.JOptionPane;

public class Lote1Ex01EstSeq {
	private static final String TITULO_FALHA = "FALHA";
	private static final String TITULO_SUCESSO = "SUCESSO";
	private static final String TITULO_FIM = "FIM";
	private static final int MAX_TRIES = 5;

	public static void main(String args[]) {
		int tries = 0;

		while (tries < MAX_TRIES) {			
			try {
				String inputLado = JOptionPane.showInputDialog("Valor do lado do quadrado em metros: ");

				if (inputLado == null) {
					JOptionPane.showMessageDialog(null, "Programa fechado pelo usuário", TITULO_FIM, JOptionPane.INFORMATION_MESSAGE);

					return;
				}
								
				double lado = Double.parseDouble(inputLado.replace(",", "."));
				
				if (lado <= 0) {
					throw new IllegalArgumentException("O valor do lado do quadrado deve ser um número real maior que zero.");
				}

				double area = lado * lado;

				String mensagemSucesso = String.format("A área do quadrado é de %.2fm².", area);

				JOptionPane.showMessageDialog(null, mensagemSucesso, TITULO_SUCESSO, JOptionPane.PLAIN_MESSAGE);

				return;

			} catch (NumberFormatException e) {
				tries++;
				
				JOptionPane.showMessageDialog(null, "digite um número válido", TITULO_FALHA + ": tentativa " + tries + " de " + MAX_TRIES, JOptionPane.ERROR_MESSAGE);

			} catch (IllegalArgumentException e) {
				tries++;
				
				JOptionPane.showMessageDialog(null, e.getMessage(), TITULO_FALHA + ": tentativa " + tries + " de " + MAX_TRIES, JOptionPane.ERROR_MESSAGE);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), TITULO_FALHA, JOptionPane.ERROR_MESSAGE);
				
				return;
			}
		}

		JOptionPane.showMessageDialog(null, "Máximo de tentativas atingido. O programa será fechado.", TITULO_FALHA, JOptionPane.ERROR_MESSAGE);

	}
}
