package view;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import model.Maze;
import model.Tilee;

public class MazePane extends Pane{

	public static final int TILE_SIZE = 20;
	public static final int WIDTH = 31;
	public static final int HEIGHT = 30;
	
	public MazePane()
	{				
		this.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
	     
	    for (int y = 0; y < HEIGHT; y++) {
	        for (int x = 0; x < WIDTH; x++) {
	            Tilee tile = new Tilee(Maze.getMaze().getMatrix()[y][x], x, y);
	
	            this.getChildren().add(tile);  
        }
    }
	}

}

