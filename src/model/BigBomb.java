package model;

public class BigBomb extends Bomb{
	public BigBomb() {
		super();
		this.setType("BigBomb");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void BombPlayer() {
		// TODO Auto-generated method stub
		MazePlayer.getPlayer().decreaseHealth(20);
	}

}
