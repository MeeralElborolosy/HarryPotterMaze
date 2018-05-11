package control;

import model.MazePlayer;

public class HealthObserver extends Observers{

	static HealthObserver inst= new HealthObserver();
	private HealthObserver()
	{
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Health= "+MazePlayer.getPlayer().getHealth());
	}
	public static HealthObserver getHealthObserver()
	{
		return inst;
	}

}
