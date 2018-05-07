package model;

public class BulletsGift extends Gift{
	
	public BulletsGift() {
		super();
		this.setType("BulletsGift");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gainGift() {
		// TODO Auto-generated method stub
		Player.getPlayer().extraBullets();
	}

}
