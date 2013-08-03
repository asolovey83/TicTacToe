public class Field {

  public static final int FIELD_SIZE = 3;
	// private static final char DEFAULT_CHAR=' ';

	public char[][] fields;
	public boolean result = true;
	public char holdSym, currentSym, checkSym;

	public Field() {
		fields = new char[FIELD_SIZE][FIELD_SIZE];
	}

	public void firstShowFields() {
		int cellValue = 1;
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				System.out.print("[" + cellValue + "]");
				cellValue++;
			}
			System.out.println();

		}

	}

	public char[][] updateFields(int choice, char sym) {

		currentSym=sym;
		
		if(currentSym=='X'){
			holdSym='O';
			}
		else if(currentSym=='O'){
			holdSym='X';
		}
		
		System.out.println("Ход игрока " +currentSym);
		System.out.println("Отдыхал игрок "+holdSym);
		
				
		int cellValue = 1;
		int playerChoice = choice;

		do {
			for (int i = 0; i < FIELD_SIZE; i++) {
				for (int j = 0; j < FIELD_SIZE; j++) {

					if (playerChoice == cellValue) {
						fields[i][j] = (char) currentSym;						
					} else if (fields[i][j] == (char) currentSym) {
						fields[i][j] = (char) currentSym;
					} else if (fields[i][j] == (char)holdSym) {
						fields[i][j] = (char) holdSym;
					} else {
						fields[i][j] = (char) ('0' + cellValue);

					}

					cellValue++;
				}

			}

			this.checkWin(fields, currentSym);
			return fields;

		} while (this.checkWin(fields, currentSym) == false);

	}
	
	

	public void showFields(char[][] fields) {

		this.fields = fields;

		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				System.out.print("[" + fields[i][j] + "]");
			}
			System.out.println();
		}

	}

	public boolean checkWin(char[][] field, char playerSym) {

		char[][] checkField = field;
		this.currentSym = playerSym;

		// checkline
		if (((checkField[0][0] == checkField[0][1]) && (checkField[0][1] == checkField[0][2]))
				|| ((checkField[1][0] == checkField[1][1]) && (checkField[1][1] == checkField[1][2]))
				|| ((checkField[2][0] == checkField[2][1]) && (checkField[2][1] == checkField[2][2]))) {

			System.out.println("The game is over. The winner is player " + playerSym);
			return  true;
		} 
		// checkraw
		else if (((checkField[0][0] == checkField[1][0]) && (checkField[1][0] == checkField[2][0]))
				|| ((checkField[0][1] == checkField[1][1]) && (checkField[1][1] == checkField[2][1]))
				|| ((checkField[0][2] == checkField[1][2]) && (checkField[1][2] == checkField[2][2]))) {
			System.out.println("The game is over. The winner is player " + playerSym);
			return result = true;
		
		} // checkdiagonal
		else if (((checkField[0][0] == checkField[1][1]) && (checkField[1][1] == checkField[2][2]))
				|| ((checkField[0][2] == checkField[1][1]) && (checkField[1][1] == checkField[2][0]))) {
			System.out.println("The game is over. The winner is player " + playerSym);
			return result = true;
		
		}
			return false;
	}
	
	

}
