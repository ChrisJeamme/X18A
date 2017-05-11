package donnees;

import java.util.ArrayList;

/**
 * Données de l'objet Chat
 *
 */
public class Chat
{
	ArrayList<Message> messages;
	int id;

	/**
	 * Constructeur vide
	 */
	public Chat()
	{
		messages = new ArrayList<Message>();
	}
	
	/**
	 * Constructeur avec un id prédéfini
	 * @param id int
	 */
	public Chat(int id)
	{
		this();
		this.id = id;
	}
	
	/**
	 * Permet d'ajouter un message dans la liste de messages du chat
	 * @param m Message
	 */
	public void ajouterMessage(Message m)
	{
		messages.add(m);
	}

	/**
	 * Retourne la liste de messages du chat
	 * @return ArrayList<Message> : La liste de messages
	 */
	public ArrayList<Message> getMessages()
	{
		return messages;
	}
	
	/**
	 * Remplace la liste de message par celle en paramètres
	 * @param messages ArrayList<Message>
	 */
	public void setMessages(ArrayList<Message> messages)
	{
		this.messages = messages;
	}

	/**
	 * Retourne l'id
	 * @return int : id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Change la valeur de l'id
	 * @param id int
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Retourne le dernier message de la liste de messages
	 * @return Message : Le dernier message de la liste
	 */
	public Message getDernierMessage()
	{
		if(!messages.isEmpty())
			return messages.get(messages.size()-1);
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Chat [messages=" + messages + ", id=" + id + "]";
	}

}
