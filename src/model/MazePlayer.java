package model;

import control.Game_State;
import control.Winner;

public class MazePlayer implements Cell{
	private static MazePlayer player=new MazePlayer();
	private int health;
	private int bullets;
	private int armor;
	private String type;
	int xPos;
	int yPos;
	int lastX;
	int lastY;
	private MazePlayer()
	{
		setType("Player");
		health=100;
		bullets=6;
		armor=0;
		xPos=0;
		yPos=1;
		lastX=0;
		lastY=1;
	}
	public static MazePlayer getPlayer()
	{
		return player;
	}
	public void decreaseHealth(int val)
	{
		if(armor>0)
			player.health-=armor;
		else
			player.health-=val;
		if(health==0)
			System.out.println("lost");
	}
	public void increaseHealth()
	{
		player.health+=20;
		if(player.health>100)
			player.health=100;
	}
	public void fireBullets()
	{
		if(bullets>0)
			bullets--;
	}
	public void extraBullets()
	{
		player.bullets=6;
	}
	public void addArmor()
	{
		armor=100;
	}
	public void extraArmor()
	{
		armor+=10;
		if(armor>100)
			armor=100;
	}
	public int getHealth() {
		return health;
	}
	public int getBullets() {
		return bullets;
	}
	public int getArmor() {
		return armor;
	}
	public void movePlayer(int x,int y)
	{
		lastX=xPos;
		lastY=yPos;
		if(x>0)
		{
			if(xPos<30)
				xPos+=x;
		}
		else if(x<0)
		{
			if(xPos>0)
				xPos+=x;
		}
		if(y>0)
		{
			if(yPos<28)
				yPos+=y;
		}
		else if(y<0)
		{
			if(yPos>1)
				yPos+=y;
		}
		if(xPos==30&&yPos==28)
		{
			System.out.println("kasabty");
			Game_State.getState().setState(new Winner());
		}
		System.out.println(xPos+" "+yPos);
	}
	public int getLastX() {
		return lastX;
	}
	public int getLastY() {
		return lastY;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	@Override
	public void setType(String type) {
		this.type=type;
	}
	
}
