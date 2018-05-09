package view;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import model.Maze;
import model.Tilee;

public class MazePane extends Parent{

	public static final int TILE_SIZE = 20;
	public static final int WIDTH = 30;
	public static final int HEIGHT = 31;
	
	private Tilee[][] board = new Tilee[WIDTH][HEIGHT];
	
	//private Group tileGroup = new Group();
	
	this.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
    this.getChildren().addAll(tileGroup, pieceGroup);
     
    for (int y = 0; y < HEIGHT; y++) {
        for (int x = 0; x < WIDTH; x++) {
            Tilee tile = new Tilee(Maze.getMaze().getMatrix()[y][x], x, y);
            board[x][y] = tile;

            this.getChildren().add(tile);  
        }
    }

}
}
