package model;

public abstract class Gift implements Cell{
	private String type;
	public abstract void gainGift();
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
}
