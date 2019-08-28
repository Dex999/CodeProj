package csc2a.resistance;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.io.FileNotFoundException;

import csc2a.resistance.ResistanceDivision;
import csc2a.resistance.ResistanceMember;


public class DivisionFileHandler {
	
	/*
	private static final Pattern divisionHeaderPattern = //
			Pattern.compile("[A-Z0-9]{7}\\s[A-Z]+\\s[A-Z]+");
         
	private static final Pattern memberPattern = //
			Pattern.compile("[A-Z0-9]{7}\\s[A-Z][a-z]+\\s[A-Z]+\\-[A-Z]+\\s\\d{2}\\s[A-Z]+");

/*	private static ResistanceMember makeMemberFromString(String memberString)
	{
		StringTokenizer memberTokens = new StringTokenizer(memberString, "\t");
		String ID = memberTokens.nextToken();
		String name = memberTokens.nextToken();
		String callsign = memberTokens.nextToken();
		String ageString = memberTokens.nextToken();
		int age = Integer.parseInt(ageString);
		String roleString = memberTokens.nextToken();
		//E_MEMBER_ROLE role = E_MEMBER_ROLE.valueOf(roleString);
//		ResistanceMember member = new ResistanceMember(ID, name, callsign, age, role);
		return member;
	}

	private static String makeStringFromMember(ResistanceMember member)
	{
		return String.format("%s\t%s\t%s\t%d\t%s", member.getID(), member.getName(),
				member.getCallSign(), member.getAge(), member.getRole());
	}

	/* public static boolean writeDivision(ResistanceDivision division, File divisionFile)
	{
		boolean success = false;

		PrintWriter divOut = null;
		try
		{
			divOut = new PrintWriter(divisionFile);
			divOut.format("%s\t%s\t%s%n", division.getID(), division.getName(), division.getTag());
		//	divOut.println(makeStringFromMember(division.getCaptain()));
			divOut.flush();
			/* for (ResistanceMember member : division.getMembers())
			{
				if (member != null)
				{
					divOut.println(makeStringFromMember(member));
				}
			}
			
			divOut.flush();
		}
		catch (FileNotFoundException fnfex)
		{
			System.err.format("File %s does not exist%", divisionFile.getAbsolutePath());

		}
		finally
		{
			if (divOut != null)
			{
				divOut.close();
				success = true;
			}
		}

		return success;
	}}*/

	/*{
		// Create return reference
		ResistanceDivision division = null;
		// Check if file is valid, if not return null;
		if (!divisionFile.exists()) { return division; }
		// Start processing file
		Scanner scDivision = null;
		try
		{
			// Open file
			scDivision = new Scanner(divisionFile);
			// if file is empty then return
			if (!scDivision.hasNext()) { return division; }
			// Get division header
			String divisionHeader = scDivision.nextLine();
			// Validate with regex
			Matcher divHeaderMatcher = divisionHeaderPattern.matcher(divisionHeader);
			// Regex failed so return null;
			if (!divHeaderMatcher.matches())
			{
				System.err.format("Division Header does not match:\r%s%n", divisionHeader);
				return division;
			}
			// Breakup header
		//	StringTokenizer divHeaderTokenizer = new StringTokenizer(divisionHeader, "\t");
		//	String divID = divHeaderTokenizer.nextToken();
		//	String divName = divHeaderTokenizer.nextToken();
		//	String divTag = divHeaderTokenizer.nextToken();
			// Get captain information
			String captainHeader = scDivision.nextLine();
			// Validate with regex
			Matcher captHeaderMatcher = memberPattern.matcher(captainHeader);
			// Regex failed so return null;
			if (!captHeaderMatcher.matches())
			{
				System.err.format("Captain Header does not match:\r%s%n", captainHeader);
				return division;
			}
	//		ResistanceMember divCapt = makeMemberFromString(captainHeader);
			// At this point we have a valid division and captain so we can create a
			// division instance
			//division = new ResistanceDivision(divID, divName, divTag, divCapt);
			// Read members from file
			while (scDivision.hasNext())
			{
				String memberLine = scDivision.nextLine();
				// Validate with regex
				Matcher memberMatcher = memberPattern.matcher(memberLine);
				// Regex failed so print error
				if (!memberMatcher.matches())
				{
					System.err.format("Member does not match:\r%s%n", memberLine);
				}
				else
				{
					// Create member
				//	ResistanceMember member = makeMemberFromString(memberLine);
					// Add member to division
			//		division.addMember(member);
				}
			}
		}
		catch (FileNotFoundException fnfex)
		{
			System.err.format("File %s does not exist%", divisionFile.getAbsolutePath());
		}
		finally
		{
			// Close file
			if (scDivision != null)
			{
				scDivision.close();
			}
		}

		return division;
	}}
*/

	@SuppressWarnings("finally")
	public static ArrayList<MissionEntity> readMission(File file) 
	{
		ArrayList<MissionEntity> ents=new ArrayList<MissionEntity>();
		BufferedInputStream bis=null;
		DataInputStream dis=null;
		try {
			FileInputStream fis= new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			 dis=new DataInputStream(bis);
			 String DivID = dis.readUTF();
			 String MemID = dis.readUTF();
		     int memRow = dis.readInt();
			 int memCol = dis.readInt();
			 bis.close();
			 ents.add(new MissionEntity(MemID,memRow,memCol));
			 }catch(IOException ex) {
		    	JOptionPane.showMessageDialog(null,"There was error");
		    	
		    	;;
		    	}
		     finally{
		    	 if(dis !=null) {
		    		 try {
		    		 dis.close();}
		    		 catch(IOException e) {
		    			e.printStackTrace();
		    		 }
		    	 }
		    	 return ents;
		}
		}}


