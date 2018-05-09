package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Maze;
import model.MazePlayer;
import model.Tilee;

public class TempMazePane extends Pane{
	public static final int TILE_SIZE = 20;
	public static final int WIDTH = 31;
	public static final int HEIGHT = 30;
	
	private Tilee[][] board = new Tilee[WIDTH][HEIGHT];

	TempMazePane()
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
		board[MazePlayer.getPlayer().getLastX()][MazePlayer.getPlayer().getLastY()].setFill(Color.MEDIUMAQUAMARINE);
		board[MazePlayer.getPlayer().getxPos()][MazePlayer.getPlayer().getyPos()].setFill(Color.BLUE);
	}
}
