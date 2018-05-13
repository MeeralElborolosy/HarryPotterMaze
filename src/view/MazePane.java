package view;

import java.util.Timer;

import control.CheckPoints;
import control.MazeParser;
import control.TimeUpdate;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Dementor;
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
	public  Label healthLabel = new Label("Health:");
    public Label armorLabel = new Label("Armor:");
    public static Label lives = new Label("Lives: "+(5-CheckPoints.getLives()));
    public static Label bullets = new Label("Spells: "+MazePlayer.getPlayer().getBullets());
    public static Label timer = new Label("Timer: 0");
    public static Rectangle healthRect = new Rectangle();
    public static Rectangle armorRect = new Rectangle();
    
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
	    healthLabel.setTextFill(Color.GREEN);
	    armorLabel.setTextFill(Color.BLUE);
	    healthRect.setWidth(MazePlayer.getPlayer().getHealth());
	    healthRect.setHeight(10);
	    healthRect.setFill(Color.GREENYELLOW);
	    armorRect.setWidth(MazePlayer.getPlayer().getArmor());
	    armorRect.setHeight(10);
	    armorRect.setFill(Color.AQUA);
	    lives.setTextFill(Color.RED);
	    bullets.setTextFill(Color.BLUEVIOLET);
	    
		 
	   healthLabel.setTranslateY(765);
	   healthRect.setTranslateY(765);		   
	   healthRect.setTranslateX(75);
	   armorRect.setTranslateY(780);
	   armorRect.setTranslateX(75);
	   armorLabel.setTranslateY(780);
	   lives.setTranslateY(765);
	   lives.setTranslateX(175);
	   bullets.setTranslateY(780);
	   bullets.setTranslateX(175);
	   
	   this.getChildren().add(healthLabel);
	   this.getChildren().add(armorLabel);
	   this.getChildren().add(healthRect);
	   this.getChildren().add(armorRect);
	   this.getChildren().add(lives);
	   this.getChildren().add(bullets);
	}
	public void updateMaze()
	{
		Maze.getMatrix()[MazePlayer.getPlayer().getLastY()][MazePlayer.getPlayer().getLastX()]=new EmptyTile();
		Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()]=MazePlayer.getPlayer();
		MazeParser p=new MazeParser();
		p.SaveMatrix();
		reDraw();
	}
	public static void healthRectangle()
	{
		healthRect.setWidth(MazePlayer.getPlayer().getHealth());
	}
	public static void armorRectangle()
	{
		armorRect.setWidth(MazePlayer.getPlayer().getArmor());
	}
	public void reDraw()
	{
	    Voldemort.getYouKnowWho().run();
	    Dementor.getSoulEater().run();
		for (int y = 0; y < HEIGHT; y++) {
	        for (int x = 0; x < WIDTH; x++) {
	            Tilee tile = new Tilee(Maze.getMaze().getMatrix()[y][x], x, y);
	            board[x][y] = tile;
	            this.getChildren().add(tile);    
	        }
	    }
	}
}
