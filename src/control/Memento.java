package control;

import model.MazePlayer;

public class Memento {
	int x;
	int y;
	public Memento(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public static boolean inCheckPoint()
	{
		if((MazePlayer.getPlayer().getxPos()==17&&MazePlayer.getPlayer().getyPos()==10)
			||(MazePlayer.getPlayer().getxPos()==21&&MazePlayer.getPlayer().getyPos()==18)
			||(MazePlayer.getPlayer().getxPos()==9&&MazePlayer.getPlayer().getyPos()==24))
			return true;
		return false;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
}