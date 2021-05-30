package TicTaeToc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeGame {
	static char[] gameBoard;
	static String playerSelected;
	static String player1 = "";
	static String player2 = "";

	public static void main(String args[]) {
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
	}

	public static void selectXandZero() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please choose X or O");
		try {
			playerSelected = reader.readLine();
			if (playerSelected.toUpperCase().equals("X")) {
				player1 = playerSelected.toUpperCase();
				player2 = "O";
			} else if (playerSelected.toUpperCase().equals("O")) {
				player1 = playerSelected;
				player2 = "X";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
