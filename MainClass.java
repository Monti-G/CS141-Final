import java.util.*;
public class MainClass {
    public static void main(String[] args) {

				playGame();
	}
	
	public static void playGame() {
	
		// Empty 2D game board via GameBoard object and method.
        GameBoard gameBoard = new GameBoard();
        
        Scanner input = new Scanner(System.in);
		
		// Prints GameBoard.
        gameBoard.printBoard();
        
		boolean win = false;
		// Players taking turns and checking for wins.
        while(win == false) {    
			boolean valid = false;
			int userIn = -1;
            // Red takes their turn.
            System.out.println("Please drop a " + gameBoard.playerPiece + " piece in a column between 0 and 6:");
            do{
				// Error checks the user.
				
				int init = -1;
				if(input.hasNextInt()){
					
					init = input.nextInt();
					if(init < 7 & init > -1){
						
						valid = true;
					}
				} else {
					input.next();
				}
				if(valid){
					userIn = init;
				} else {
					System.out.println("Please insert valid input from 0-6:");
					
				}
				/*while(!input.hasNextInt() || input.nextInt() > 6 | input.nextInt() < 0) {
					System.out.println("Please insert valid input from 0-6:");
					input.next();
				}*/
			} while (!valid);
            gameBoard.dropPiece(userIn);
            gameBoard.printBoard();
            
			// Checks winning conditions.
			win = false;
            win = gameBoard.checkWinner();
            if(win)
            {
                System.out.println(gameBoard.playerName + " is the winner!");
                break;
            }
            //Switches the player.
			gameBoard.togglePlayer();
		}		
	}
}
