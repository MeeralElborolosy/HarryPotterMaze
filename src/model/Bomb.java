package model;

public abstract class Bomb implements Cell{
	private String type;
	public abstract void BombPlayer();
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
}
