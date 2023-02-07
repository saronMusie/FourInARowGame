package FourGame;

import java.util.Scanner;
class Player{
    private String playerName;
    private String playerNumber;
    private static Scanner scanner = new Scanner(System.in);
    public Player(String playerName, String playerNumber){
        this.playerName = playerName;
        this.playerNumber = playerNumber;
    }
    public String getName(){
        return playerName;
    }
    public String getPlayerNumber(){
        return playerNumber;
    }
    public int makeMove()throws InputMismatchException{
    	
    		System.out.println("Choose column");
            int columnNum = scanner.nextInt();
            scanner.nextLine();
            scanner.close();
            return columnNum;
    	
        
    }
    public String toString(){
        return ("Player "+playerNumber+" is "+playerName);
    }
}