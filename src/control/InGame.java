package control;

import model.Maze;
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
		if((lastPressed=='u')&&(Maze.getMaze().getMatrix()[MazePlayer.getPlayer().getyPos()-1][MazePlayer.getPlayer().getxPos()].getType().equals("Trees")))
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos(),MazePlayer.getPlayer().getyPos()-1);
		else if((lastPressed=='d')&&(Maze.getMaze().getMatrix()[MazePlayer.getPlayer().getyPos()+1][MazePlayer.getPlayer().getxPos()].getType().equals("Trees")))
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos(),MazePlayer.getPlayer().getyPos()+1);
		else if((lastPressed=='r')&&(Maze.getMaze().getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()+1].getType().equals("Trees")))
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos()+1,MazePlayer.getPlayer().getyPos());
		else if((lastPressed=='l')&&(Maze.getMaze().getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()-1].getType().equals("Trees")))
			MazePlayer.getPlayer().fireBullets(MazePlayer.getPlayer().getxPos()-1,MazePlayer.getPlayer().getyPos());
	}
	public String toString()
	{
		return this.type;
	}

}
