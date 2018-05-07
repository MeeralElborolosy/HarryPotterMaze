package model;

public class CellFactory {
	public Cell createCell(Cell cell)
	{
		if(cell.getType()=="Stone")
			return new Stone();
		if(cell.getType()=="Trees")
			return new Trees();
		if(cell.getType()=="Player")
			return Player.getPlayer();
		if(cell.getType()=="HealthGift")
			return new HealthGift();
		if(cell.getType()=="BulletsGift")
			return new BulletsGift();
		if(cell.getType()=="ArmorGift")
			return new ArmorGift();
		if(cell.getType()=="SmallBomb")
			return new SmallBomb();
		if(cell.getType()=="BigBomb")
			return new BigBomb();
		return null;
	}
}
