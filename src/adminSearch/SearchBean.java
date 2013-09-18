package adminSearch;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import loginPackage.ConnectionManager;
import java.io.IOException;
import java.math.BigInteger;

import java.io.*;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class SearchBean {
	static Connection currentCon = null;

	ResultSet rs_cnt = null,rs_name=null,rs_sname=null;
	Statement stmt = null;
	String start_date="",end_date="",nameQuery="";
	String [] type1_flag=new String [6];
	String [] type_flag=new String [6];

	String [] fname=new String[10];
	String [] lname=new String[10];
	String [] title=new String[10];
	String [] dept=new String[10];
	String nat_int="";
	String key_speaker="";

	
	int count[]=new int[10];
	int c1=0,c=0,k=0,l=0;
	
	ResultSet rs[]=new ResultSet[12];

	XWPFDocument doc = new XWPFDocument();

	public void getType(String type)
	{
		
		if(type!=null)
		{
		type1_flag[k]=type;
		k++;
		}
	}
	
	
	public void getValues(String[] tables)
	{
		for(int i=0;i<tables.length;i++)
		{	
			System.out.println(tables[i]);
			
		}				

		String [] searchQuery=new String [10] ;

		for(int i =0 ; i<tables.length;i++)
		{

			
		if(tables[i].equals("Organized"))
			{
				searchQuery[i]="select * from " + tables[i] +  " where start_date>='"+start_date+"' and start_date<='"+end_date+"' and verified=1";// and start_date=2012-12-13";
				type_flag[i]=type1_flag[0];
			}
			else if (tables[i].equals("Conducted"))
			{
				searchQuery[i]="select * from " + tables[i] +  " where start_date>='"+start_date+"' and start_date<='"+end_date+"' and verified=1";// and start_date=2012-12-13";
				type_flag[i]=type1_flag[1];
			}
			else if (tables[i].equals("Attended"))
			{
				searchQuery[i]="select * from " + tables[i] +  " where start_date>='"+start_date+"' and start_date<='"+end_date+"' and verified=1";// and start_date=2012-12-13";
				type_flag[i]=type1_flag[2];
			}
			else if (tables[i].equals("Publication"))
			{
				searchQuery[i]="select * from " + tables[i] +  " where date>='"+start_date+"' and date<='"+end_date+"' and verified=1";// and start_date=2012-12-13";
				type_flag[i]=type1_flag[3];
			}
			else if (tables[i].equals("Stud_achieve"))
			{
				searchQuery[i]="select * from " + tables[i] +  " where date>='"+start_date+"' and date<='"+end_date+"' and verified=1";// and start_date=2012-12-13";
				type_flag[i]=type1_flag[4];
			}
			else if (tables[i].equals("Project"))
			{
				searchQuery[i]="select * from " + tables[i] +  " where date>='"+start_date+"' and date<='"+end_date+"' and verified=1";// and start_date=2012-12-13";
				type_flag[i]=type1_flag[5];
				
			}

		}

		String str=null,str1=null, cntQuery;
		 
		try
		{
			currentCon = ConnectionManager.getConnection();
			stmt=currentCon.createStatement();
			
			
		
			
			for(int i=0;i<tables.length;i++)
			{
				c=0;
				c1=0;
			
				cntQuery="select count(*) from " +tables[i] + " where verified =1";
				rs_cnt=stmt.executeQuery(cntQuery);
				while(rs_cnt.next())
				{
					c1=rs_cnt.getInt(1);
				}
				
				count[i]=c1;
				//System.out.println(count[i]);

				
				
				XWPFParagraph p1 = doc.createParagraph();
				XWPFRun r1 = p1.createRun();
				r1.setText(tables[i]);
				r1.setBold(true);
				r1.setFontFamily("Calibri");
				r1.setFontSize(18);
		
				
				
				rs[i]=stmt.executeQuery(searchQuery[i]);

				if(type_flag[i].equals("Numbering"))
				{
				while(rs[i].next())
				{
					c++;

					
						try
						{
				
						XWPFParagraph p0 = doc.createParagraph();
						XWPFRun r0 = p0.createRun();
						
					
						if(tables[i].equals("Organized"))
						{
							
							if(rs[i].getString("type").equals("FDP"))	
							{
								r0.setText((c)+". " +getfullname(rs[i].getString("user_iduser"))[0]  + "  "+getfullname(rs[i].getString("user_iduser"))[1] + " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  " + rs[i].getString(2) +"  has organized a FDP on " +rs[i].getString(8)+ " in association with  " +rs[i].getString(6)+" held on " + changedate(rs[i].getString(4))
										+". The title sponsors of the event were  "+ rs[i].getString(7)+ ". The number of participants attending the event were " + rs[i].getString(9)+".The speaker was "+rs[i].getString(11)+"\n\n");
								
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
							}
							else if (rs[i].getString("type").equals("Seminar"))
							{

								r0.setText((c)+". " +getfullname(rs[i].getString("user_iduser"))[0]  + "  "+getfullname(rs[i].getString("user_iduser"))[1] + " of  " + getfullname(rs[i].getString("user_iduser"))[2]  +"  has organized a seminar on "+ rs[i].getString(2)+ " , "+rs[i].getString(8)+ " in association with  " +rs[i].getString(6)+" held on " + changedate(rs[i].getString(4))
										+". The title sponsors of the event were  "+ rs[i].getString(7)+ ". The number of participants attending the event were " + rs[i].getString(9)+".The speaker was "+rs[i].getString(11)+"\n\n");
								
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
								
							}
							else if(rs[i].getString("type").equals("Workshop"))
							{
								r0.setText((c)+". " +getfullname(rs[i].getString("user_iduser"))[0]  + "  "+getfullname(rs[i].getString("user_iduser"))[1] + " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  " + rs[i].getString(2) +"  has organized a workshop on "+ rs[i].getString(2)+ " , "+rs[i].getString(8)+ " in association with  " +rs[i].getString(6)+" held on " + changedate(rs[i].getString(4))
										+". The title sponsors of the event were  "+ rs[i].getString(7)+ ". The number of participants attending the event were " + rs[i].getString(9)+".The speaker was "+rs[i].getString(11)+"\n\n");
							
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
								
							}
						}
						
						if(tables[i].equals("Conducted"))
						{	
							if(rs[i].getString(11).equals("1"))
							{
								if(rs[i].getString("type").equals("FDP"))	
								{
								r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +  " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  "  +"  has conducted a FDP on "+ rs[i].getString(2)+ " , "
										+rs[i].getString(8)+ " in association with  " +rs[i].getString(6)+" as a keynote speaker "+" held on "  + changedate(rs[i].getString(4))+ " .The event witnessed "+ rs[i].getString(9)+" particpants." );
								
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
								}
								
								else if (rs[i].getString("type").equals("Seminar"))
									{
									r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +  " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  "  +"  has conducted a seminar on "+ rs[i].getString(2)+ " , "+rs[i].getString(8)+ "in association with  " +rs[i].getString(6)+"as a keynote speaker "+" held on "  + changedate(rs[i].getString(4))+  " .The event witnessed "+ rs[i].getString(9)+" particpants.");
									XWPFParagraph p2 = doc.createParagraph();
									XWPFRun r2 = p2.createRun();
									
									r2.setText(" ");
									
									}
								
								else if(rs[i].getString("type").equals("Workshop"))
									{
									r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +  " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  "  +"  has conducted a workshop on "+ rs[i].getString(2)+ " , "+rs[i].getString(8)+ " in association with  " +rs[i].getString(6)+"as a keynote speaker "+" held on "  + changedate(rs[i].getString(4))+  " .The event witnessed "+ rs[i].getString(9)+" particpants.");
									
									XWPFParagraph p2 = doc.createParagraph();
									XWPFRun r2 = p2.createRun();
									
									r2.setText(" ");
									
									}
							
							}
							else 
							{
								

								if(rs[i].getString("type").equals("FDP"))	
							{
							r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +  " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  "  +"  has conducted a FDP on "+ rs[i].getString(2)+ " , "
									+rs[i].getString(8)+ " in association with  " +rs[i].getString(6)+" held on "  + changedate(rs[i].getString(4))+ " .The event witnessed "+ rs[i].getString(9)+" particpants." );
							
							XWPFParagraph p2 = doc.createParagraph();
							XWPFRun r2 = p2.createRun();
							
							r2.setText(" ");
							
							}
							
							else if (rs[i].getString("type").equals("Seminar"))
								{
								r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +  " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  "  +"  has conducted a seminar on "+ rs[i].getString(2)+ " , "+rs[i].getString(8)+ "in association with  " +rs[i].getString(6)+"as a keynote speaker "+" held on "  + changedate(rs[i].getString(4))+  " .The event witnessed "+ rs[i].getString(9)+" particpants.");
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
								}
							
							else if(rs[i].getString("type").equals("Workshop"))
								{
								r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +  " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  "  +"  has conducted a workshop on "+ rs[i].getString(2)+ " , "+rs[i].getString(8)+ " in association with  " +rs[i].getString(6)+" held on "  + changedate(rs[i].getString(4))+  " .The event witnessed "+ rs[i].getString(9)+" particpants.");
								
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
								}
							
							
						}
					}
						if(tables[i].equals("Attended"))
						{
							if(rs[i].getString("type").equals("FDP"))	
							{
								r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +   " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  " +" department  has attended a FDP on " + rs[i].getString(2) + " in association with  " +rs[i].getString(7)+ " held on " + changedate(rs[i].getString(4)));
							
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
							}
							
							else if (rs[i].getString("type").equals("Seminar"))
								{
								r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +   " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  " +" department  has attended a seminar on " + rs[i].getString(2)+ " in association with  " +rs[i].getString(7)+ " held on " + changedate(rs[i].getString(4)));
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
								}
							
							else if(rs[i].getString("type").equals("Workshop"))
								{
								r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] +   " of  " + getfullname(rs[i].getString("user_iduser"))[2] + "  " + " department has attended a workshop on "+ rs[i].getString(2)+ " in association with  " +rs[i].getString(7)+" held on "  + changedate(rs[i].getString(4)));
								XWPFParagraph p2 = doc.createParagraph();
								XWPFRun r2 = p2.createRun();
								
								r2.setText(" ");
								
								}
							
						}
						if(tables[i].equals("Publication"))
						{
							if(rs[i].getString(11).equals("1"))
							{
								 nat_int="international";
							}
							else 
							{
								nat_int="national";

							}
							
						r0.setText((c)+". " + getfullname(rs[i].getString("user_iduser"))[0] + "  "+ getfullname(rs[i].getString("user_iduser"))[1] + " of " + getfullname(rs[i].getString("user_iduser"))[2] + "  " +" department has published a paper on "+rs[i].getString(2) +" in "+ rs[i].getString(4) +" " +rs[i].getString(3)
								+" issue "+rs[i].getString(6) +" ,volume "+rs[i].getString(7)+" page nos.  "+rs[i].getString(8) +" and the authors are "+rs[i].getString(9)+" on "  + changedate(rs[i].getString(5))+" The scope of the paper was " + nat_int);
						
						XWPFParagraph p2 = doc.createParagraph();
						XWPFRun r2 = p2.createRun();
						
						r2.setText(" ");
						}
					
						
						//
						
						
						if(tables[i].equals("Stud_achieve"))
						{
							
						r0.setText((c)+". " + getstud_details(rs[i].getString("student_idstudent"))[0] + " roll no  "+ getstud_details(rs[i].getString("student_idstudent"))[1] + " alongwith " +  rs[i].getString("co_participants") + "of " + getstud_details(rs[i].getString("student_idstudent"))[2] + "  " +" department have participated in " +rs[i].getString("event_name") +" held at " + rs[i].getString("place")  +" . The team secured  "+rs[i].getString("position") +" position in "+ rs[i].getString("type") +" ." );
						
						XWPFParagraph p2 = doc.createParagraph();
						XWPFRun r2 = p2.createRun();
						
						r2.setText(" ");
						}
					
						
						if(tables[i].equals("Project"))
						{
							
						r0.setText((c)+". " + getstud_details(rs[i].getString("student_idstudent"))[0] + " roll no  "+ getstud_details(rs[i].getString("student_idstudent"))[1] + " alongwith " +  rs[i].getString("co_participants") + " of " + getstud_details(rs[i].getString("student_idstudent"))[2] + "  " +" department have submitted a project in " +rs[i].getString("title") +" in the domain of " + rs[i].getString("domain") + " at " +rs[i].getString("event_name") + "  held in " + rs[i].getString("place")  +" . The team secured  "+rs[i].getString("position") +" position. The basic description is as follows : " + rs[i].getString("description") +" ." );
						
						XWPFParagraph p2 = doc.createParagraph();
						XWPFRun r2 = p2.createRun();
						
						r2.setText(" ");
						}
					

						
						
						
						
						//
						
						r0.setBold(false);
						r0.setFontFamily("Times New Roman");
						r0.setFontSize(12);
			
					
				}
				catch(NullPointerException ex)
				{
					ex.printStackTrace();
					System.out.println(ex);
				}
				
					
			}
		
				
				}
				
				else
				{
					XWPFTable t0 = null;
					
				if(tables[i].equals("Conducted"))	
				{
				 t0 = doc.createTable(count[i]+1,10);
				 t0.getRow(0).getCell(0).setText("Name");
				 t0.getRow(0).getCell(1).setText("Name of Event");
				 t0.getRow(0).getCell(2).setText("Type");
				 t0.getRow(0).getCell(3).setText("Start Date");
				 t0.getRow(0).getCell(4).setText("No. of days");
				 t0.getRow(0).getCell(5).setText("Association");
				 t0.getRow(0).getCell(6).setText("Sponsor");
				 t0.getRow(0).getCell(7).setText("Place");
				 t0.getRow(0).getCell(8).setText("No. of Particpants");
				 t0.getRow(0).getCell(9).setText("Keynote");
				 
				}
				
				if(tables[i].equals("Attended"))	
				{
				 t0 = doc.createTable(count[i]+1,6);
				 t0.getRow(0).getCell(0).setText("Name");
				 t0.getRow(0).getCell(1).setText("Name of Event");
				 t0.getRow(0).getCell(2).setText("Type");
				 t0.getRow(0).getCell(3).setText("Start Date");
				 t0.getRow(0).getCell(4).setText("No. of days");
				 t0.getRow(0).getCell(5).setText("Association");
				 
				}
				
				if(tables[i].equals("Organized"))	
				{
				 t0 = doc.createTable(count[i]+1,10);
				 t0.getRow(0).getCell(0).setText("Name");
				 t0.getRow(0).getCell(1).setText("Name of Event");
				 t0.getRow(0).getCell(2).setText("Type");
				 t0.getRow(0).getCell(3).setText("Start Date");
				 t0.getRow(0).getCell(4).setText("No. of days");
				 t0.getRow(0).getCell(5).setText("Association");
				 t0.getRow(0).getCell(6).setText("Sponsor");
				 t0.getRow(0).getCell(7).setText("Place");
				 t0.getRow(0).getCell(8).setText("No. of Particpants");
				 t0.getRow(0).getCell(9).setText("Speaker");
				}
				
				if(tables[i].equals("Stud_achieve"))	
				{
				 t0 = doc.createTable(count[i]+1,7);
				 t0.getRow(0).getCell(0).setText("Name");
				 t0.getRow(0).getCell(1).setText("Co-Participant");
				 t0.getRow(0).getCell(2).setText("Event");
				 t0.getRow(0).getCell(3).setText("Place");
				 t0.getRow(0).getCell(4).setText("Date");
				 t0.getRow(0).getCell(5).setText("Position");
				 t0.getRow(0).getCell(6).setText("Type");
				 }
			
				
				if(tables[i].equals("Publication"))	
				{
				 t0 = doc.createTable(count[i]+1,10);
				 t0.getRow(0).getCell(0).setText("Name");
				 t0.getRow(0).getCell(1).setText("Title");
				 t0.getRow(0).getCell(2).setText("Type");
				 t0.getRow(0).getCell(3).setText("Published In");
				 t0.getRow(0).getCell(4).setText("Date");
				 t0.getRow(0).getCell(5).setText("Volume");
				 t0.getRow(0).getCell(6).setText("Issue");
				 t0.getRow(0).getCell(7).setText("Page No.");
				 t0.getRow(0).getCell(8).setText("Author");
				 t0.getRow(0).getCell(9).setText("Scope");
				}
				
				if(tables[i].equals("Project"))	
				{
				 t0 = doc.createTable(count[i]+1,9);
				 t0.getRow(0).getCell(0).setText("Name");
				 t0.getRow(0).getCell(1).setText("Co-Participant");
				 t0.getRow(0).getCell(2).setText("Title");
				 t0.getRow(0).getCell(3).setText("Domain");
				 t0.getRow(0).getCell(4).setText("Description");
				 t0.getRow(0).getCell(5).setText("Event");
				 t0.getRow(0).getCell(6).setText("Place");
				 t0.getRow(0).getCell(7).setText("Date");
				 t0.getRow(0).getCell(8).setText("Position");
				 
				 }
			
				
				
				
				
				
				
				c=1;
				while(rs[i].next())
				{
					String date;
					
					if(tables[i].equals("Publication"))	
					 date= rs[i].getString(5);
					
					else if(tables[i].equals("Stud_achieve"))
					{
						 date= rs[i].getString(3);
					}	 
					else if(tables[i].equals("Project"))
					{
						 date= rs[i].getString(7);
					}	
					 
					 else
					date= rs[i].getString(4);
					
					SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
							
					try
					{
						date = myFormat.format(fromUser.parse(date));
					}
					catch(ParseException e)
					{
						e.printStackTrace();
					}
					
					try
				    {
						if(tables[i].equals("Attended"))	
						{
						t0.getRow(c).getCell(0).setText(getfullname(rs[i].getString("user_iduser"))[0]+". "+ getfullname(rs[i].getString("user_iduser"))[1]);
						t0.getRow(c).getCell(1).setText(rs[i].getString(2));
						t0.getRow(c).getCell(2).setText(rs[i].getString(3));
						t0.getRow(c).getCell(3).setText(date);
						t0.getRow(c).getCell(4).setText(rs[i].getString(5));
						t0.getRow(c).getCell(5).setText(rs[i].getString(7));
						}
						
						if(tables[i].equals("Organized"))	
						{
							t0.getRow(c).getCell(0).setText(getfullname(rs[i].getString("user_iduser"))[0]+". "+ getfullname(rs[i].getString("user_iduser"))[1]);
							t0.getRow(c).getCell(1).setText(rs[i].getString(2));
							t0.getRow(c).getCell(2).setText(rs[i].getString(3));
							t0.getRow(c).getCell(3).setText(date);
							t0.getRow(c).getCell(4).setText(rs[i].getString(5));
							t0.getRow(c).getCell(5).setText(rs[i].getString(6));
							t0.getRow(c).getCell(6).setText(rs[i].getString(7));
							t0.getRow(c).getCell(7).setText(rs[i].getString(8));
							t0.getRow(c).getCell(8).setText(rs[i].getString(9));
							t0.getRow(c).getCell(9).setText(rs[i].getString(11));
							//t0.getRow(c).getCell(9).setText("Yes");
							
						}
						 
						if(tables[i].equals("Conducted"))	
						{
						
							t0.getRow(c).getCell(0).setText(getfullname(rs[i].getString("user_iduser"))[0]+". "+ getfullname(rs[i].getString("user_iduser"))[1]);
							t0.getRow(c).getCell(1).setText(rs[i].getString(2));
							t0.getRow(c).getCell(2).setText(rs[i].getString(3));
							t0.getRow(c).getCell(3).setText(date);
							t0.getRow(c).getCell(4).setText(rs[i].getString(5));
							t0.getRow(c).getCell(5).setText(rs[i].getString(6));
							t0.getRow(c).getCell(6).setText(rs[i].getString(7));
							t0.getRow(c).getCell(7).setText(rs[i].getString(8));
							t0.getRow(c).getCell(8).setText(rs[i].getString(9));
							
							if(rs[i].getString(11).equals("1"))
							{
								 key_speaker="yes";
							}
							else
							{
								key_speaker="no";
							}
							
							
							
							t0.getRow(c).getCell(9).setText(key_speaker);
							
						}
						
						if(tables[i].equals("Stud_achieve"))	
						{
						
						 t0.getRow(c).getCell(0).setText(getstud_details(rs[i].getString("student_idstudent"))[0]);
						 t0.getRow(c).getCell(1).setText(rs[i].getString("co_participants"));
						 t0.getRow(c).getCell(2).setText(rs[i].getString("event_name"));
						 t0.getRow(c).getCell(3).setText(rs[i].getString("place"));
						 t0.getRow(c).getCell(4).setText(date);
						t0.getRow(c).getCell(5).setText(rs[i].getString("position"));
						 t0.getRow(c).getCell(6).setText(rs[i].getString("type"));
						  
						}
						
						
						if(tables[i].equals("Project"))	
						{
							 t0.getRow(c).getCell(0).setText(getstud_details(rs[i].getString("student_idstudent"))[0]);
							 t0.getRow(c).getCell(1).setText(rs[i].getString("co_participants"));
							 t0.getRow(c).getCell(2).setText(rs[i].getString("title"));
							 t0.getRow(c).getCell(3).setText(rs[i].getString("domain"));
							 t0.getRow(c).getCell(4).setText(rs[i].getString("description"));
							 t0.getRow(c).getCell(5).setText(rs[i].getString("event_name"));
							 t0.getRow(c).getCell(6).setText(rs[i].getString("place"));
							 t0.getRow(c).getCell(7).setText(date);
							 t0.getRow(c).getCell(8).setText(rs[i].getString("position"));
						}
						
						
						if(tables[i].equals("Publication"))	
						{
							t0.getRow(c).getCell(0).setText(getfullname(rs[i].getString("user_iduser"))[0]+". "+ getfullname(rs[i].getString("user_iduser"))[1]);
							t0.getRow(c).getCell(1).setText(rs[i].getString(2));
							t0.getRow(c).getCell(2).setText(rs[i].getString(3));
							t0.getRow(c).getCell(3).setText(rs[i].getString(4));
							t0.getRow(c).getCell(4).setText(date);
							t0.getRow(c).getCell(5).setText(rs[i].getString(6));
							t0.getRow(c).getCell(6).setText(rs[i].getString(7));
							t0.getRow(c).getCell(7).setText(rs[i].getString(8));
							t0.getRow(c).getCell(8).setText(rs[i].getString(9));
							//t0.getRow(c).getCell(9).setText(rs[i].getString(10));
							
							if(rs[i].getString(11).equals("1"))
							{
								 nat_int="international";
							}
							else 
							{
								nat_int="national";

							}
							
							t0.getRow(c).getCell(9).setText(nat_int);
							

							
						}
						
						
						
					
				}
				catch(NullPointerException ex)
				{
					ex.printStackTrace();
					System.out.println(ex);
				}
				c++;

				}
			}	
		}
			
			FileOutputStream 	out = new FileOutputStream("D:/report_trial.docx");

			doc.write(out);
			out.close();
			
			System.out.println("copied successfully");

				
		}
	
		catch(Throwable e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		
	}	
	
	

