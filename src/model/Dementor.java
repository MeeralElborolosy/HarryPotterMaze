package model;

import java.util.TimerTask;

import view.GameMenuDemo;
import view.MazePane;

public class Dementor{
	static Dementor dementor=new Dementor();
	int x=11;
	int y=18;
	boolean hit;
	private Dementor()
	{
		hit=false;
	}
	public static Dementor getSoulEater()
	{
		return dementor;
	}
	public void hitSoulEater()
	{
		hit=MazePlayer.getPlayer().fireBullets();
	}
	public void run() {
		// TODO Auto-generated method stub
		if(y<22)
			getSoulEater().y+=1;
		else
			getSoulEater().y=18;
	}
	public int getXpos()
	{
		return x;
	}
	public int getYpos()
	{
		return y;
	}
	public int getSoulEaterLife()
	{
		return hit?0:1;
	}
	public void LoadDementor(int hits)
	{
		if(hits==0)
			this.hit=true;
		else
			this.hit=false;
	}
}
