package control;

import java.util.TimerTask;

import model.MazePlayer;
import view.MazePane;

public class TimeUpdate extends TimerTask{
	static TimeUpdate timeUpdate=new TimeUpdate();
	long start;
	static long end;
	long loadedTime;
	private TimeUpdate()
	{
		super();
		start=System.nanoTime();
		loadedTime=0;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		end=System.nanoTime()-start;
		//MazeParser p=new MazeParser();
		//p.SaveMatrix();
	}
	public long getTimer()
	{
		System.out.println("Time:"+(end+loadedTime)/1000000000);
		return (end+loadedTime);
	}
	public static TimeUpdate getTime()
	{
		return timeUpdate;
	}
	public void LoadTime(long time)
	{
		this.loadedTime=time;
		System.out.println("loaded:"+loadedTime);
		System.out.println("Time:"+(end+loadedTime)/1000000000);
	}
	public long SaveTime()
	{
		return end+loadedTime;
	}
	public void reset()
	{
		start=System.nanoTime();
	}
}
