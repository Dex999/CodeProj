package csc2a.resistance.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/***
 * 
 * @author Trust Mpofu
 *
 */
public class DivisionPanel  extends JPanel
{
	    private JLabel rLab;
	    private JLabel capLab;
	    private JLabel memLab;
		private JTextArea rTxt;
		private JTextField cTxt;
		private JTextArea membertxt;
			public DivisionPanel() 
		{
		  	rTxt=new JTextArea(5,20);
		  	rLab=new JLabel("ResistanceInfo");
		  	cTxt =new JTextField(20);
		  	capLab=new JLabel("Captain");
		  	membertxt =new JTextArea(5,20);
		  	memLab =new JLabel("Member Info");
		  	add(rLab);
		  	add(rTxt);
		  	
		  	add(capLab);
		  	add(cTxt);
		  	
		  	add(memLab);
		  	add(membertxt);
		  	
		  	
		  	setBackground(Color.lightGray);
		}
		}

