package game;

public class Board {
	protected Player[][] board;
	protected int n,m;
	private int count;
	public Board(int n,int m)
	{
		this.n=n;
		this.m=m;
		board=new Player[n][m];
	}
	
//initialize the current place if its not taken, by player p
protected boolean set(int i,int j,Player p)
{
	if(isEmpty(i,j))
	{	board[i][j]=p;
		count++;
		
		return true;
	}
	 return false;
	}

//before every entering, we will check if there is a pawn already in this place.
public boolean isEmpty(int i,int j)
{if(board[i][j]==null)
	return true;
return false;
		
}

public Player get(int i ,int j)
{
	return board[i][j];
}
//whenever we enter new pawn to the board we will rise the count.
//we will check if the current count is equal to the board size
public boolean isFull()
{
	if(count==(n*m))
		return true;
	return false;
	
}

//will print in the requested order
public String toString()
{
	String s="";
	for(int i =0;i<n;i++)
	{	for(int j = 0;j<m;j++)
	{
		if(board[i][j]==null)
			s+=".";
		else
		s+=board[i][j].getMark();
	}
	s+="\n";
	}
return s;
}


//by looping, calling the ray method that will return to us the size of the ray.
//starting the count from one is because the current cell is equipied too.
protected int maxLineContaining(int i,int j)
{
	int count=1;
	int max=0;
	for(int dx=-1;dx<2;dx++)
		{	
			for( int dy=-1;dy<2;dy++)
				{
				if(dx==0&&dy==0)
				dy=dy;
					else
					{	count=rayLength(i,j,dx,dy);
					if(count>max)
						max=count;
					}
				}
			count=0;
				}
	
	
	max++;
	return max;
	
}

//Make a recursion method, that will be called from the MaxLine
//in order from -1,-1 to 1,1 we will check all the possibilitys if there is ray
//if indeed there is a ray in the place of X we will continiue to check, but now from the new place
private int rayLength(int x, int y, int dx, int dy)

{
	if((x+dx)<0||(y+dy)<0||(x+dx)>=n||(y+dy)>=m)
		
		return 0;
	
	
	if(board[x+dx][y+dy]==null)
		return 0;
	if(board[x+dx][y+dy].getMark()!=board[x][y].getMark())
		return 0;
	else
		return 1+rayLength(x+dx,y+dy,dx,dy);
	
}}




	


