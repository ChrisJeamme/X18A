package xml;

public class Test
{

	public static void main(String[] args)
	{
		Chat chat = new Chat();
		
		ParserSAX p3 = new ParserSAX();
		MySAXHandlerChat handlerChat = new MySAXHandlerChat(chat);
		
		p3.monParsing(handlerChat, "chat.xml");
	}
}
