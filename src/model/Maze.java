package model;

public class Maze {
	private static Maze maze=new Maze();
	private static Cell[][] matrix;
	private Maze()
	{
		matrix=new Cell[30][31];
	}
	public static Maze getMaze()
	{
		return maze;
	}
	public void setMatrix(Cell[][] newMatrix)
	{
		for(int i=0;i<30;i++)
			for(int j=0;j<31;j++)
				matrix[i][j]=newMatrix[i][j];
	}
	
	public static Cell[][] getMatrix()
	{
		return  matrix; 
	}
	
	
	public void PrintMatrix()
	{
			for(int i=0;i<30;i++)
			{
				for(int j=0;j<31;j++)
				{
					if(Maze.getMaze().getMatrix()[i][j].getType().equals("EmptyTile"))
						System.out.print("0");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("Stone"))
						System.out.print("1");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("Trees"))
						System.out.print("2");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("HealthGift"))
						System.out.print("3");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("ArmorGift"))
						System.out.print("4");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("BulletsGift"))
						System.out.print("5");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("SmallBomb"))
						System.out.print("6");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("BigBomb"))
						System.out.print("7");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("Player"))
						System.out.print("8");			
				}
				System.out.println("");
			}
	}
}
