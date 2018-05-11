package view;

import control.MazeParser;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.EmptyTile;
import model.Maze;
import model.MazePlayer;
import model.Tilee;
import model.Voldemort;

public class MazePane extends Pane{
	public static final int TILE_SIZE = 20;
	public static final int WIDTH = 31;
	public static final int HEIGHT = 30;
	
	private Tilee[][] board = new Tilee[WIDTH][HEIGHT];

	MazePane()
	{				
		this.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
	     
	    for (int y = 0; y < HEIGHT; y++) {
	        for (int x = 0; x < WIDTH; x++) {
	            Tilee tile = new Tilee(Maze.getMaze().getMatrix()[y][x], x, y);
	            board[x][y] = tile;
	            this.getChildren().add(tile);    
	        }
	    }
	}
	public void updateMaze()
	{
		Maze.getMatrix()[MazePlayer.getPlayer().getLastY()][MazePlayer.getPlayer().getLastX()]=new EmptyTile();
		Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()]=MazePlayer.getPlayer();
		MazeParser p=new MazeParser();
		p.SaveMatrix();
		reDraw();
	}
	public void reDraw()
	{
	    for (int y = 0; y < HEIGHT; y++) {
	        for (int x = 0; x < WIDTH; x++) {
	            Tilee tile = new Tilee(Maze.getMaze().getMatrix()[y][x], x, y);
	            board[x][y] = tile;
	            this.getChildren().add(tile);    
	        }
	    }
	    if(MazePlayer.getPlayer().getxPos()==Voldemort.getYouKnowWho().getXpos()
	    		&&MazePlayer.getPlayer().getyPos()==Voldemort.getYouKnowWho().getYpos())
	    {
	    	System.out.println("HIIT");
	    	MazePlayer.getPlayer().decreaseHealth(30);
	    }
	}
}
