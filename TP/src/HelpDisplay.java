import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;

public class HelpDisplay {

HelpFrame help_fr = new HelpFrame();
	
	public void go(){
		help_fr.setSize(700,350);
		help_fr.setTitle("Help~");
		help_fr.setVisible(true);
		help_fr.setResizable(false);
		help_fr.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - help_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - help_fr.getSize().height/2 ;

		help_fr.setLocation(xPos,yPos);
		
	
	}
	
}
