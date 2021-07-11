package TicTaeToc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class TicTacToeGame {
	static char[] board = new char[10];
	static String  playerSelected;
	static char player1, player2;
	static int count,indexWinningPosition;
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
		 int computerMove;
		 if(checkPossibilityToWin(player2)) {
			  computerMove = indexWinningPosition;
		 } else {
			 Random random = new Random();
			 while(true) {
				 computerMove = random.nextInt(9) + 1;
				 if(isSpaceAvaiable(board, computerMove)) {
					break;
				 }
			 }
		 }
			placeMove(Integer.toString(computerMove), player2);
			System.out.println("Computer Chose: " + computerMove);
	 }
	     
	 private static String toss() {
		 Random random = new Random();
		 int toss = random.nextInt(2);
		 if (toss == 1) {
		      return"Tails";
		   } else {
		      return"Heads";
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
	 
	 private static boolean isGameFinished(String player) {	 
		 if(hasConstantWon('X')) {
			 System.out.println(player +"  won");
			 return true;
		 }
		 
		 if(hasConstantWon('O')) {
			 System.out.println(player +" won");
			 return true;
		 }
		 
		 if(count < 9)
			return false;
			 
		 showBoard();
		 System.out.println("the game ended in a tie!");
		 return true;
	 }
	 
	 private static boolean hasConstantWon(char symbol) {
		 if(board[1] == symbol  && board[2] == symbol && board[3] == symbol) {
			 return true;
		 } else if(board[4] == symbol  && board[5] == symbol && board[6] == symbol) {
			 return true;
		 } else if(board[7] == symbol  && board[8] == symbol && board[9] == symbol) {
			 return true;
		 } else if(board[1] == symbol  && board[5] == symbol && board[9] == symbol) {
			 return true;
		 } else if(board[3] == symbol  && board[5] == symbol && board[7] == symbol) {
			 return true;
		 } else if(board[2] == symbol  && board[5] == symbol && board[8] == symbol) {
			 return true;
		 } else if(board[3] == symbol  && board[6] == symbol && board[9] == symbol) {
			 return true;
		 } else if(board[1] == symbol  && board[4] == symbol && board[7] == symbol) {
			 return true;
		 } else if(board[2] == symbol  && board[5] == symbol && board[8] == symbol) {
			 return true;
		 }
		 return false;
	 }
	 
	 private static boolean checkPossibilityToWin(char player) {
		 if(board[1] == player  && board[2] == player && board[3] == 0) {
			 indexWinningPosition = 3;
			 return true;
		 } else if(board[1] == player  && board[2] == 0 && board[3] == player) {
			 indexWinningPosition = 2;
			 return true; 
		 } else if(board[1] == 0  && board[2] == player && board[3] == player) {
			 indexWinningPosition = 1;
			 return true; 
		 } else if(board[4] == player  && board[5] == player && board[6] == 0) {
			 indexWinningPosition = 6;
			 return true;
		 } else if(board[4] == player  && board[5] == 0 && board[6] == player) {
			 indexWinningPosition = 5;
			 return true;
		 } else if(board[4] == 0  && board[5] == player && board[6] == player) {
			 indexWinningPosition = 4;
			return true;
		 } else if(board[7] == player  && board[8] == player && board[9] == 0) {
			 indexWinningPosition = 9;
			 return true;
		 } else if(board[7] == player  && board[8] == 0 && board[9] == player) {
			 indexWinningPosition = 8;
			 return true;
		 } else if(board[7] == 0  && board[8] == player && board[9] == player) {
			 indexWinningPosition = 7;
			 return true;
		 } else if(board[1] == player  && board[4] == player && board[7] == 0) {
			 indexWinningPosition = 7;
			 return true;
		 } else if(board[1] == player  && board[4] == 0 && board[7] == player) {
			 indexWinningPosition = 4;
			 return true;
		 } else if(board[1] == 0  && board[4] == player && board[7] == player) {
			 indexWinningPosition = 1;
		     return true;
		 } else if(board[2] == 0  && board[5] == player && board[8] == player) {
			 indexWinningPosition = 2;
			 return true;	
		 } else if(board[2] == player  && board[5] == 0 && board[8] == player) {
			 indexWinningPosition = 5;
			 return true;
		 } else if(board[2] == player  && board[5] == player && board[8] == 0) {
			 indexWinningPosition = 8;
			 return true;
		 } else if(board[3] == player  && board[6] == player && board[9] == 0) {
			 indexWinningPosition = 9;
			 return true;
		 } else if(board[3] == player  && board[6] == 0 && board[9] == player) {
				 indexWinningPosition = 6;
				 return true;
		 } else if(board[3] == 0  && board[6] == player && board[9] == player) {
			 indexWinningPosition = 3;
			 return true;
		 } else if(board[1] == 0  && board[5] == player && board[9] == player) {
			 indexWinningPosition = 1;
			 return true;
		 } else if(board[1] == player  && board[5] == 0 && board[9] == player) {
			 indexWinningPosition = 5;
			 return true;
		 } else if(board[1] == player  && board[5] == player && board[9] == 0) {
			 indexWinningPosition = 9;
			 return true;
		 } else if(board[3] == player  && board[5] == player && board[7] == ' ') {
				 indexWinningPosition = 7;
				 return true;
		 } else if(board[3] == player  && board[5] == ' ' && board[7] == player) {
			 indexWinningPosition = 5;
			 return true;
		 } else if(board[3] == ' '  && board[5] == player && board[7] == player) {
			 indexWinningPosition = 3;
			 return true;
		 } 
		 return false;
	 }
	 
	public static void main(String args[])  {
		boolean isUserWontheToss;
		count = 0;
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
					count++;
					if(isGameFinished("player1")) {
						showBoard();
						break;
					}
					showBoard();
					computerMove();
					count++;
					if(isGameFinished("player2")) {
						showBoard();
						break;
					}
					showBoard();
				} else {
					computerMove();
					count++;
					if(isGameFinished("player2")) {
						showBoard();
						break;
					}
					System.out.println(" " + count);
					showBoard();
					playerTurn();
					count++;
					if(isGameFinished("player1")) {
						showBoard();
						break;
					}
					showBoard();
				}
				
			}
	}		 
}
