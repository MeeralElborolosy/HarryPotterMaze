package view;

import control.Game_State;
import control.InGame;
import control.MazeParser;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.CellFactory;
import model.Maze;
import model.Tilee;

public class MainMenu extends Parent{
	public MainMenu() {
	   VBox menu3 = new VBox(10);
	 
	   menu3.setTranslateX(100);
	   menu3.setTranslateY(200);
	
	   MenuButton btnContinue = new MenuButton("CONTINUE");
	   MenuButton btnNewgame = new MenuButton("NEW GAME");
	   
	   MenuButton btnHighscore = new MenuButton("HIGHSCORES");
	   MenuButton btnExit = new MenuButton("EXIT");
	   btnExit.setOnMouseClicked(event -> {
	       System.exit(0);
	   });
	   btnNewgame.setOnMouseClicked(event -> {
		   MazeParser parser = new MazeParser();
			CellFactory factory = new CellFactory();
			Maze.getMaze().setMatrix(factory.createCells(parser.ParseMatrix()));
		   GameMenuDemo.root.getChildren().get(4).setVisible(true);
		   Game_State.setState(new InGame());
	   });
	   btnContinue.setOnMouseClicked(event -> {
		   MazeParser parser = new MazeParser();
			CellFactory factory = new CellFactory();
			Maze.getMaze().setMatrix(factory.createCells(parser.LoadMatrix()));
		   GameMenuDemo.root.getChildren().get(4).setVisible(true);
		   Game_State.setState(new InGame());
	   });
	   menu3.getChildren().addAll(btnContinue, btnNewgame, btnHighscore,btnExit);
	 
	   Rectangle bg = new Rectangle(800, 600);
	   bg.setFill(Color.GREY);
	   bg.setOpacity(0);
	
	   getChildren().addAll(bg, menu3);
	   
	   
		}
		
		
		
		
		
		
}
