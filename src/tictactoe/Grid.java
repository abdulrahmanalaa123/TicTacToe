package tictactoe;
import java.util.Scanner;
import java.lang.Character;
public class Grid {
	
	private char[][] grid;
	char winner;
	Scanner s = new Scanner(System.in);
	public Grid()
	{
		grid = new char[3][3];
	}
	
	public char get(int i, int j)
	{
		return grid[i][j];
	}
	public void set(char value,int i,int j)
	{
		grid[i][j] = value;
	}
	public int[] input()
	{
		int i[] = new int[2];
		do
		{
			do
			{
				System.out.println("Enter row");
				i[0] = s.nextInt();
				System.out.println("Enter column");
				i[1] = s.nextInt();		
			}
			while(i[0] <0 || i[0] >= 3 || i[1] <0 || i[1]>=3);
			
			if(grid[i[0]][i[1]] != 0)
				System.out.println(grid[i[0]][i[1]] + " Already exists, Enter again");
		}
		while(grid[i[0]][i[1]] != 0);
		
		return i;
	}
	
	public void render()
	{
		for(int i =0;i<3; i++)
		{
			System.out.print("|");
			for(int j =0;j<3;j++)
			{
				if(grid[i][j] == 0)
					System.out.print("~");
				else
					System.out.print(grid[i][j]);
			}
			System.out.println("|");
		}
	}
	
	public char check()
	{

		char rows = checkrows();
		char columns = checkcolumns();
		
		if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != 0)
			return grid[0][0];
		else if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != 0)
			return grid[0][2];
		else if(rows != 0)
			return rows;
		else if(columns != 0)
			return columns;
		else
			return 0;
		
	}
	
	private char checkrows()
	{
		boolean win;
			
		for(int i = 0; i < 3; i++) 
		{
            win = true;
			for(int j = 1; j <3; j++)
            {
                if(grid[i][j] != grid[i][j-1])
                    win = false;
            }
			 if(win && grid[i][0] != 0)
             	return grid[i][0];	
		}
		return 0;
	}
	
	private char checkcolumns()
	{
		boolean win;
		for(int j = 0; j < 3; j++) 
		{
            win = true;
			for(int i = 1; i <3; i++)
            {
                if(grid[i][j] != grid[i-1][j])
                    win = false;
               
            }
			 if(win && grid[0][j] !=0)
             	return grid[0][j];
		}
		return 0;
	}
}
