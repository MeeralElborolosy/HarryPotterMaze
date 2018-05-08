package model;

import application.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GameMenuDemo;

public class Tilee  extends Rectangle{
	 

	   
    

    public Tilee(Cell c, int x, int y) {
        setWidth(GameMenuDemo.TILE_SIZE);
        setHeight(GameMenuDemo.TILE_SIZE);

        relocate(x * GameMenuDemo.TILE_SIZE, y * GameMenuDemo.TILE_SIZE);
//import the array and make some ifs;
        if(c.getType()=="Stone")
            setFill(Color.BLACK);
        if(c.getType()=="")
        	  setFill( Color.MEDIUMAQUAMARINE);
        if(c.getType()=="Trees")
             setFill(Color.DARKGREEN);
        if(c.getType()=="Player")
             setFill( Color.MEDIUMAQUAMARINE);
        if(c.getType()=="HealthGift")
             setFill( Color.MEDIUMAQUAMARINE);
        if(c.getType()=="BulletsGift")
             setFill( Color.MEDIUMAQUAMARINE);
        if(c.getType()=="ArmorGift")
             setFill( Color.MEDIUMAQUAMARINE);
        if(c.getType()=="SmallBomb")
             setFill( Color.MEDIUMAQUAMARINE);
        if(c.getType()=="BigBomb")
             setFill( Color.MEDIUMAQUAMARINE);
        
        
        
        
        
        //setFill(wall ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}

