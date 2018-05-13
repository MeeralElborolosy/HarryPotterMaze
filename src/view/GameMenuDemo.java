package view;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;

import control.MazeParser;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import control.*;
import model.*;


public class GameMenuDemo extends Application {
	
		public static Pane root = new Pane();
		public static Player music;
		public static boolean playing;
	
		private GameMenu gameMenu;
	    private MainMenu mainMenu;	
	    private MazePane mazePane;
	    
	    char lastPressed = 0;
 
	    @Override
	    public void start(Stage primaryStage) throws Exception {
     
	        root.setPrefSize(31*25, 32*25);

	        InputStream is = Files.newInputStream(Paths.get("homePage.PNG"));
	        Image img = new Image(is);
	        is.close();
	        MazeParser parser = new MazeParser();
			CellFactory factory = new CellFactory();
			Maze.getMaze().setMatrix(factory.createCells(parser.ParseMatrix()));
			//Maze.getMaze().PrintMatrix();
			
	        ImageView imgView = new ImageView(img);
	        imgView.setFitWidth(31*25);
	        imgView.setFitHeight(32*25);

	        gameMenu = new GameMenu();
	        gameMenu.setVisible(false);
	        
	        mainMenu = new MainMenu();
	        mainMenu.setVisible(true);
	        
	        mazePane = new MazePane();
	        mazePane.setVisible(false);
	        mazePane.reDraw();

	        root.getChildren().addAll(imgView, gameMenu,mainMenu,mazePane);
	        
	        Scene scene = new Scene(root);
	     
	        scene.setOnKeyPressed(event -> {
	            if (event.getCode() == KeyCode.ESCAPE) {
	                //if(Game_State.getState().equals("InGame")) {
	            	if (!gameMenu.isVisible()) {
	                		
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
	                    ft.setFromValue(0);
	                    ft.setToValue(1);
	                    gameMenu.setVisible(true);
	                    mainMenu.setVisible(false);
	                    mazePane.setVisible(false);
	                    ft.play();
	                }
	                else {
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
	                    ft.setFromValue(1);
	                    ft.setToValue(0);
	                    ft.setOnFinished(evt -> gameMenu.setVisible(false));
	                    mainMenu.setVisible(true);
	                    ft.play();
	                }
	            }//}
	            else {
	            if (event.getCode() == KeyCode.RIGHT) {
	            	if(Game_State.getState().toString().equals("InGame"))
	                {	
	            
	            		if(MazePlayer.getPlayer().getxPos()==30) {}
	            		else if(!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()+1].getType().equals("Stone"))&&!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()+1].getType().equals("Trees")))
	            		{
	            			Game_State.getState().Move(1, 0);
	                		mazePane.updateMaze();
	                		Observer.getObserver().updateObservers();
	            		}
	            		
	                }
	            	lastPressed='r';
	            }
	            if (event.getCode() == KeyCode.LEFT) {
	            	if(Game_State.getState().toString().equals("InGame")){
	            		if(MazePlayer.getPlayer().getxPos()==0) {
	            		}
	            		else if(!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()-1].getType().equals("Stone"))&&!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()-1].getType().equals("Trees")))
	            		{
	            			Game_State.getState().Move(-1, 0);
	            			mazePane.updateMaze();
	            			Observer.getObserver().updateObservers();
	            		}
	                		
	                }
	            	lastPressed='l';
	            }
	            if (event.getCode() == KeyCode.UP) {
	            	if(Game_State.getState().toString().equals("InGame"))
	                {
	            		if(!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()-1][MazePlayer.getPlayer().getxPos()].getType().equals("Stone"))&&!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()-1][MazePlayer.getPlayer().getxPos()].getType().equals("Trees")))
	            		{
	            			Game_State.getState().Move(0, -1);
	                		mazePane.updateMaze();
	                		Observer.getObserver().updateObservers();
	            		}
	            		
	                }
	            	lastPressed='u';
	            }
	            if (event.getCode() == KeyCode.DOWN) {
	            	if(Game_State.getState().toString().equals("InGame"))
	                {
	            		if(!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()+1][MazePlayer.getPlayer().getxPos()].getType().equals("Stone"))&&!(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()+1][MazePlayer.getPlayer().getxPos()].getType().equals("Trees")))
	            		{
	            			Game_State.getState().Move(0, 1);
	                		mazePane.updateMaze();
	                		Observer.getObserver().updateObservers();
	            		}
	                }
	            	lastPressed='d';
	            }
	            if (event.getCode() == KeyCode.SPACE) {
	            	if(Game_State.getState().toString().equals("InGame"))
	                {
	            		if((Maze.getMatrix()[MazePlayer.getPlayer().getyPos()+1][MazePlayer.getPlayer().getxPos()].getType().equals("Trees"))
	            				||(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()-1][MazePlayer.getPlayer().getxPos()].getType().equals("Trees"))
	            				||(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()+1].getType().equals("Trees"))
	            				||(Maze.getMatrix()[MazePlayer.getPlayer().getyPos()][MazePlayer.getPlayer().getxPos()-1].getType().equals("Trees")))
	            		{
	            			Game_State.getState().HitSpaceBar(lastPressed);
	                		mazePane.updateMaze();
	                		Observer.getObserver().updateObservers();
	            		}
	            		else
	            		{
	            			if(MazePlayer.getPlayer().getyPos()==Voldemort.getYouKnowWho().getYpos())
	            				Voldemort.getYouKnowWho().hitYouKnowWho();
	            			else if(MazePlayer.getPlayer().getxPos()==Dementor.getSoulEater().getXpos())
	            				Dementor.getSoulEater().hitSoulEater();
	            		}
	                }
	            }
	            if(Game_State.getState().equals("Loser"))
	            {
	            	System.out.println("Khasarty");
	            }
	            }});

	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    public static void main(String[] args) {
	    	MazeParser parser = new MazeParser();
			CellFactory factory = new CellFactory();
			Maze.getMaze().setMatrix(factory.createCells(parser.ParseMatrix()));
			Maze.getMaze().PrintMatrix();
			playing=true;
			new Thread() {
			public void run() {
				try(FileInputStream f=new FileInputStream("Harry Potter Theme Song (1).mp3"))
				{
					music=new Player(f);
					music.play();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			}.start();
			launch(args);
	    }
}















