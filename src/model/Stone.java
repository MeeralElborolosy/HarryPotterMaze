package model;

public class Stone extends Wall{
	
	public Stone() {
		super();
		this.setType("Stone");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void breakWall() {
		System.out.println("Can't break");
	}

}
