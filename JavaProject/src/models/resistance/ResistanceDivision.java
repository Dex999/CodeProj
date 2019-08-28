//Author 201474396 NT MPOFU
package csc2a.resistance;
import java.util.Scanner;
import csc2a.resistance.ResistanceMember;

/**
* The Resistance Division Class 
* contains the array of Members
*
**/

public class ResistanceDivision
{
	private final int dID;
	private String dName;
	private String dTag;
	private String dCaptain;
	private String dRole;
	private String dMem;
	private ResistanceMember[] members = new ResistanceMember[3];
	public int index =0;
	
	//Constructors
	public ResistanceDivision()//Parameter-less
	{
		dID = 1;
		dName = "First Divi";
		dTag = "FD";
 		dCaptain = "Trafalgar";
		dRole = "Recon";
 		dMem = "Recon";
	}
	public ResistanceDivision(int I,String n, String t,String cp,String r)//Parameterized
	{
		dID = I;
		dName = n;
		dTag = t;
		dCaptain = cp;
		dRole = r;
		
	}
	
	
 //Accessor Methods	
public int getID()
{
return dID;
}

public String getName()
{
return dName;
}

public String getTag()
{
return dTag;
}

public String getRole()
{
return dRole;
}


//Mutator Methods
public void setRole(String Role)
{
 dRole =Role;
}
public void setName(String name)
{
 dName =name;
}
public void setTag(String tag)
{
	dTag =tag;
}
public void setCap(String capt)
{
	dCaptain =capt;
}

//Add Member function
public void addMem()
{
	Scanner input = new Scanner(System.in);
	String nm ="";
	String cs ="";
	String rl ="";
	int age =0;
	for(int i=0;i<3;i++)
	{
		members[i] =new ResistanceMember(); //initializing array object of Members
	}
    
	  for(int i=0;i<3;i++)
	  {
	System.out.println("Enter the Name of the new member");
    nm = input.next();
	  members[i].setN(nm);
	  System.out.println("Enter the Call Sign of the new member");
    cs = input.next();
	  members[i].setCS(cs);
	  System.out.println("Enter the Age of the new member");
    age = input.nextInt();
	  members[i].setAge(age);
	  System.out.println("Enter the Role of the new member");
    rl = input.next();
	  members[i].setRole(rl);
	  }
	  input.close();
}

public void Display() //Display function
{
	System.out.println("Division"+" "+dName);
	System.out.println("The Captain of the division is" + " " + dCaptain);
	System.out.println("The members of this division are");
	for (int i=0;i<3;i++)
	{
		System.out.println(members[i].getName());
	}
}
}