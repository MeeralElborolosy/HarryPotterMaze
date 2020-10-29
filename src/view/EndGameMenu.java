package view;
import control.Game_State;
import control.InGame;
import control.MazeParser;
import control.TimeUpdate;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.CellFactory;
import model.EmptyTile;
import model.Maze;
import model.MazePlayer;
import model.Tilee;

public class EndGameMenu extends Parent{
	public EndGameMenu(){
		VBox menuDead = new VBox(10);
		 menuDead.setTranslateX(100);
		 menuDead.setTranslateY(200);
	MenuButton btnOK = new MenuButton("OK");
	 btnOK.setOnMouseClicked(event -> {
		 Game_State.setState(new InGame());
		 MazeParser parser = new MazeParser();
			CellFactory factory = new CellFactory();
			Maze.getMaze().setMatrix(factory.createCells(parser.ParseMatrix()));
		   this.setVisible(false);
		   ((MazePane) GameMenuDemo.root.getChildren().get(3)).reDraw();
		   Game_State.setState(new InGame());
		   TimeUpdate.getTime().reset();
		   MazePlayer.getPlayer().reset();
	   });
	 MenuButton btnExit = new MenuButton("EXIT");
	 btnExit.setOnMouseClicked(event -> {
	       System.exit(0);
	   });
	 menuDead.getChildren().addAll(btnOK,btnExit);
	   Rectangle bg = new Rectangle(31*25, 32*25);
	   bg.setFill(Color.GREY);
	   bg.setOpacity(0.4);
	
	   getChildren().addAll(bg,menuDead);
	   
}
}
