package model;

import control.CheckPoints;
import control.Game_State;
import control.Memento;
import control.Winner;
import view.GameMenuDemo;
import view.MazePane;

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
	int Cx;
	int Cy;
	int moves;
	CheckPoints checkPoints;
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
		Cx=0;
		Cy=1;
		moves=200;
		checkPoints=new CheckPoints(new Memento(xPos,yPos));
	}
	public void reset()
	{
		setType("Player");
		health=100;
		bullets=6;
		armor=0;
		xPos=0;
		yPos=1;
		lastX=0;
		lastY=1;
		Cx=0;
		Cy=1;
		moves=200;
		checkPoints=new CheckPoints(new Memento(xPos,yPos));
	}
	public void loadPlayer(int health,int bullets,int armor,int Cx, int Cy,int moves)
	{
		this.health=health;
		this.bullets=bullets;
		this.armor=armor;
		this.xPos=Cx;
		this.yPos=Cy;
		this.lastX=xPos;
		this.lastY=yPos;
		this.moves=moves;
		checkPoints.saveCheckPoint(new Memento(Cx,Cy));
	}
	public static MazePlayer getPlayer()
	{
		return player;
	}
	public void decreaseHealth(int val)
	{
		if(armor>val)
			player.armor-=val;
		else
		{
			int temp=player.armor;
			player.armor=0;
			player.health-=(val-temp);
		}
		if(health<=0)
		{
			Maze.getMaze().getMatrix()[yPos][xPos]=new EmptyTile();
			Memento lastPos=checkPoints.getLastCheckPoint();
			xPos=lastPos.getX();
			yPos=lastPos.getY();
			Cx=lastPos.getX();
			Cy=lastPos.getY();
			((MazePane) GameMenuDemo.root.getChildren().get(3)).reDraw();
			this.health=20;
			System.out.println("no health");
		}
	}
	public void increaseHealth()
	{
		player.health+=20;
		if(player.health>100)
			player.health=100;
	}
	public void fireBullets(int x,int y)
	{
		if(bullets>0)
		{
			bullets--;
			Maze.getMaze().getMatrix()[y][x]=new EmptyTile();
		}
	}
	public boolean fireBullets()
	{
		if(bullets>0)
		{
			bullets--;
			return true;
		}
		return false;
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
			{
				xPos+=x;
				moves--;
			}
		}
		else if(x<0)
		{
			if(xPos>0)
			{
				xPos+=x;
				moves--;
			}
		}
		if(y>0)
		{ 
			if(yPos<28)
			{
				yPos+=y;
				moves--;
			}
		}
		else if(y<0)
		{
			if(yPos>1)
			{
				yPos+=y;
				moves--;
			}
		}
		if(xPos==30&&yPos==28)
		{
			Game_State.getState().setState(new Winner());
		}
		else if(Maze.getMaze().getMatrix()[yPos][xPos].getType().equals("BulletsGift"))
			this.extraBullets();
		else if(Maze.getMaze().getMatrix()[yPos][xPos].getType().equals("SmallBomb"))
			this.decreaseHealth(10);
		else if(Maze.getMaze().getMatrix()[yPos][xPos].getType().equals("BigBomb"))
			this.decreaseHealth(20);
		else if(Maze.getMaze().getMatrix()[yPos][xPos].getType().equals("HealthGift"))
			this.increaseHealth();
		else if(Maze.getMaze().getMatrix()[yPos][xPos].getType().equals("ArmorGift"))
		{
			if(this.getArmor()>0)
				this.extraArmor();
			else
				this.addArmor();
		}
		else if(xPos==Voldemort.getYouKnowWho().getXpos()&&yPos==Voldemort.getYouKnowWho().getYpos()&&Voldemort.getYouKnowWho().life>0)
			this.decreaseHealth(30);
		else if(xPos==Dementor.getSoulEater().getXpos()&&yPos==Dementor.getSoulEater().getYpos()&&!Dementor.getSoulEater().hit)
		{
			if(bullets>0)
				bullets--;
			else
				decreaseHealth(10);
		}
		if(Memento.inCheckPoint())
			checkPoints.saveCheckPoint(new Memento(xPos,yPos));
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
		//this.lastX=xPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
		//this.lastY=yPos;
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
	public int getLastCx()
	{
		return Cx;
	}
	public int getLastCy()
	{
		return Cy;
	}
	public int getMoves()
	{
		return moves;
	}
	public int calculateScore()
	{
		int kills=0;
		if(Voldemort.getYouKnowWho().life<=0)
			kills+=30;
		if(Dementor.getSoulEater().hit)
			kills+=20;
		return moves+health*2+bullets*5+armor*2+kills;
	}
	public void DrawPlayer()
	{
		
	}
	
}
