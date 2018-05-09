package view;
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
public class GameMenuDemo extends Application {






	private GameMenu gameMenu;
	   private MainMenu mainMenu;
	  // private GameMenu mainMenu;
	   

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

	    private class MainMenu extends Parent{
	    	public MainMenu() {
	    	 VBox menu3 = new VBox(10);
	    	 
	    	   menu3.setTranslateX(100);
	       menu3.setTranslateY(200);
	     //  final int offset2 = 400;
	       //menu3.setTranslateX(offset2);
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
	   
	    
	    
	    
	    private class GameMenu extends Parent {
	        public GameMenu() {
	            VBox menu0 = new VBox(10);
	            VBox menu1 = new VBox(10);
	            HBox bar= new HBox(10); 
	            
	            menu0.setTranslateX(100);
	            menu0.setTranslateY(200);

	            menu1.setTranslateX(100);
	            menu1.setTranslateY(200);

	            final int offset = 400;

	            menu1.setTranslateX(offset);

	            MenuButton btnResume = new MenuButton("RESUME");
	            btnResume.setOnMouseClicked(event -> {
	                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
	                ft.setFromValue(1);
	                ft.setToValue(0);
	                ft.setOnFinished(evt -> setVisible(false));
	                ft.play();
	            });


	            MenuButton btnOptions = new MenuButton("OPTIONS");
	            btnOptions.setOnMouseClicked(event -> {
	                getChildren().add(menu1);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
	                tt.setToX(menu0.getTranslateX() - offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
	                tt1.setToX(menu0.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu0);
	                });
	            });

	            MenuButton btnExit = new MenuButton("EXIT");
	            btnExit.setOnMouseClicked(event -> {
	                System.exit(0);
	            });

	            MenuButton btnBack = new MenuButton("BACK");
	            btnBack.setOnMouseClicked(event -> {
	                getChildren().add(menu0);

	                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
	                tt.setToX(menu1.getTranslateX() + offset);

	                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
	                tt1.setToX(menu1.getTranslateX());

	                tt.play();
	                tt1.play();

	                tt.setOnFinished(evt -> {
	                    getChildren().remove(menu1);
	                });
	            });

	            MenuButton btnSound = new MenuButton("SOUND");
	            MenuButton btnSave = new MenuButton("SAVE");
	            MenuButton btnLoad = new MenuButton("LOAD");
	            
	            

	            menu0.getChildren().addAll(btnResume, btnOptions, btnExit);
	            menu1.getChildren().addAll(btnBack, btnSound, btnSave,btnLoad);
	            

	            Rectangle bg = new Rectangle(620, 620);
	            bg.setFill(Color.GREY);
	            bg.setOpacity(0.4);

	            getChildren().addAll(bg, menu0);
	        }
	    }

	    private static class MenuButton extends StackPane {
	        private Text text;

	        public MenuButton(String name) {
	            text = new Text(name);
	            text.setFont(text.getFont().font(20));
	            text.setFill(Color.WHITE);

	            Rectangle bg = new Rectangle(250, 30);
	            bg.setOpacity(0.3);
	            bg.setFill(Color.BLACK);
	            bg.setEffect(new GaussianBlur(3.5));

	            setAlignment(Pos.CENTER_LEFT);
	            setRotate(-0.5);
	            getChildren().addAll(bg, text);

	            setOnMouseEntered(event -> {
	                bg.setTranslateX(10);
	                text.setTranslateX(10);
	                bg.setFill(Color.WHITE);
	                text.setFill(Color.BLACK);
	            });

	            setOnMouseExited(event -> {
	                bg.setTranslateX(0);
	                text.setTranslateX(0);
	                bg.setFill(Color.BLACK);
	                text.setFill(Color.WHITE);
	            });

	            DropShadow drop = new DropShadow(50, Color.WHITE);
	            drop.setInput(new Glow());

	            setOnMousePressed(event -> setEffect(drop));
	            setOnMouseReleased(event -> setEffect(null));
	        }
	    }
	    public static final int TILE_SIZE = 20;
	    public static final int WIDTH = 30;
	    public static final int HEIGHT = 30;

	    private Tilee[][] board = new Tilee[WIDTH][HEIGHT];

	    private Group tileGroup = new Group();
	    private Group pieceGroup = new Group();

	    private Parent createContent() {
	        Pane root = new Pane();
	        root.setPrefSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
	        root.getChildren().addAll(tileGroup, pieceGroup);
             
	        for (int y = 0; y < HEIGHT; y++) {
	            for (int x = 0; x < WIDTH; x++) {
	                Tilee tile = new Tilee(Maze.getMaze().getMatrix()[y][x], x, y);
	                board[x][y] = tile;

	                tileGroup.getChildren().add(tile);

	               

	               
	            }
	        }

	        return root;
	    }


	    public static void main(String[] args) {
	        
	    	MazeParser parser = new MazeParser();
			CellFactory factory = new CellFactory();
			Maze.getMaze().setMatrix(factory.createCells(parser.ParseMatrix()));
			Maze.getMaze().printMatrix();
	    	launch(args);
	   
	    
	    
	    }
	








}


























