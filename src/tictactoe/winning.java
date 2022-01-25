package tictactoe;

public class winning implements Ai{

	Random r = new Random();
	int[] temp = new int[2];
	
	public boolean check(char checked,char Player)
	{
		boolean k = false;
		if(checked == 0 || checked == Player)
			k=true;
		
		return k;
	}
	
	
	public int[] Prediction(Grid k, char Player)
	{
		boolean winnable = false;
		int [] position = new int[2];
		position[0] = -1;
		position[1] = -1;
		// rows
		for(int i = 0; i<3; i++)
		{
			// beginning the for loop
			for(int j=1;j<3;j++)
			{	
				//beginning the other
				winnable = false; 
				if(check(k.get(i,j),Player) && check(k.get(i, j-1),Player) ) // if its either its value or just 0 itll look at the prediction but if the row or column contain an o then it wont
				{
					if(k.get(i, j) == k.get(i, j-1)) //if there are 2 equal then its possible that its winnable
					winnable = true;
				
					if(winnable == false) // setting the value of the cell needed for a win
					{
						if(j%2 == 0)
						{
							if(k.get(i, j) == Player)
							{
								position[0] = i;
								position[1] = j-1;
							}
							else
							{
								position[0] = i;
								position[1] = j;
							}
						}
						else
							break;
					}
				}
				else
				{
					break;
				}
			}
			// end of the j for loop
			if(winnable)
				return position;
		}
		// end of rows
			// columns
		for(int j = 0; j<3; j++)
		{
			// j loop begins
			for(int i=1;i<3;i++)
			{
				// i loop begins
				winnable = false;
				if(check(k.get(i,j),Player) && check(k.get(i-1, j),Player))
				{
					if(k.get(i, j) == k.get(i-1, j))
						winnable = true;
					
					if(winnable == false)
					{
						if(i%2 == 0)
						{
							if(k.get(i, j) == Player)
							{
								position[0] = i-1;
								position[1] = j;
							}
							else
							{
								position[0] = i;
								position[1] = j;
							}	
						}
						else
							break;
					}
				}
				else
				{
					break;
				}
				
			} // i loop ends
			
			if(winnable)
				return position;
		}// j loop ends
		
		//left diagonal
		
		for(int i =1 ; i<3; i++)
		{
			winnable = false;
			if(check(k.get(i,i),Player) && check(k.get(i-1, i-1),Player))
			{
				if(k.get(i, i) == k.get(i-1, i-1))
					winnable = true;
				
				if(winnable == false)
				{
					if(i%2 ==0)
					{
						if(k.get(i, i) == Player)
						{
							position[0] = i-1;
							position[1] = i-1;
						}
						else
						{
							position[0] = i;
							position[1] = i;
						}
					}
					else
						break;
				}
			}
			else
				break;
		}
			if(winnable)
			return position;
			
			//right diagonal
			if(k.get(0, 2) == k.get(1, 1) && k.get(1, 1) != k.get(2, 0) &&k.get(0,2) == Player)
			{
				position[0] = 2;
				position[1] = 0;
				
				return position;
			}
			else if(k.get(2, 0) == k.get(1, 1) && k.get(1, 1) != k.get(0, 2) && k.get(2,0) == Player)
			{
				position[0] = 0;
				position[1] = 2;
				
				return position;
			}
			else if(k.get(2, 0) == k.get(0, 2) && k.get(0, 2) != k.get(1, 1) && k.get(0,2) == Player)
			{
				position[0] = 1;
				position[1] = 1;
				
				return position;
			}
			return position;
		
	}

	
	public void Fill(Grid k, char Player) {
		
		if(k.check() == 0)
		{
			if(Prediction(k,Player)[0] == -1)
			{
				r.Fill(k, Player);
			}
			else 
			{
				temp = Prediction(k,Player); 
				k.set(Player, temp[0],  temp[1]);
			}
				
		}
		
		
	}

}
