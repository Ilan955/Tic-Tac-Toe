package game;

public class TicTacToe extends Game {
	
public TicTacToe(String player1,String player2)
{
	super(3,3,new Player(player1,'X'),new Player(player2,'O'));
}

//will check if evern after we entered the number to the right place, we got three for all lines in this place
//from up down left right etc
//this five checks will cover all the possibility's for three in a row
protected boolean doesWin(int x,int y)
{
	if(!super.isEmpty(0, 0))
		if(super.maxLineContaining(0,0)==3)
			return true;
	if(!super.isEmpty(2, 0))
		if(super.maxLineContaining(2,0)==3)
			return true;
	if(!super.isEmpty(0, y))
		if(super.maxLineContaining(0,y)==3)
			return true;
	if(!super.isEmpty(x, 0))
		if(super.maxLineContaining(x,0)==3)
			return true;
	if(super.maxLineContaining(x,y)==3)
		return true;

return false;
}
}
