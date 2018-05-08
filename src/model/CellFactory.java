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
		if(cell.getType()=="EmptyTile")
			return new BigBomb();
		return null;
	}
	public Cell[][] createCells(char cell[][])
	{
		Cell maze[][]=new Cell[31][31];
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<31;j++)
			{
				if(cell[i][j]=='1')
					maze[i][j]=new Stone();
				else if(cell[i][j]=='0')
					maze[i][j]=new EmptyTile();
				else if(cell[i][j]=='2')
					maze[i][j]=new Trees();
				else if(cell[i][j]=='3')
					maze[i][j]=new HealthGift();
				else if(cell[i][j]=='4')
					maze[i][j]=new ArmorGift();
				else if(cell[i][j]=='5')
					maze[i][j]=new BulletsGift();
				else if(cell[i][j]=='6')
					maze[i][j]=new SmallBomb();
				else if(cell[i][j]=='7')
					maze[i][j]=new BigBomb();
				else if(cell[i][j]=='8')
					maze[i][j]=Player.getPlayer();
				else
					System.out.println("different: "+i+" "+j);
			}
		}
		return maze;
	}
}
