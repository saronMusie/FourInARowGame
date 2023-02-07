package FourGame;
//import java.util.InputMismatchException;
import java.util.Scanner;


public class Game {
	 private Player[] players;
		private Board board;
		private static Scanner scanner = new Scanner(System.in);
		
		public Game(){
			this.players = new Player[2];
			this.board = new Board();
		}
		
		public void setUpGame() {
			System.out.print("Enter player 1 Name: ");
			String player1Name = scanner.nextLine();
			System.out.print("Enter player 2 Name: ");
			String player2Name = scanner.nextLine();
			if(!player1Name.equals(player2Name)) {
				players[1] = new Player(player1Name,"1");
				players[2] = new Player(player2Name,"2");
				board.boardSetUp();
			}else {
				System.out.println("Players Names should be different!");
				setUpGame();
			}
			
			}	
		public void printWinner(Player player) {
			System.out.println("!!!! WINNER !!!!");
			System.out.println(player.getName());
		}
		
		public void playerTurn(Player currentPlayer){
			try {
				int cmn = currentPlayer.makeMove();
				boolean tokenAdded = board.addToken(cmn,currentPlayer.getPlayerNumber());
				if(tokenAdded) {
					board.printBoard();
				}else if(board.columnFull(cmn)) {
					throw new ColumnFullException("Column is Full.");
				}else if(cmn > board.column) {
					throw new InvalidMoveException("You entered a column number that is greater than board");
				}
				
			}catch(InputMismatchException e) {
				e.getMessage();
			}catch(ColumnFullException e) {
				e.getMessage();
			}catch(InvalidMoveException e) {
				e.getMessage();
			}catch(Exception e) {
				e.getMessage();
			}
			
		}
		public void play() {
			boolean noWinner = true;
			setUpGame();
			int currentPlayerIndex = 0;
			while(noWinner) {
				if(board.boardFull()) {
					System.out.println("Board is now full. Game Ends");
					play();
				}else {
					Player currentPlayer = players[currentPlayerIndex];
					System.out.println("It is player "+currentPlayer.getPlayerNumber()+"'s turn."+currentPlayer.getName());
					playerTurn(currentPlayer);
					boolean win = board.checkIfPlayerIsWinner(currentPlayer.getPlayerNumber());
					if(win) {
						printWinner(currentPlayer);
						noWinner = false;
					}else {
						currentPlayerIndex = currentPlayerIndex++ % players.length;
					}
					
				}
			}
		}
	}
	
	
	