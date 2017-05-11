package interfaceClientLourd;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class LancerInterface
{
	public static JFrame frame;
	
	public static void main(String[] args)
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(0, 0);
		frame.setPreferredSize(new Dimension(900, 750));
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		AccueilNonConnecte.lancerInterface();
	}
}
