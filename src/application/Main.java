package application;
	
import control.MazeParser;
import javafx.application.Application;
import javafx.stage.Stage;
import model.CellFactory;
import model.Maze;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	//test here
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	public static void main(String[] args) {
		MazeParser parser = new MazeParser();
		CellFactory factory = new CellFactory();
		Maze.getMaze().setMatrix(factory.createCells(parser.ParseMatrix()));
		Maze.getMaze().printMatrix();
		//launch(args);
	
	
	
	
	
	
	
	
	
	
	
	
	
	}*/
}
