package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import model.Dementor;
import model.Maze;
import model.MazePlayer;
import model.Voldemort;

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
				if(i<30) {
                cells[i]=line.toCharArray();
                i++;
				}
				else
					break;
            }
			int health,bullets,armor;
			String data[]=line.split(" ");
			health=Integer.parseInt(data[0]);
			bullets=Integer.parseInt(data[1]);
			armor=Integer.parseInt(data[2]);
			CheckPoints.setLives(Integer.parseInt(data[3]));
			System.out.println(armor);
			MazePlayer.getPlayer().loadPlayer(health,bullets,armor,Integer.parseInt(data[4]),Integer.parseInt(data[5]));
			Voldemort.getYouKnowWho().LoadVoldemort(Integer.parseInt(data[6]));
			Dementor.getSoulEater().LoadDementor(Integer.parseInt(data[7]));
			Observer.getObserver().updateObservers();
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
					else
						writer.write("-1");
							
				}
				writer.println("");
			}
			writer.println(MazePlayer.getPlayer().getHealth()+" "+MazePlayer.getPlayer().getArmor()+" "+MazePlayer.getPlayer().getBullets()+" "+CheckPoints.getLives()+
					" "+MazePlayer.getPlayer().getLastCx()+" "+MazePlayer.getPlayer().getLastCy()+" "+Voldemort.getYouKnowWho().getYouKnowWhoLife()+" "+Dementor.getSoulEater().getSoulEaterLife());
			writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
