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
	public void HitSpaceBar(char lastPressed) {
		// TODO Auto-generated method stub
		if(lastPressed=='u')
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos(),MazePlayer.getPlayer().getyPos()-1);
		else if(lastPressed=='d')
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos(),MazePlayer.getPlayer().getyPos()+1);
		else if(lastPressed=='r')
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos()+1,MazePlayer.getPlayer().getyPos());
		else if(lastPressed=='l')
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos()-1,MazePlayer.getPlayer().getyPos());
	}
	public String toString()
	{
		return this.type;
	}

}
