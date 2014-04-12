/*
Author: Kathryn Youngberg		Date: October 28, 2012
*Class: 	COP 2551
*Lab: 	Lab 7 
*Programming Exercise 2.14 Page 110  Filename: Snowman.java
*Purpose: Draws a snowman.
*/

import javax.swing.JApplet;
import java.awt.*;

public class Snowman extends JApplet
{
   public void paint (Graphics page)
   {
      final int MID = 170;
      final int TOP = 50;

      setBackground (Color.white);
		
		page.setColor (Color.cyan);
  		page.fillRect (0, 0, 300, 200);
		
      page.setColor (Color.blue);
      page.fillRect (0, 175, 300, 50);  // ground

      page.setColor (Color.yellow);
		page.fillArc (260, -40, 80, 80, 180, 90);  //sun

      page.setColor (Color.white);
      page.fillOval (MID-20, TOP, 40, 40);      // head
      page.fillOval (MID-35, TOP+35, 70, 50);   // upper torso
      page.fillOval (MID-50, TOP+80, 100, 60);  // lower torso
  		
		page.setColor (Color.red);
      page.fillOval (MID-3, TOP+45, 7, 7);   // button one
      page.fillOval (MID-3, TOP+59, 7, 7);	//button two	
    
      page.setColor (Color.black);
      page.fillOval (MID-10, TOP+10, 5, 5);   // left eye
      page.fillOval (MID+5, TOP+10, 5, 5);    // right eye

      page.drawArc (MID-10, TOP+20, 20, 10, 10, 160);   // unhappy snowman
				
      page.drawLine (MID-25, TOP+60, MID-50, TOP+40);  // left arm
      page.drawLine (MID+25, TOP+60, MID+55, TOP+60);  // right arm

      page.drawLine (MID-20, TOP+5, MID+20, TOP+5);  // brim of hat
      page.fillRect (MID-15, TOP-20, 30, 25);        // top of hat
		
		page.drawString ("Kathryn Youngberg", 0,12);  //name
   }}
/*    
		page.setColor (Color.red);
      page.fillOval (MID-3, TOP+45, 7, 7);   // button one
      page.fillOval (MID-3, TOP+59, 7, 7);	//button two
		
		page.drawArc (MID-10, TOP+20, 20, 10, 10, 160);   // frown
		
		page.fillArc (260, -40, 80, 80, 180, 90);  // sun

   	page.drawString ("Kathryn Youngberg", 0,12);   //name

		final int MID = 170;   //move snowman right
*/

		 