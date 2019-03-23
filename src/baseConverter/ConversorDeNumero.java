package baseConverter;

public class ConversorDeNumero {

	private ConversorDeNumero() {
	}

	private static long valorDecimal;
	private static String valorDecimalSt;
	private static String valorBinarioSt;
	private static String valorOctalSt;
	private static String valorHexaSt;
	private static boolean failed = false;

	private static void converterBases(int[] numberArray, char tipo) {
		// vai pegar o valor decimal
		switch (tipo) {
		case 'd':
			setValorDecimalfDecimal(numberArray);
			break;
		case 'b':
			setValorDecimalfBinario(numberArray);
			break;
		case 'h':
			setValorDecimalfHexa(numberArray);
			break;
		case 'o':
			setValorDecimalfOctal(numberArray);
			break;

		}
		prepareStrings(tipo);
		// System.out.println(valorDecimal);
	}

	private static String reverter(String paraReverter) {
		String reverso = "";
		char[] reverter = paraReverter.toCharArray();
		for (int a = reverter.length - 1; a >= 0; --a) {
			reverso += reverter[a];
		}
		return reverso;

	}

	public static String getNumbersToShow() {

		if (!failed) {
			return "O Valor desse número em Decimal é " + valorDecimalSt + "\n" + "O Valor Binário desse numero é "
					+ valorBinarioSt + "\n" + "o Valor Hexadecimal é " + valorHexaSt.toUpperCase() + "\n"
					+ "O valor Octal desse número é " + valorOctalSt;
		} else {
			return "";
		}
	}

	private static void prepareStrings(char tipo) {
		valorDecimalSt = Long.toString(valorDecimal);
		long modified = valorDecimal;
		String Converted = "";

		if (tipo != 'b') {
			while (modified != 0) {
				Converted += (modified % 2);
				modified = (long) modified / 2;

			}
			valorBinarioSt = reverter(Converted);
		}
		modified = valorDecimal;
		Converted = "";

		if (tipo != 'o') {

			while (modified != 0) {
				Converted += (modified % 8);
				modified = (long) modified / 8;
			}
			valorOctalSt = reverter(Converted);
		}
		modified = valorDecimal;
		Converted = "";
		if (tipo != 'h') {
			while (modified != 0) {
				long temp = modified % 16;

				if (temp > 9) {
					switch ((int) temp) {
					case 10:
						Converted += 'a';
						break;
					case 11:
						Converted += 'b';
						break;
					case 12:
						Converted += 'c';
						break;
					case 13:
						Converted += 'd';
					case 14:
						Converted += 'e';
						break;
					case 15:
						Converted += 'f';
						break;
					}
				} else {
					Converted += temp;
				}
				modified = modified / 16;

			}
			valorHexaSt = reverter(Converted);
		}

	}

	private static void setValorDecimalfOctal(int[] numberArray) {
		valorDecimal = 0;
		for (int a = 0; a < numberArray.length; a++) {
			valorDecimal += numberArray[a] * Math.pow(8, numberArray.length - a - 1);
		}
	}

	private static void setValorDecimalfHexa(int[] numberArray) {
		valorDecimal = 0;
		for (int a = 0; a < numberArray.length; a++) {
			valorDecimal += numberArray[a] * Math.pow(16, numberArray.length - a - 1);
		}

	}

	private static void setValorDecimalfBinario(int[] numberArray) {
		valorDecimal = 0;
		for (int a = 0; a < numberArray.length; a++) {
			valorDecimal += numberArray[a] * Math.pow(2, numberArray.length - a - 1);
		}

	}

	private static void setValorDecimalfDecimal(int[] numberArray) {
		valorDecimal = 0;
		for (int a = 0; a < numberArray.length; a++) {
			valorDecimal += numberArray[a] * Math.pow(10, numberArray.length - a - 1);
		}

	}

	public static void setCharNumberArray(char numberArray[], char tipo) {
		int[] numberArrayInt = new int[numberArray.length];
		failed = false;
		for (int a = 0; a < numberArrayInt.length; a++) {

			// Somente zeros e uns em binários
			if (tipo == 'b') {
				for (char b : numberArray) {
					if (!(b == '0' || b == '1')) {
						System.out.println("binários não podem haver valores diferentes de \n" + "1 ou 0");
						failed = true;
						return;
					}
				}

			}

			// Verificar se não há letras em números não hexadecimais
			if (tipo != 'h') {
				// Verificar maiores q 7 em octais
				if (tipo == 'o') {
					for (char b : numberArray) {
						if (b == '8' || b == '9') {
							System.out.println("octais não podem haver valores maiores que 7 em cada casa decimal");
							failed = true;
							return;
						}
					}

				}
				for (char b : numberArray) {
					if (b == 'a' || b == 'b' || b == 'c' || b == 'd' || b == 'e' || b == 'f') {
						System.out.println("Somente Valores hexadecimais podem haver \n " + "letras de a à f");
						failed = true;
						return;
					}
				}
			}
			// Não vai precisar converter caso seja do mesmo tipo
			switch (tipo) {
			case 'h':
				valorHexaSt = String.valueOf(numberArray);
				break;
			case 'b':
				valorBinarioSt = String.valueOf(numberArray);
				break;
			case 'd':
				valorDecimalSt = String.valueOf(numberArray);
				break;
			case 'o':
				valorOctalSt = String.valueOf(numberArray);
				break;
			}
		}
		// Vai colocar os valores reais nos cantos
		for (int a = 0; a < numberArray.length; a++) {
			switch (numberArray[a]) {
			case '0':
				numberArrayInt[a] = 0;
				break;
			case '1':
				numberArrayInt[a] = 1;
				break;
			case '2':
				numberArrayInt[a] = 2;
				break;
			case '3':
				numberArrayInt[a] = 3;
				break;
			case '4':
				numberArrayInt[a] = 4;
				break;
			case '5':
				numberArrayInt[a] = 5;
				break;
			case '6':
				numberArrayInt[a] = 6;
				break;
			case '7':
				numberArrayInt[a] = 7;
				break;
			case '8':
				numberArrayInt[a] = 8;
				break;
			case '9':
				numberArrayInt[a] = 9;
				break;
			case 'a':
				numberArrayInt[a] = 10;
				break;
			case 'b':
				numberArrayInt[a] = 11;
				break;
			case 'c':
				numberArrayInt[a] = 12;
				break;
			case 'd':
				numberArrayInt[a] = 13;
				break;
			case 'e':
				numberArrayInt[a] = 14;
				break;
			case 'f':
				numberArrayInt[a] = 15;
				break;
			default:
				System.out.println("valor numérico inválido");
				return;

			}
		}

		converterBases(numberArrayInt, tipo);

	}

}
