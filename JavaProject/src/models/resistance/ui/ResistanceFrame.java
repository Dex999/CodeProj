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
import java.util.ArrayList;
import java.util.Scanner;

import csc2a.resistance.DivisionFileHandler;
import csc2a.resistance.MissionEntity;
import csc2a.resistance.ui.DivisionPanel;//Import of JPanel class.
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class ResistanceFrame extends JFrame{

	private JFileChooser fileC;
	private File theFile;
	
	public	ResistanceFrame(int l,int w){ //Parameterized constructor.
		 JFrame rFrame = new JFrame ("Resistance Interface");
		 DivisionPanel dPanel = null;
		 dPanel=new DivisionPanel();
		 MissionPanel mPanel=null;
		 mPanel=new MissionPanel();
		JMenuBar rMenuB =new JMenuBar();
		JMenu fileMen =new JMenu("File");
		JMenuItem opnItm =new JMenuItem("Open");
		JMenu binMenu = new JMenu("Binary Files");
		JMenuItem opnBin =new JMenuItem("Open Bin File");
                 opnBin.addActionListener(new ActionListener()
 				{
 					public void actionPerformed(ActionEvent arg0) 
 					{
 						int choice;
 						fileC=new JFileChooser();
 						choice =fileC.showOpenDialog(null);
 						if(choice == JFileChooser.APPROVE_OPTION)
 						{
 							theFile =fileC.getSelectedFile();
 							ArrayList<MissionEntity> e=null;
 							e=new ArrayList<>();
 							e.addAll(DivisionFileHandler.readMission(theFile));
 							for(MissionEntity r :e) {
 						System.out.println(r.getM().getName());
 							}
 				              }
 						
 						}
 					
 				});

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
		binMenu.add(opnBin);
		rMenuB.add(binMenu);
		rFrame.setJMenuBar(rMenuB);

		rFrame.add(dPanel,BorderLayout.WEST);
		rFrame.add(mPanel,BorderLayout.SOUTH);
		rFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rFrame.setSize(l,w);
		rFrame.setLocationRelativeTo(null);
		rFrame.setVisible(true);//Showing the frame.
			}
	
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
