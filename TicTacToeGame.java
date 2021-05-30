package TicTaeToc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeGame {
	static char[] gameBoard;
	static String playerSelected;
	static String player1 = "";
	static String player2 = "";

	public static void main(String args[]) throws IOException {
		gameBoard = new char[10];
		gameBoard[0] = ' ';
		gameBoard[1] = ' ';
		gameBoard[2] = ' ';
		gameBoard[3] = ' ';
		gameBoard[4] = ' ';
		gameBoard[5] = ' ';
		gameBoard[6] = ' ';
		gameBoard[7] = ' ';
		gameBoard[8] = ' ';
		gameBoard[9] = ' ';
		selectXandZero();
		if(player1 != "" && player2 != "") {
			showBoard();
		}
	}

	public static void selectXandZero() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please choose X or O");
		try {
			playerSelected = reader.readLine();
			if (playerSelected.toUpperCase().equals("X")) {
				player1 = playerSelected.toUpperCase();
				player2 = "O";
				diplayPlayerSelectedChoose();
			} else if (playerSelected.toUpperCase().equals("O")) {
				player1 = playerSelected;
				player2 = "X";
				diplayPlayerSelectedChoose();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IOException("Please select valid choose input");
		}
	}

	static void diplayPlayerSelectedChoose() {
		System.out.println("User Player: " + player1 + " Computer: " +player2);
	}
	
	static void showBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + gameBoard[1] + " | " + gameBoard[2] + " | " + gameBoard[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9] + " |");
		System.out.println("|---|---|---|");
	}
}
