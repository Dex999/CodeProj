package csc2a.resistance;

public class MissionEntity {
	private ResistanceMember m= null;
	private int row=0;
	private int col=0;
	
	public MissionEntity(String memID,int r,int c) 
	{
		m=new ResistanceMember(memID,"Jeff","DV",24,"Scout");
   
	}

	
	public int getRow() {
		return row;
	}
  public int getCol() {
	  return col;
  }
  public void setRow(int r) {
	  row=r;
  }
  public void setCol(int c) {
	  col=c;
  }
public ResistanceMember getM() {
	return m;
}
public void setM(ResistanceMember m) {
	this.m = m;
}
  
}
