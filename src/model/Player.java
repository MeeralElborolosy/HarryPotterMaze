package model;

public class Player implements Cell{
	private static Player player=new Player();
	private int health;
	private int bullets;
	private int armor;
	private String type;
	int xPos;
	int yPos;
	private Player()
	{
		setType("Player");
		health=100;
		bullets=6;
		armor=0;
		xPos=0;
		yPos=0;
	}
	public static Player getPlayer()
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
		xPos+=x;
		yPos+=y;
		System.out.println("moved");
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
