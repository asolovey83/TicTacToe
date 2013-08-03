import java.io.IOException;
import java.util.Scanner;

public class Main {

  private static char playerSym, compSym;
	private static int sym;
	private static int step=1;
	public static int playerChoice;
	public static boolean result;

	public static void main(String args[]) throws IOException {
		Field field = new Field();

		// start of the game
		System.out.println("Let`s play");
		System.out
				.println("Choose your symbol please");
		System.out.println("0='O', 1='X'");
		Scanner sc = new Scanner(System.in);
		sym = sc.nextInt();

		while (sym != 0 & sym != 1) {
			System.out
					.println("The symbol you entered is incorrect, please repeat");
			System.out.println("0='O', 1='X'");
			sym = sc.nextInt();
		}

		// setting player character
		if (sym == 1) {
			playerSym = 'X';
			compSym = 'O';
		} else if (sym == 0) {
			playerSym = 'O';
			compSym = 'Х';
		}

		System.out.println("There is a game field");
		System.out
				.println("Please choose the cell number you`d like to fill with  "
						+ playerSym);
		field.firstShowFields();

		
		do {
			playerChoice = (Integer) sc.nextInt();
			if (step % 2 == 0) {
				field.updateFields(playerChoice, compSym);
				result = field.checkWin(field.fields, compSym);
			} else {
				field.updateFields(playerChoice, playerSym);
				result = field.checkWin(field.fields, playerSym);
			}
			field.showFields(field.fields);
			step++;
		} while (result == false);
		

			System.out.println("Want to play once more? Y-Yes, N-No");
			char answer = (char) System.in.read();

			switch (answer) {
			case 'Y':
				System.out.println("Restarting the game");
				main(args);
				break;
			case 'N':
				System.out.println("Thank you! Bye-Bye!");
				sc.close();
				break;				
			default:
				break;
				
			
		}
			
		
	}
	
	
}
