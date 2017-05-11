package xml;

/**
 * Contient les opération sur l'objet Demande_liste
 *
 */
public class Demande_liste
{
	private int id;
	private ObjetType type_id;
	private ObjetDemande objet_demande;
	
	/**
	 * Retourne l'id
	 * @return int : L'id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Change l'id
	 * @param id int
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Retourne le type_id
	 * @return ObjetType : Le type_id
	 */
	public ObjetType getType_id() {
		return type_id;
	}
	
	/**
	 * Change le type_id
	 * @param type_id ObjetType
	 */
	public void setType_id(ObjetType type_id) {
		this.type_id = type_id;
	}
	
	/**
	 * Retourne l'objet_demande
	 * @return ObjetDemande : L'objet_demande
	 */
	public ObjetDemande getObjet_demande() {
		return objet_demande;
	}
	
	/**
	 * Change l'objet_demande
	 * @param objet_demande ObjetDemande
	 */
	public void setObjet_demande(ObjetDemande objet_demande) {
		this.objet_demande = objet_demande;
	}
}