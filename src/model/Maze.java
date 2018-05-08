package model;

public class Maze {
	private static Maze maze=new Maze();
	Cell[][] matrix;
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
	public void printMatrix()
	{
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<31;j++)
			{
				if(matrix[i][j].getType().equals("Stone"))
					System.out.print("1");
				else if(matrix[i][j].getType().equals("HealthGift"))
					System.out.print("0");
			}
			System.out.println();
		}
	}
}
