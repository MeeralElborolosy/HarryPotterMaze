package control;

import model.MazePlayer;

public class ArmorObserver extends Observers{
	static ArmorObserver inst= new ArmorObserver();
	private ArmorObserver()
	{
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Armor= "+MazePlayer.getPlayer().getArmor());
	}
	public static ArmorObserver getArmorObserver()
	{
		return inst;
	}
}
