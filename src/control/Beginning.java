package control;

import model.MazePlayer;

public class Beginning extends Game_State{
	String type="Beginning";
	@Override
	public void Move(int x,int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitSpaceBar(char lastPressed) {
		// TODO Auto-generated method stub
	}
	public String toString()
	{
		return this.type;
	}
}
