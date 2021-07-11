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
	
	 private static boolean isSpaceAvaiable(char[] board, int position) {
			switch (position) {
			case 1:
				return (board[1] == 0);	
			case 2:
				return (board[2] == 0);
			case 3:
				return (board[3] == 0);
			case 4:
				return (board[4] == 0);
			case 5:
				return (board[5] == 0);
			case 6:
				return (board[6] == 0);
			case 7:
				return (board[7] == 0);
			case 8:
				return (board[8] == 0);
			case 9:
				return (board[9] == 0);
			default:
				return false;
			}
	 }
	 
	 static void playerTurn() {
	    	String userInut;
			try {
				while(true) {
					System.out.println("Where would you like to play? (1-9)");
					userInut = reader.readLine();
					if(isSpaceAvaiable(board, Integer.parseInt(userInut))) {
						break;
					} else {
						System.out.println(userInut + "");
					}
				}
				placeMove(userInut, player1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	 private static void computerMove() {
	 	Random random = new Random();
			int computerMove;
			while(true) {
				computerMove = random.nextInt(9) + 1;
				if(isSpaceAvaiable(board, computerMove)) {
					break;
				}
			}
			placeMove(Integer.toString(computerMove), player2);
			System.out.println("Computer Chose: " + computerMove);
	 }
	     
	 private static String toss() {
		 Random random = new Random();
		 int toss = random.nextInt(2);
		 if (toss == 1) {
		      return"tails";
		   } else {
		      return"heads";
		   }
	 }
	 
	 private static String tossSelectedByUser() {
		 String selectedInput = null;
		 System.out.println("PLease choose 1. Heads 2. Tails");
		 try {
			int userSelected = Integer.parseInt(reader.readLine());
			switch(userSelected) {
			case 1:
				selectedInput = "Heads";
			case 2:
				selectedInput = "Tails";
			default:
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedInput;
		 
	 }
	 
	public static void main(String args[])  {
		boolean isUserWontheToss;
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
			String tossResult = toss();
			String tossSelectedByUser = tossSelectedByUser();
			if(tossResult.equals(tossSelectedByUser)) {
				System.out.println("User Won");
				isUserWontheToss = true;
			} else {
				System.out.println("Computer Won");
				isUserWontheToss = false;
			}
			
			while(true) {
				if(isUserWontheToss) {
					playerTurn();
					showBoard();
					computerMove();
					showBoard();
				} else {
					computerMove();
					showBoard();
					playerTurn();
					showBoard();
				}
			}
	}		 
}
