package FourGame;

import java.util.Scanner;
public class Board{

    String[][] board;
    Scanner scanner = new Scanner(System.in);
    int row, column;
    
    public void boardSetUp(){
        //int row, column;
        System.out.println("Enter the number of rows: ");
        row = scanner.nextInt(); //Number of rows prompted by user
        scanner.nextLine();
        System.out.println("Enter the number of columns: ");
        column = scanner.nextInt(); //Number of columns prompted by user
        scanner.nextLine();
        board = new String[row][column]; //Created a board with the rows and columns selected by user
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                board[i][j] = " - "; //placed "-" to represent empty spaces.
            }
        }
        
    }

    public void printBoard(){
    	for(int i=0;i<board.length;i++) {
    		for(int j=0;j<board[0].length;j++) {
    			System.out.print(board[i][j]);  //Prints out the current state of the board
    		}
    		System.out.println("\n");
    	}
    
    }

public boolean columnFull(int col){
    if(board[0][col].equals(" - ")){   //Checks the top row in the column if a column is full or not
        return false;
    }else {
    	return true;
    }
}

public boolean boardFull(){
    for(int i=0;i<board[0].length;i++){
       if(board[0][i].equals(" - ")){  //Checks if the entire board is full
           return false;
       }
    }
    return true;
}

public boolean addToken(int colToAddToken, String playerNumber) {
	for(int i=board.length-1;i>0;i--) {
		if(board[i][colToAddToken].equals(" - ")) {   //Searches starting from the bottom if there is empty space
			board[i][colToAddToken] = playerNumber;   //if found it places the player's token and returns true
			return true;
		}
	}
	return false;
}

public boolean checkIfPlayerIsWinner(String playerNumber){
    if(checkVertical(playerNumber) || checkHorizontal(playerNumber) || checkRightDiagonal(playerNumber) || checkLeftDiagonal(playerNumber)){
        return true;
    }else{
        return false;
    }
}

public boolean checkVertical(String playerNumber){
	for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j].equals(playerNumber)){
            	if(i+3 < board[0].length) {
            		if(board[i+1][j].equals(playerNumber) && board[i+2][j].equals(playerNumber)&& board[i+3][j].equals(playerNumber)) {
            			return true;
            		}
                }
            }
        }
    }
    return false;
}


public boolean checkHorizontal(String playerNumber){
	for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j].equals(playerNumber)){
            	if(j+3 < board[0].length) {
            		if(board[i][j+1].equals(playerNumber) && board[i][j+2].equals(playerNumber)&& board[i][j+3].equals(playerNumber)) {
            			return true;
            		}
                }
            }
        }
    }
    return false;
}
public boolean checkRightDiagonal(String playerNumber){
	for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j].equals(playerNumber)){
            	if(i+3 < board.length && j+3 <board.length) { // if 
            		if(board[i+1][j+1].equals(playerNumber) && board[i+2][j+2].equals(playerNumber)&& board[i+3][j+3].equals(playerNumber)) {
            			return true;
            		}
                }
            }
        }
    }
    return false;
}

public boolean checkLeftDiagonal(String playerNumber){
	for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(board[i][j].equals(playerNumber)){
            	if(i+3 < board.length) {
            		if(board[i+1][j-1].equals(playerNumber) && board[i+2][j-2].equals(playerNumber)&& board[i+3][j-3].equals(playerNumber)) {
            			return true;
            		}
                }
            }
        }
    }
    return false;
}


}