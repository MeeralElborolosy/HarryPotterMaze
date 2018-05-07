package model;

public class Maze {
	private Maze maze;
	Cell[][] matrix;
	private Maze()
	{
		matrix=new Cell[30][30];
	}
	public Maze getMaze()
	{
		return this.maze;
	}
	public void setMatrix(Cell[][] newMatrix)
	{
		this.matrix=newMatrix;
	}
}
