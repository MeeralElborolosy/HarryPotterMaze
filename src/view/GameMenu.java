package view;

import java.io.FileInputStream;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GameMenu extends Parent {
    public GameMenu() {
        VBox menu0 = new VBox(10);
        VBox menu1 = new VBox(10);
        HBox bar= new HBox(10); 
        
        menu0.setTranslateX(100);
        menu0.setTranslateY(200);

        menu1.setTranslateX(100);
        menu1.setTranslateY(200);
        
        Pane maze = new Pane();

        final int offset = 400;

        menu1.setTranslateX(offset);

        MenuButton btnResume = new MenuButton("RESUME");
        btnResume.setOnMouseClicked(event -> {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            ft.setFromValue(1);
            ft.setToValue(0);
            ft.setOnFinished(evt -> setVisible(false));
            ft.play();
            GameMenuDemo.root.getChildren().get(3).setVisible(true);
        });


        MenuButton btnOptions = new MenuButton("SOUND");
        btnOptions.setOnMouseClicked(event -> {
        	if(!GameMenuDemo.playing) {
        		new Thread() {
        			public void run() {
        				try(FileInputStream f=new FileInputStream("Harry Potter Theme Song (1).mp3"))
        				{
        					GameMenuDemo.music=new Player(f);
        					GameMenuDemo.music.play();
        				}
        				catch(Exception e)
        				{
        					e.printStackTrace();
        				}
        			}
        			}.start();
        			GameMenuDemo.playing=true;
        	}
        	else
        	{
        		GameMenuDemo.music.close();
        		GameMenuDemo.playing=false;
        	}
            });
        MenuButton btnExit = new MenuButton("EXIT");
        btnExit.setOnMouseClicked(event -> {
        	GameMenuDemo.root.getChildren().get(2).setVisible(true);
        	GameMenuDemo.root.getChildren().get(1).setVisible(false);
        	GameMenuDemo.root.getChildren().get(3).setVisible(false);
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
        
        

        menu0.getChildren().addAll(btnResume, btnOptions, btnExit);
        

        Rectangle bg = new Rectangle(31*25, 32*25);
        bg.setFill(Color.GREY);
        bg.setOpacity(0.4);

        getChildren().addAll(bg, menu0);
    }
}
