package TicTaeToc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TicTacToeGame {
	static char[] board = new char[10];
	static String  playerSelected;
	static char player1, player2;
	
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static void board() {
		
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
    
    public static void showBoard() {
    	board();
    }
	
    static void placeMove(String position, char symbol) {
			switch (position) {
			case "1":
				board[1] = symbol;	
				break;
			case "2":
				board[2] = symbol;	
				break;
			case "3":
				board[3] = symbol;	
				break;
			case "4":
				board[4] = symbol;	
				break;
			case "5":
				board[5] = symbol;	
				break;
			case "6":
				board[6] = symbol;	
				break;
			case "7":
				board[7] = symbol;	
				break;
			case "8":
				board[8] = symbol;	
				break;
			case "9":
				board[9] = symbol;	
				break;
			default:
				System.out.println("Invalid move");
				break;
			}
    }
			
    static void playerTurn() {
    	
    	String userInut;
		try {
			System.out.println("Where would you like to play? (1-9)");
			userInut = reader.readLine();
			placeMove(userInut, player1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private static void computerMove() {
    	Random random = new Random();
		int computerMove;
		computerMove = random.nextInt(9) + 1;
		placeMove(Integer.toString(computerMove), player2);
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
		
			showBoard();
			selectXandZero();
			
			while(true) {
				playerTurn();
				showBoard();
				computerMove();
				showBoard();
			}
	}		 
}
