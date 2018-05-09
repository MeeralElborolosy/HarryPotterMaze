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
		if(MazePlayer.getPlayer().getArmor()==0)
			MazePlayer.getPlayer().addArmor();
		else
			MazePlayer.getPlayer().extraArmor();
	}

}
