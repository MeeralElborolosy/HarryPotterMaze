package control;

import java.util.ArrayList;

public class CheckPoints {
	Memento checkPoint;
	int counter = 0;
	public CheckPoints(Memento checkPoint)
	{
		this.checkPoint=checkPoint;
	}
	public void saveCheckPoint(Memento newM)
	{
		if(this.checkPoint.getX()!=newM.getX()||this.checkPoint.getY()!=newM.getY())
		{
			this.checkPoint=newM;
			counter=0;
		}
	}
	public Memento getLastCheckPoint()
	{
		if(counter<5)
		{
			System.out.println(counter);
			counter++;
			return checkPoint;
		}
		Game_State.setState(new Loser());
		return new Memento(0,1);
	}
}
