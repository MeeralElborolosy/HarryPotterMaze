package control;

import java.io.BufferedReader;
import java.io.FileReader;

public class MazeParser {
	public char[][] ParseMatrix()
	{
		String line=null;
		char[][] cells=new char[31][31];
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
}
