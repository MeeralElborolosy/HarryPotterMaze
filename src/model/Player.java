package model;

public class Player {
	Player player=new Player();
	int health;
	int bullets;
	int armour;
	private Player()
	{
		health=100;
		bullets=6;
		armour=0;
	}
	public Player getPlayer()
	{
		return player;
	}
	public void decreaseHealth(int val)
	{
		if(armour>0)
			player.health-=armour;
		else
			player.health-=val;
		if(health==0)
			System.out.println("lost");
	}
	public void increaseHealth(int val)
	{
		player.health+=val;
		if(player.health>100)
			player.health=100;
	}
	public void fireBullets()
	{
		if(bullets>0)
			bullets--;
	}
	public void extraBullets(int val)
	{
		player.health+=val;
		if(player.health>100)
			player.health=100;
	}
	public void addArmour()
	{
		armour=100;
	}
	public void extraArmour()
	{
		armour+=10;
		if(armour>100)
			armour=100;
	}
	
}
