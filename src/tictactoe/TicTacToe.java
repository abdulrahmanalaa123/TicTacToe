package tictactoe;
import java.util.Scanner;
import java.lang.Character;
import java.lang.String;

public class TicTacToe {	
	public static void main(String[] args) {
		Grid tic = new Grid();
		int moves = 0;
		int indeces[] = new int[2];
		winning ai = new winning();
		do
		{
			tic.render();
			
			if(moves % 2 == 0)
			{
				System.out.println("X turn:");
                                ai.Fill(tic, 'X');
			}
			else
			{
				System.out.println("O turn:");
				indeces = tic.input();
				tic.set('O', indeces[0], indeces[1]);
			}
			
			moves++;
		}
		while(moves <9 && tic.check() == 0);
		
                tic.render();
                
		if(moves == 9 && tic.check() == 0)
		{
			System.out.println("DRAW!");
		}
		else
		{
			System.out.println(tic.check() + " WINS!");
		}
	}
	
	

}