public void getDate(String sd,String ed)
	{
		start_date=sd;
		end_date=ed;
		System.out.println(start_date + end_date);
	}
public String changedate(String date)
{
	
	SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
			
	try
	{
		 date = myFormat.format(fromUser.parse(date));
	}
	catch(ParseException e)
	{
		e.printStackTrace();
	}
	return date;
}
public String[] getfullname(String userid) throws ClassNotFoundException, SQLException
{
	String details[]=new String [3];
	String getname="select first_name, last_name,title,dept from user where iduser=" + userid;
	Statement stmt = null;
	try{
	currentCon = ConnectionManager.getConnection();
	stmt=currentCon.createStatement();
	}
	catch(SQLException e)
	{
		
	}
	rs_name=stmt.executeQuery(getname);
	while(rs_name.next())
	{
		details[0]=rs_name.getString("title");
		details[1]=rs_name.getString("first_name")+" "+rs_name.getString("last_name");
		details[2]=rs_name.getString("dept");
	}
	return details;
	
}


//

public String[] getstud_details(String studid) throws ClassNotFoundException, SQLException
{
	String details_stud[]=new String [3];
	String getname="select first_name, last_name,roll_no,dept from student where idstudent=" + studid;
	Statement stmt = null;
	try{
	currentCon = ConnectionManager.getConnection();
	stmt=currentCon.createStatement();
	}
	catch(SQLException e)
	{
		
	}
	rs_sname=stmt.executeQuery(getname);
	while(rs_sname.next())
	{
		details_stud[1]=rs_sname.getString("roll_no");
		details_stud[0]=rs_sname.getString("first_name")+" "+rs_sname.getString("last_name");
		details_stud[2]=rs_sname.getString("dept");
	}
	return details_stud;
	
}


}



