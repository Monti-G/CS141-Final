public class GameBoard{
	public static void main(String[] args) {
		
	}
	
	public GameBoard() {
		board = createEmptyBoard();
		playerName = "red";
		playerPiece = "R";
	}
	
	public String[][] board;
	public String playerName;
	public String playerPiece;
	
	
	// For every index of every row of f, put a | if index is even
	public String[][] createEmptyBoard() {
        String[][] f = new String[7][15];
        for (int i =0;i<f.length;i++) {
            for (int j =0;j<f[i].length;j++) {
                if (j% 2 == 0) f[i][j] ="|";
                else f[i][j] = " ";
                
                // Makes the last row have a bottom and not |s
                if (i==6) f[i][j]= "-";
            }
        }
        return f;
    }
    
    public boolean dropPiece(int position) {
        if(position < 0 || position > 6){
            return false;
        }

        int col = 2 * position + 1;
        // Starts looking for a free slot at the very bottom

        int row = 5;

        while (row >= 0 && !board[row][col].equals(" ")) {
            // Moves one row up
            row--;
        }

        // Free slot is found
        if (row >= 0) {
            board[row][col] = playerPiece;        
            return true;        
        }

        return false;
    }
    
    public boolean checkWinner() {
		if(checkWinnerVert() | checkWinnerHoriz() | checkWinnerDiag()){
			return true;
		}
		return false;
	}
	
	public boolean checkWinnerVert(){
        //Vertical Check
        for(int i = 0; i < 6; i++)
        {
            int count = 0;
            for(int j = 1; j < 14; j += 2)
            {
                if(board[i][j].equals(playerPiece))
                {
                    count++;
                }
                else count = 0;

                if(count == 4)
                {
                    return true;
                }
            }        
        }
        return false;
	}
	
	public boolean checkWinnerHoriz(){
        // Horizontal Check
        for(int i = 1; i < 14; i += 2)
        {
            int count = 0;
            for(int j = 0; j < 6; j++)
            {
                if(board[j][i].equals(playerPiece))
                {
                    count++;
                }
                else count = 0;

                if(count == 4)
                {
                    return true;
                }
            }        
        }
        return false;
	}
	
	public boolean checkWinnerDiag(){
        // Check for a diagonal to the bottom and right
        for(int i = 0; i < board.length-4; i++)
        {
            for(int j = 1; j < board[i].length-7; j = j + 2)
            {
                if(board[i][j].equals(playerPiece))
                {
                    if(board[i+1][j+2].equals(playerPiece) && board[i+2][j+4].equals(playerPiece) && board[i+3][j+6].equals(playerPiece))
                    {
                        return true;
                    }
                }
                else if(board[i][j].equals(playerPiece))
                {
                    if(board[i+1][j+2].equals(playerPiece) && board[i+2][j+4].equals(playerPiece) && board[i+3][j+6].equals(playerPiece))
                    {
                        return true;
                    }
                }
            }
        }
        
        // Check for a diagonal to the bottom and left
        for(int i = 0; i < board.length-4; i++)
        {
            for(int j = board[i].length-2; j >= 7; j = j - 2)
            {
                if(board[i][j].equals(playerPiece))
                {
                    if(board[i+1][j-2].equals(playerPiece) && board[i+2][j-4].equals(playerPiece) && board[i+3][j-6].equals(playerPiece))
                    {
                        return true;
                    }
                }
                else if(board[i][j].equals(playerPiece))
                {
                    if(board[i+1][j-2].equals(playerPiece) && board[i+2][j-4].equals(playerPiece) && board[i+3][j-6].equals(playerPiece))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    public void togglePlayer(){
		
		if(playerName == "red" && playerPiece == "R"){
			playerName = "yellow";
			playerPiece = "Y";
		} else {
			playerName = "red";
			playerPiece = "R";
		}
		
	}
    
    	// Code that prints GameBoard.
    public void printBoard() {
		System.out.println(" 0 1 2 3 4 5 6");
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 15; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
        }
    }
}
