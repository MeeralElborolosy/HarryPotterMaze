package view;

import control.InGame;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	       for(int i=0;i<31;i++)
	       {
	    	   		for(int j=0;j<30;j++)
	    	   		{
	    	   			Tilee tile=new Tilee(Maze.getMatrix()[j][i], i, j);
	    	   			getChildren().add(tile);
	    	   		}
	       }
	       
	       
	   });
	   menu3.getChildren().addAll(btnContinue, btnNewgame, btnHighscore,btnExit);
	 
	   Rectangle bg = new Rectangle(800, 600);
	   bg.setFill(Color.GREY);
	   bg.setOpacity(0);
	
	   getChildren().addAll(bg, menu3);
	   
	   
		}
		
		
		
		
		
		
		
}
