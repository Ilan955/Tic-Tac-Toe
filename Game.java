package game;

import java.util.Scanner;

public class Game extends Board {
protected Player[] players=new Player[2];
protected Scanner s =new Scanner(System.in);


// will define the constructor, will place the players in the arrays, and initialize the boar
public Game(int n,int m,Player p1,Player p2)
{
	super(n,m);
	players[0]=p1;
	players[1]=p2;
}

// because we asked to make 0,0 win, we will check if the current place is 0,0
protected boolean doesWin(int i,int j)
{
	if(i==0&&j==0)
		return true;
	
	return false;
	
}


// will let player to put the input, after he put the input will check if the place already taken
//if empty will check if the current player won 
protected boolean onePlay(Player p)
{
	int x,y;
	if(super.isFull())
		return false;
	System.out.format("Pleas enter x and y: ");
	x=s.nextInt();
	y=s.nextInt();
	while(!super.isEmpty(x, y))
	{
		System.out.format("There is a piece there already...");
	x=s.nextInt();
	y=s.nextInt();
	}
	
	super.set(x, y, p);
	
	if(doesWin(x,y))
		return true;
	return false;
}

//play with two players, every time someone else is trying to make three in a row or every combination
// will pring to the screen if the board is full and no place to put new pawns.
public Player play()
{
	int i=0;
	int j=1;
	while(!super.isFull())
	{
		if(!onePlay(players[i]))
		{	if(onePlay(players[j]))
		{
			s.close();
				return players[j];
				
		}
		
		}
		else
		{s.close();
			return players[i];	
		}
	}
	if(super.isFull())
		System.out.format("The board is full!");
	
	return null;

}

}
