package retrievePackage;

public class UserBean {
	static String ppr_name,org_name,att_name;
	static String att_type,att_title,att_asso,org_type,org_date,org_asso,org_sponsor,org_place,org_speaker;
	static String att_date;
	static int org_days,org_parti,att_days,org_id;
	static String con_name,con_type,con_date,con_asso,con_place,con_sponsor;
	static int con_days,con_parti,con_keynote,con_id;
	static String ppr_page,ppr_title,ppr_type,ppr_pubin,ppr_date,ppr_vol,ppr_issue,ppr_auth;
	static int ppr_natint,ppr_id,att_id;
	
////////////////////////Publication///////////////////////////////
	public static void setPaperId(int id)
	{
		ppr_id = id;
	}
	public static int getPaperId()
	{
		return ppr_id;
	}
	public static void setPaperTitle(String title)
	{
		ppr_title = title;
	}
	public static String getPaperTitle()
	{
		return ppr_title;
	}
	public static void setPaperType(String type)
	{
		ppr_type = type;
	}
	public static String getPaperType()
	{
		return ppr_type;
	}
	public static void setPaperPubIn(String pubIn)
	{
		ppr_pubin = pubIn;
	}
	public static String getPaperPubIn()
	{
		return ppr_pubin;
	}
	public static void setPaperDate(String date)
	{
		ppr_date = date;
	}
	public static String getPaperDate()
	{
		return ppr_date;
	}
	public static void setPaperVolume(String volume)
	{
		ppr_vol = volume;
	}
	public static String getPaperVolume()
	{
		return ppr_vol;
	}
	public static void setPaperIssue(String issue)
	{
		ppr_issue = issue;
	}
	public static String getPaperIssue()
	{
		return ppr_issue;
	}
	public static void setPaperPage(String page)
	{
		ppr_page = page;
	}
	public static String getPaperPage()
	{
		return ppr_page;
	}
	public static void setPaperAuthor(String author)
	{
		ppr_auth = author;
	}
	public static String getPaperAuthor()
	{
		return ppr_auth;
	}
	public static void setPaperNatint(int natint)
	{
		ppr_natint = natint;
	}
	public static int getPaperNatint()
	{
		return ppr_natint;
	}
	/////////////////Conducted//////////////////////////
	
	public static void setConId(int id)
	{
		con_id = id;
	}
	
	public static int getConId()
	{
		return con_id;
	}
	
	public static void setConName(String name)
	{
		con_name = name;
	}
	public static String getConName()
	{
		return con_name;
	}
	public static void setConType(String name)
	{
		con_type = name;
	}
	public static String getConType()
	{
		return con_type;
	}
	public static void setConDate(String name)
	{
		con_date = name;
	}
	public static String getConDate()
	{
		return con_date;
	}
	public static void setConDays(int name)
	{
		con_days = name;
	}
	public static int getConDays()
	{
		return con_days;
	}
	public static void setConAsso(String name)
	{
		con_asso = name;
	}
	public static String getConAsso()
	{
		return con_asso;
	}
	public static void setConPlace(String name)
	{
		con_place = name;
	}
	public static String getConPlace()
	{
		return con_place;
	}
	public static void setConSponsor(String name)
	{
		con_sponsor = name;
	}
	public static String getConSponsor()
	{
		return con_sponsor;
	}
	public static void setConParti(int name)
	{
		con_parti = name;
	}
	public static int getConParti()
	{
		return con_parti;
	}
	public static void setConKeynote(int name)
	{
		con_keynote = name;
	}
	public static int getConKeynote()
	{
		return con_keynote;
	}
	
//////////////////Organized//////////////////////////
	
	
	public static void setOrgId(int id)
	{
		org_id = id;
	}
	public static int getOrgId()
	{
		return org_id;
	}
	public static void setOrgName(String name)
	{
		org_name = name;
	}
	public static String getOrgName()
	{
		return org_name;
	}
	public static void setOrgType(String name)
	{
		org_type = name;
	}
	public static String getOrgType()
	{
		return org_type;
	}
	public static void setOrgDate(String name)
	{
		org_date = name;
	}
	public static String getOrgDate()
	{
		return org_date;
	}
	public static void setOrgDays(int name)
	{
		org_days = name;
	}
	public static int getOrgDays()
	{
		return org_days;
	}
	public static void setOrgAsso(String name)
	{
		org_asso = name;
	}
	public static String getOrgAsso()
	{
		return org_asso;
	}
	public static void setOrgSponsor(String name)
	{
		org_sponsor = name;
	}
	public static String getOrgSponsor()
	{
		return org_sponsor;
	}
	public static void setOrgPlace(String name)
	{
		org_place = name;
	}
	public static String getOrgPlace()
	{
		return org_place;
	}
	public static void setOrgParti(int name)
	{
		org_parti = name;
	}
	public static int getOrgParti()
	{
		return org_parti;
	}
	public static void setOrgSpeaker(String name)
	{
		org_speaker = name;
	}
	
	public static String getOrgSpeaker()
	{
		return org_speaker;
	}
	
	//////////Attended///////////////
	
	public static void setAttId(int name)
	{
		att_id = name;
	}
	public static int getAttId()
	{
		return att_id;
	}
	public static void  setAttName(String name)
	{
		att_name = name;
	}
	public static String getAttName()
	{
		return att_name;
	}
	public static void setAttType(String name)
	{
		att_type = name;
	}
	public static String getAttType()
	{
		return att_type;
	}
	public static void setAttDate(String name)
	{
		att_date = name;
	}
	public static String getAttDate()
	{
		return att_date;
	}
	public static void setAttDays(int name)
	{
		att_days = name;
	}
	public static int getAttDays()
	{
		return att_days;
	}
	public static void setAttTitle(String name)
	{
		att_title = name;
	}
	public static String getAttTitle()
	{
		return att_title;
	}
	public static void setAttAsso(String name)
	{
		att_asso = name;
	}
	public static String getAttAsso()
	{
		return att_asso;
	}
}
