package TicTaeToc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeGame {
	static char[] board = new char[10];
	static String  playerSelected;
	static char player1, player2;
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static void Board() {
		
		System.out.println(board[1] + "  | " + board[2] + " | " + board[3]);
        System.out.println("-----------");
        System.out.println(board[4] + "  | " + board[5] + " | " + board[6]);
        System.out.println("-----------");
        System.out.println(board[7] + "  | " + board[8] + " | " + board[9]);
	}
	
    static void selectXandZero() {
		System.out.println("Please choose X or O");
		try {
			playerSelected = reader.readLine();
			if (playerSelected.toUpperCase().equals("X")) {
				player1 = 'X';
				player2 = 'O';
			} else if (playerSelected.toUpperCase().equals("O")) {
				player1 = 'O';
				player2 = 'X';
			}
			System.out.println("Player 1: " + player1 + " Player 2: " + player2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])  {
		board[0] = '\0';
		board[1] = '\0';
		board[2] = '\0';
		board[3] = '\0';
		board[4] = '\0';
		board[5] = '\0';
		board[6] = '\0';
		board[7] = '\0';
		board[8] = '\0';
		board[9] = '\0';
		
		Board();
		selectXandZero();
	}		 
		
	
	
}
