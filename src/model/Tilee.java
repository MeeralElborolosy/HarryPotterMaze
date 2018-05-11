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

        relocate(x *20, y * 20);
        
        if(c.getType()=="Stone")
            setFill(Color.BLACK);
        else if(c.getType()=="EmptyTile")
        	  setFill( Color.MEDIUMAQUAMARINE);
        else if(c.getType()=="Trees")
             setFill(Color.DARKGREEN);
        else if(c.getType()=="Player")  /*{
       	InputStream is;
			try {
				is = Files.newInputStream(Paths.get("Screen Shot 2018-05-09 at 4.42.52 PM.jpg"));
				Image img = new Image(is);
		        setFill(new ImagePattern(img));
	        	
			} catch (IOException e) {
System.out.println("eroor in image");
				e.printStackTrace();
			}
	      //  Image img = new Image(is);
	        //setFill(new ImagePattern(img));
        	
        	
        	
        	
        	
        }*/
             setFill( Color.BLUE);
        else if(c.getType()=="HealthGift")
             setFill( Color.ANTIQUEWHITE);
        else if(c.getType()=="BulletsGift")
             setFill( Color.SEASHELL);
        else  if(c.getType()=="ArmorGift")
             setFill( Color.RED);
        else if(c.getType()=="SmallBomb")
             setFill( Color.ROSYBROWN);
        else if(c.getType()=="BigBomb")
             setFill( Color.BLUEVIOLET);
    }
}

