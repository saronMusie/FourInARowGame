package FourGame;
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
	}
	
	
	