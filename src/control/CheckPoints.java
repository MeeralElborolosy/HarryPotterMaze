package control;

import java.util.ArrayList;

public class CheckPoints {
	Memento checkPoint;
	public CheckPoints(Memento checkPoint)
	{
		this.checkPoint=checkPoint;
	}
	public void saveCheckPoint(Memento newM)
	{
		this.checkPoint=newM;
	}
	public Memento getLastCheckPoint()
	{
		return checkPoint;
	}
}
