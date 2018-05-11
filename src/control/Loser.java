package control;

import model.MazePlayer;

public class Loser extends Game_State{
	String type="Loser";
	@Override
	public void Move(int x,int y) {
		// TODO Auto-generated method stub
		//MazePlayer.getPlayer().movePlayer(x, y);
		
	}

	@Override
	public void HitSpaceBar(char lastPressed) {
		// TODO Auto-generated method stub
		//MazePlayer.getPlayer().fireBullets();
	}
	public String toString()
	{
		return this.type;
	}
}