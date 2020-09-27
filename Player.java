package game;

public class Player {
private String name;
private char mark;

//if the mark is an alphabetic one we need to make in a capital latter.
//if its TicTacToe its not relevant.
	public Player(String name,char mark)
	{
		int temp;
	this.name=name;
	if(mark>=97&&mark<=122)
	{temp = (int) mark;
    temp = temp -32;
    mark = (char) temp;}
	this.mark=mark;
	}
	public String getName()
	{
		return name;
	}
	public char getMark()
	{
		return mark;
	}
	
	
	public String toString()
	{
		return(name+"("+mark+")");
	}
}
