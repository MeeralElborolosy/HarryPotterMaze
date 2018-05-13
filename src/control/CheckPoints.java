package control;

import java.util.ArrayList;

import view.MazePane;

public class CheckPoints {
	Memento checkPoint;
	static int counter = 0;
	public CheckPoints(Memento checkPoint)
	{
		this.checkPoint=checkPoint;
	}
	public void saveCheckPoint(Memento newM)
	{
		if(this.checkPoint.getX()!=newM.getX()||this.checkPoint.getY()!=newM.getY())
		{
			this.checkPoint=newM;
		}
	}
	public Memento getLastCheckPoint()
	{
		if(counter<5)
		{
			System.out.println(counter);
			counter++;
			MazePane.lives.setText("Lives: "+(5-counter));
			return checkPoint;
		}
		Game_State.setState(new Loser());
		return new Memento(0,1);
	}
	public static int getLives()
	{
		return counter;
	}
	public static void setLives(int c)
	{
		counter=c;
		MazePane.lives.setText("Lives: "+(5-counter));
	}
}
