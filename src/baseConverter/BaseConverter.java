package baseConverter;

import java.util.Scanner;


public class BaseConverter {

	public static void main(String[] args) {
		// Só printa as paradas na tela
		System.out.print("Digite um comando \n");
		System.out.print("Caso precise de ajuda, digite /help,\n"+
		"digite /parar pra sair \n");
		System.out.print("*************************************** \n");
		String Command = "";
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		// Essa parte aqui faz a mágica acontecer
		while (run) {
			Command = scanner.next();

			if (Command.toLowerCase().equals("/help")) {
				// vai Printar o help
				System.out.println("Para utilizar o conversar digite \n" + "O:para converter de Octal para outras \n"
						+ "B:para Converter de Binário para as outras bases \n"
						+ "H:para Converter de Hexa para as outras bases \n"
						+ "D: queira converter de Decimal para outras bases \n" + "e após isso digite o número");

			} else if ((Command.toLowerCase().equals("/parar"))) {
				run = false;
			} else {
				char CommandCharArr[] = Command.toLowerCase().toCharArray();
				// Isso aqui vai pegar o final da linha
				char tipo = CommandCharArr[0];
				if (!(CommandCharArr.length <= 1)) {
					// Vai remover o identificador e deixar somente ó número
					char numberCharArray[] = new char[CommandCharArr.length - 1];
					for (int po = 1; po < CommandCharArr.length; po++) {
						numberCharArray[po - 1] = CommandCharArr[po];

					}

					ConversorDeNumero.setCharNumberArray(numberCharArray, tipo);
					System.out.println(ConversorDeNumero.getNumbersToShow());
				} else {
					System.out.println("Invalido");
				}

			}

		}
		scanner.close();
	}

}
