package xml;

public class Demande_liste
{
	private int id;
	private ObjetType type_id;
	private ObjetDemande objet_demande;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ObjetType getType_id() {
		return type_id;
	}
	public void setType_id(ObjetType type_id) {
		this.type_id = type_id;
	}
	public ObjetDemande getObjet_demande() {
		return objet_demande;
	}
	public void setObjet_demande(ObjetDemande objet_demande) {
		this.objet_demande = objet_demande;
	}
}