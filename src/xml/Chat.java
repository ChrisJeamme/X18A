package xml;

import java.util.ArrayList;

public class Chat
{
	ArrayList<Message> messages;
	int id;

	public Chat()
	{
		messages = new ArrayList<Message>();
	}
	
	public Chat(int id)
	{
		this();
		this.id = id;
	}
	
	public void ajouterMessage(Message m)
	{
		messages.add(m);
	}

	public ArrayList<Message> getMessages()
	{
		return messages;
	}

	public int getId()
	{
		return id;
	}

	public void setMessages(ArrayList<Message> messages)
	{
		this.messages = messages;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Message getDernierMessage()
	{
		if(!messages.isEmpty())
			return messages.get(messages.size()-1);
		else
			return null;
	}

	@Override
	public String toString()
	{
		return "Chat [messages=" + messages + ", id=" + id + "]";
	}

}
