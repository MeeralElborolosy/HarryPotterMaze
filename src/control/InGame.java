package control;

import model.MazePlayer;

public class InGame extends Game_State{
	String type="InGame";
	@Override
	public void Move(int x,int y) {
		// TODO Auto-generated method stub
		MazePlayer.getPlayer().movePlayer(x, y);
		
	}

	@Override
	public void HitSpaceBar() {
		// TODO Auto-generated method stub
		MazePlayer.getPlayer().fireBullets();
	}
	public String toString()
	{
		return this.type;
	}

}
