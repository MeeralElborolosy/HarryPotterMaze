package control;

import model.MazePlayer;
import view.MazePane;

public class BulletsObserver extends Observers{
	static BulletsObserver inst= new BulletsObserver();
	private BulletsObserver()
	{
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Bullets= "+MazePlayer.getPlayer().getBullets());
		MazePane.bullets.setText("Spells: "+MazePlayer.getPlayer().getBullets());
	}
	public static BulletsObserver getBulletsObserver()
	{
		return inst;
	}

}
