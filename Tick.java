import java.util.*;
import java.lang.*; 
public class Tick
{
	public static void main(String[] args) 
	{
		int ch;
		do
		{
			int x,y;
            int fn;
			TicTacToe t = new TicTacToe();
			Scanner sc = new Scanner(System.in);
            System.out.println();
			System.out.println("\nThis is a TicTacToe game for two players");
			System.out.println("******MENU******");
			System.out.println("1.Play \n2.How to play \n3.Credits \n4.Exit");
            try
            {
		          fn = sc.nextInt();
            }
            catch(Exception e)
            {
                fn = 5;
            }

			switch(fn)
			{
				case 1: do
				{
					System.out.println(t.player==t.X?"\nPlayer X turn":"Player O turn");
					System.out.println("\nEnter the location where you want to put down the markar");
                    try
                    {
                        x = sc.nextInt();
    				    y = sc.nextInt();
                    }
                    catch(Exception e)
                    {
                        //System.out.println("Enter correct Row and coloum Number");
                        //System.out.println(e);
                        //x=1;
                        //y=1;
                        break;
                    }   
					t.putSign(x, y);
        			System.out.println(t.toString());
        			System.out.println("_____________________________");
        			t.displayWinner();
        		}while(t.isEmpty);
                System.out.println("Do you want to play again?(0/1)");
        		break;

				case 2:	System.out.println("How to play: The two players take turns in choosing the loacation to put their markers in the board");
						System.out.println("The Board initital state is");
						System.out.println("__|___|__\n__|___|__\n  |   |  ");
                        System.out.println("Press 1 to go back to MENU");
				break;

				case 3: System.out.println("By Araon\nThanks for playing :)");
                        System.out.println("Press 1 to go back to MENU");

				break;

				case 4:System.out.println("Thanks for playing :)");
						System.exit(0);
				break;

				default: System.out.println("Enter correct option");

				break;
			}
            try
            {
                ch = sc.nextInt();
            }
            catch(Exception e)
            {
                ch = 1;
                System.out.println("Error in input, restarting GAME");
            }
		}while(ch==1);	
	}
}

class TicTacToe
{
    public static final int X = 1, O = -1;
    public static final int EMPTY = 0;
      
    public int player = X;
    private int[][] board = new int[3][3];
    public boolean isEmpty = false;
      
    /** Puts an X or O mark at position i,j. */
    public void putSign(int x, int y)
    {
        if(x<0 || x>2 || y<0 || y>2)
        {
            System.out.println("Invalid board position\n");
            return;
        }
        if(board[x][y] != EMPTY)
        {
            System.out.println("Board position occupied\n");
            return;
        }
        board[x][y] = player;   // place the mark for the current player
        player = -player;       // switch players (uses fact that O = - X)
    }
      
    /** Checks whether the board configuration is a win for the given player. */
    public boolean isWin(int player)
    {
        return ((board[0][0] + board[0][1] + board[0][2] == player*3) ||
                (board[1][0] + board[1][1] + board[1][2] == player*3) ||
                (board[2][0] + board[2][1] + board[2][2] == player*3) ||
                (board[0][0] + board[1][0] + board[2][0] == player*3) ||
                (board[0][1] + board[1][1] + board[2][1] == player*3) ||
                (board[0][2] + board[1][2] + board[2][2] == player*3) ||
                (board[0][0] + board[1][1] + board[2][2] == player*3) ||
                (board[2][0] + board[1][1] + board[0][2] == player*3));
    }
      
    /**display the winning player or indicate a tie (or unfinished game).*/
    public void displayWinner()
    {
        if(isWin(X))
        {
            System.out.println("\n X wins...!!");
            isEmpty=false;
        }
        else if(isWin(O))
        {
            System.out.println("\n O wins...!!");
            isEmpty=false;
        }
        else
        {
            if(!isEmpty)
            {
                System.out.println("its a tie");
            }
              
        }
    }
      
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        isEmpty = false;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                switch(board[i][j])
                {
                case X:
                    s.append(" X ");
                    break;
                case O:
                    s.append(" O ");
                    break;
                case EMPTY:
                    s.append("   ");
                    isEmpty=true;
                    break;
                }
                if(j<2)
                {
                    s.append("|");
                }
                  
            }
            if(i<2)
            {
                s.append("\n-----------\n");
            }
        }
        return s.toString();
    }
}