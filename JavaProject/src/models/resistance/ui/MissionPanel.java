package csc2a.resistance.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MissionPanel extends JPanel{
   
	 public void paint(Graphics g)
	 {
		 g.setColor(Color.BLACK);
		 g.fillRect(100, 100, 400,400);
		 for(int i=100;i<=400;i+=100) 
		 {
			 for(int k=100;k<=400;k +=100) 
			 {
				 g.clearRect(i,k,50,50);
			 }
		 }
	 }
	
		 
		 
	 
	
	
	
	
}
