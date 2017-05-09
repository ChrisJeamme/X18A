package xml;

import donnees.Depense;

public class Test
{

	public static void main(String[] args)
	{
		//Chat chat = new Chat();
		Depense depense = new Depense();
		
		ParserSAX p3 = new ParserSAX();
		//MySAXHandlerChat handlerChat = new MySAXHandlerChat(chat);
		MySAXHandlerDepense handlerDepense = new MySAXHandlerDepense(depense);
		
		p3.monParsing(handlerDepense, "depense.xml");
	}
}
