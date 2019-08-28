package csc2a.resistance;
public class ResistanceMember
{
	
private final String memID;
private String memName;
private String memCS;
private int memAge;
private String memRole;




//Constructors
public ResistanceMember()//Parameter-less
	{
		memID ="1001";
		memName = "Pfc Lance";
		memCS = "Lance";
 		memAge =  24;
		memRole = "Recon Spec";
 	}
		
public ResistanceMember(String I,String n, String t,int age,String r) //Parameterized
	{
		memID = I;
		memName = n;
		memCS = t;
		memAge = age;
		memRole = r;
	}
	
//Accessor Methods
public String getID()
{
return memID;
}
public String getName()
{
return memName;
}
public String getCallSign()
{
return memCS;
}
public String getRole()
{
return memRole;
}

//Mutator Methods
public void setRole(String Role)
{
 memRole =Role;
}
public void setN(String n)
{
 memName =n;
}
public void setCS(String cs)
{
 memCS =cs;
}
public void setAge(int a)
{
 memAge =a;
}



	
	
	
	
	
	
	
	
	
}