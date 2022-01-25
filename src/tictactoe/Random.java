package tictactoe;


public class Random implements Ai {
    
	public void Fill(Grid k, char Player) {
		int i;
		int j;
		do
		{
			i = (int) Math.round( Math.random() *2);
			j = (int) Math.round( Math.random() *2);
		}
		while(k.get(i, j) != 0);
		
		k.set(Player, i, j);
	}

	
}
