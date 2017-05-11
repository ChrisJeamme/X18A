package xml;

import donnees.Chat;
import donnees.Utilisateur;

/**
 * Sert aux tests sur le XML et les parsers
 *
 */
public class Test
{

	public static void main(String[] args)
	{
		
		Chat chat = new Chat();
		
		ParserSAX p3 = new ParserSAX();
		MySAXHandlerChat handlerChat = new MySAXHandlerChat(chat);
		
		p3.monParsing(handlerChat, "xml/chat.xml");
		
		
		Utilisateur utilisateur = new Utilisateur();
		ParserSAX p4 = new ParserSAX();
		MySAXHandlerUtilisateur handlerUtilisateur = new MySAXHandlerUtilisateur(utilisateur);
		
		p4.monParsing(handlerUtilisateur, "xml/utilisateur.xml"); 
		
	}
}

