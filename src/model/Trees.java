package model;

public class Trees extends Wall{
	public Trees() {
		super();
		this.setType("Trees");
	}
	String type="Trees";
	Player player=Player.getPlayer();
	@Override
	public void breakWall() {
		// TODO Auto-generated method stub
		if(player.getBullets()>0)
			System.out.println("Broken");
		else
			System.out.println("Not enough bullets");
	}
}
