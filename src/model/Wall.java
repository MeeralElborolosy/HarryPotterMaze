package model;

public abstract class Wall implements Cell{
	private String type;
	public abstract void breakWall();
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
}
