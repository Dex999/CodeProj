package csc2a.resistance.ui;
/***
 * @author Trust Mpofu
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import csc2a.resistance.ui.DivisionPanel;//Import of JPanel class.
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
public class ResistanceFrame extends JFrame{ //Class that extends JFrame.
	private JFileChooser fileC;
	private File theFile;
 /***
  * Constructor
  * @param length of the frame
  * @param width of the frame
  */
public	ResistanceFrame(int l,int w){ //Parameterized constructor.
 JFrame rFrame = new JFrame ("Resistance Interface");
 DivisionPanel dPanel = null;
JMenuBar rMenuB =new JMenuBar();
JMenu fileMen =new JMenu("File");
JMenuItem opnItm =new JMenuItem("Open");


/***
 * opnItm ActionMethod
 * Method that handles what happens when one clicks open.
 * 
 */

opnItm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int choice;
				fileC=new JFileChooser();
				choice =fileC.showOpenDialog(null);
				if(choice == JFileChooser.APPROVE_OPTION)
				{
					theFile =fileC.getSelectedFile();
					readFile(theFile);
				}
			}
		});

JMenuItem svItm =new JMenuItem("Save");//Adding save option onto the menu
/***
 * Method that handles what happens when the Save option is clicked.
 */
svItm.addActionListener(new ActionListener()
{

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		PrintWriter txtout=null;
		int choice;
		fileC=new JFileChooser();
		choice =fileC.showSaveDialog(null);
		if(choice == JFileChooser.APPROVE_OPTION)
		{
			
			File aFile=null;
			aFile=new File("NewFile");
			try {
				aFile=fileC.getSelectedFile();
				txtout=new PrintWriter(aFile);
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			}
			
		}
		
	}
	});
//adding of items to the menubar and frame.
fileMen.add(opnItm);
fileMen.add(new JSeparator());
fileMen.add(svItm);
rMenuB.add(fileMen);
rFrame.setJMenuBar(rMenuB);

rFrame.add(dPanel=new DivisionPanel(),BorderLayout.CENTER);
rFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
rFrame.setSize(l,w);
rFrame.setLocationRelativeTo(null);
rFrame.setVisible(true);//Showing the frame.
	}
/***
 * 	Method dealing with the reading from the file.
 * @param file the file to be read.
 */
public void readFile(File file)//Method to deal with file reading. 
{
	
	Scanner txtin=null;
	try {
		txtin= new Scanner(file);
		while(txtin.hasNext()) {
			String line =txtin.nextLine();
			System.out.println(line);
		}
	}catch(FileNotFoundException e) 
	{
		e.printStackTrace();
	}
	finally {
		if(txtin != null)txtin.close();
	}
	}
}
