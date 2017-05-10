package xml;

public class Demande
{
	private ObjetDemande type;
	private int id;
	private int id2;
	private String date;
	
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public ObjetDemande getType()
	{
		return type;
	}
	public int getId()
	{
		return id;
	}
	public int getId2()
	{
		return id2;
	}
	public void setType(ObjetDemande type)
	{
		this.type = type;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setId2(int id2)
	{
		this.id2 = id2;
	}
}
