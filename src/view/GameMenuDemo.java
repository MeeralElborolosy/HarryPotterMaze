package view;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

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
import model.CellFactory;
import model.Maze;
import model.Tilee;
import javafx.scene.input.KeyCode;
import control.*;
import model.*;

public class GameMenuDemo extends Application {
	

		private GameMenu gameMenu;
	    private MainMenu mainMenu;	   

	    @Override
	    public void start(Stage primaryStage) throws Exception {

	        Pane root = new Pane();
	        root.setPrefSize(620, 640);

	        InputStream is = Files.newInputStream(Paths.get("homePage.jpeg"));
	        Image img = new Image(is);
	        is.close();

	        ImageView imgView = new ImageView(img);
	        imgView.setFitWidth(620);
	        imgView.setFitHeight(620);

	        gameMenu = new GameMenu();
	       // mainMenu = new GameMenu();
	        gameMenu.setVisible(false);
	        
	        mainMenu = new MainMenu();
	        mainMenu.setVisible(true);

	        root.getChildren().addAll(imgView, gameMenu,mainMenu);
	        
	        Scene scene = new Scene(root);
	        scene.setOnKeyPressed(event -> {
	            if (event.getCode() == KeyCode.ESCAPE) {
	            	if(Game_State.getState().toString().equals("InGame"))
	                {
	                		Game_State.getState().Move(1, 0);
	                }
	                if (!gameMenu.isVisible()) {
	                		
	                    FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
	                    ft.setFromValue(0);
	                    ft.setToValue(1);
	                    gameMenu.setVisible(true);
	                    mainMenu.setVisible(false);
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
	            }
	        });

	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	    public static void main(String[] args) {
	    		MazeParser parser = new MazeParser();
			CellFactory factory = new CellFactory();
			Maze.getMaze().setMatrix(factory.createCells(parser.ParseMatrix()));
			Maze.getMaze().printMatrix();
			new Thread() {
			public void run() {
				try(FileInputStream f=new FileInputStream("Harry Potter Theme Song (1).mp3"))
				{
					new Player(f).play();
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


























