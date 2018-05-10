package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import model.Maze;

public class MazeParser {
	public char[][] ParseMatrix()
	{
		String line=null;
		char[][] cells=new char[30][31];
		try{
			FileReader f = new FileReader("Maze.txt");
			BufferedReader bf = new BufferedReader(f);
			int i=0;
			while((line = bf.readLine()) != null) {
                cells[i]=line.toCharArray();
                i++;
            }   
            // Always close files.
            bf.close();
            f.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cells;
	}
	public char[][] LoadMatrix()
	{
		String line=null;
		char[][] cells=new char[30][31];
		try{
			FileReader f = new FileReader("savedMaze.txt");
			BufferedReader bf = new BufferedReader(f);
			int i=0;
			while((line = bf.readLine()) != null) {
                cells[i]=line.toCharArray();
                i++;
            }   
            // Always close files.
            bf.close();
            f.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cells;
	}
	public void SaveMatrix()
	{
		try {
			PrintWriter writer = new PrintWriter("savedMaze.txt", "UTF-8");
			for(int i=0;i<30;i++)
			{
				for(int j=0;j<31;j++)
				{
					if(Maze.getMaze().getMatrix()[i][j].getType().equals("EmptyTile"))
						    writer.write("0");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("Stone"))
						    writer.write("1");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("Trees"))
							writer.write("2");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("HealthGift"))
							writer.write("3");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("ArmorGift"))
							writer.write("4");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("BulletsGift"))
							writer.write("5");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("SmallBomb"))
							writer.write("6");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("BigBomb"))
							writer.write("7");
					else if(Maze.getMaze().getMatrix()[i][j].getType().equals("Player"))
							writer.write("8");
					
							
				}
				writer.println("");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
