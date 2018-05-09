package model;

public class EmptyTile implements Cell{

	private String type;
	public EmptyTile()
	{
		setType("EmptyTile");
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type=type;
	}

}
