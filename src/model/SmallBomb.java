package model;

public class SmallBomb extends Bomb{

	public SmallBomb() {
		super();
		// TODO Auto-generated constructor stub
		this.setType("SmallBomb");
	}

	@Override
	public void BombPlayer() {
		// TODO Auto-generated method stub
		MazePlayer.getPlayer().decreaseHealth(10);
	}

}
