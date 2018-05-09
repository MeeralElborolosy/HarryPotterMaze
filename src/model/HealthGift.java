package model;

public class HealthGift extends Gift{

	public HealthGift() {
		super();
		setType("HealthGift");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gainGift() {
		// TODO Auto-generated method stub
		MazePlayer.getPlayer().increaseHealth();
	}
	
}
