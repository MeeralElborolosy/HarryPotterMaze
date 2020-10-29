package model;

import java.util.TimerTask;

import view.GameMenuDemo;
import view.MazePane;

public class Voldemort {
	static Voldemort voldemort=new Voldemort();
	int life;
	int x=21;
	int y=26;
	private Voldemort()
	{
		life=4;
	}
	public static Voldemort getYouKnowWho()
	{
		return voldemort;
	}
	public void hitYouKnowWho()
	{
		if(life>0)
		{
			if(MazePlayer.getPlayer().fireBullets())
				life--;
		}
	}
	public int getYouKnowWhoLife()
	{
		return life;
	}
	public void run() {
		// TODO Auto-generated method stub
		if(x<29)
			getYouKnowWho().x+=1;
		else
			getYouKnowWho().x=21;
		//getYouKnowWho().y+=1;
	}
	public int getXpos()
	{
		return x;
	}
	public int getYpos()
	{
		return y;
	}
	public void LoadVoldemort(int life)
	{
		this.life=life;
	}
}
