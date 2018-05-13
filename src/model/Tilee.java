package model;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.GameMenuDemo;

public class Tilee  extends Rectangle{
	 
    public Tilee(Cell c, int x, int y) {
        setWidth(30);
        setHeight(31);

        relocate(x *25, y * 25);
    	InputStream is;
    	if(x==Voldemort.getYouKnowWho().x&&y==Voldemort.getYouKnowWho().y&&Voldemort.getYouKnowWho().getYouKnowWhoLife()>0)
    	{
    		try {
				is = Files.newInputStream(Paths.get("sprites/monster2.jpg"));
				Image img = new Image(is);
		        setFill(new ImagePattern(img));
	        	
			} catch (IOException e) {
				System.out.println("eroor in image");
				e.printStackTrace();
    		
    		
    }
    	}
    	else if(x==Dementor.getSoulEater().x&&y==Dementor.getSoulEater().y&&!Dementor.getSoulEater().hit)
    	{
    		try {
				is = Files.newInputStream(Paths.get("sprites/monster1.png"));
				Image img = new Image(is);
		        setFill(new ImagePattern(img));
		        System.out.println("rasamt");
	        	
			} catch (IOException e) {
				System.out.println("eroor in image");
				e.printStackTrace();
    		
    		
    }
    	}
    	else if(c.getType()=="Stone")
            setFill(Color.BLACK);
        else if(c.getType()=="EmptyTile") {
        	if(x==30&&y==28) {
        		
        	 	
            	try {
    				is = Files.newInputStream(Paths.get("sprites/gobletoffire.jpg"));
    				Image img = new Image(is);
    		        setFill(new ImagePattern(img));
    	        	
    			} catch (IOException e) {
    System.out.println("eroor in image");
    				e.printStackTrace();
        		
        		
        }
        		
        	}
        	
        else {	setFill( Color.MEDIUMAQUAMARINE);}
        	
        }
        	  
        else if(c.getType()=="Trees")
             setFill(Color.DARKGREEN);
        else if(c.getType()=="Player")  {
       	//InputStream is;
        	if(MazePlayer.getPlayer().getArmor()>0)
        		DrawArmor();
        	else
        		DrawPlayer();
	      //  Image img = new Image(is);
	        //setFill(new ImagePattern(img));
        	
        	
        	
        	
        	
        }
             //setFill( Color.BLUE);
        else if(c.getType()=="HealthGift") {
        	
         	try {
				is = Files.newInputStream(Paths.get("sprites/Screen Shot 2018-05-11 at 5.30.59 PM.png"));
				Image img = new Image(is);
		        setFill(new ImagePattern(img));
	        	
			} catch (IOException e) {
System.out.println("eroor in image");
				e.printStackTrace();
    		
    		
    }
        	
        	
        	
        }
            // setFill( Color.ANTIQUEWHITE);
        else if(c.getType()=="BulletsGift"){
        		try {
    				is = Files.newInputStream(Paths.get("sprites/bullets.jpg"));
    				Image img = new Image(is);
    		        setFill(new ImagePattern(img));
    	        	
    			} catch (IOException e) {
    System.out.println("eroor in image");
    				e.printStackTrace();
        		
        		
        }}
            // setFill( Color.SEASHELL);
        else  if(c.getType()=="ArmorGift") {
        	
        	
        	
        	
        	try {
				is = Files.newInputStream(Paths.get("sprites/images (1).jpeg"));
				Image img = new Image(is);
		        setFill(new ImagePattern(img));
	        	
			} catch (IOException e) {
System.out.println("eroor in image");
				e.printStackTrace();
    		
    		
    }
        	
        	
        	
        }
             //setFill( Color.RED);
        else if(c.getType()=="SmallBomb") {
        	
        	
        	try {
				is = Files.newInputStream(Paths.get("sprites/smallbomb.jpg"));
				Image img = new Image(is);
		        setFill(new ImagePattern(img));
	        	
			} catch (IOException e) {
System.out.println("eroor in image");
				e.printStackTrace();
    		
    		
    }
        	
        	
        	
        }
            // setFill( Color.ROSYBROWN);
        else if(c.getType()=="BigBomb") {
        	
        	
        	
        	
        	try {
				is = Files.newInputStream(Paths.get("sprites/bigbomb.jpg"));
				Image img = new Image(is);
		        setFill(new ImagePattern(img));
	        	
			} catch (IOException e) {
System.out.println("eroor in image");
				e.printStackTrace();
    		
    		
    }
        }
            // setFill( Color.BLUEVIOLET);
    }
    void DrawPlayer()
    {
    	InputStream is;
    	try {
			is = Files.newInputStream(Paths.get("sprites/Screen Shot 2018-05-12 at 10.43.28 PM.png"));
			Image img = new Image(is);
	        setFill(new ImagePattern(img));
        	
		} catch (IOException e) {
System.out.println("eroor in image");
			e.printStackTrace();
		}
    }
    void DrawArmor()
    {
    	DrawPlayer();
    	InputStream is;
    	try {
			is = Files.newInputStream(Paths.get("sprites/Screen Shot 2018-05-09 at 4.42.52 PM.jpg"));
			Image img = new Image(is);
	        setFill(new ImagePattern(img));
        	
		} catch (IOException e) {
System.out.println("eroor in image");
			e.printStackTrace();
		}
    }
}

