package model;

import javafx.scene.paint.Color;
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
        else if(c.getType()=="Player")
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

