package model;

public class ArmorGift extends Gift{

	public ArmorGift() {
		super();
		this.setType("ArmorGift");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gainGift() {
		// TODO Auto-generated method stub
		if(Player.getPlayer().getArmor()==0)
			Player.getPlayer().addArmor();
		else
			Player.getPlayer().extraArmor();
	}

}
