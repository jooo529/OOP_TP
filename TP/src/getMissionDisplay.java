import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;

public class getMissionDisplay {

	getMissionFrame gm_fr = new getMissionFrame();
	
	public void go(){
		gm_fr.setSize(700,350);
		gm_fr.setTitle("Get Mission");
		gm_fr.setVisible(true);
		gm_fr.setResizable(false);
		gm_fr.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - gm_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - gm_fr.getSize().height/2 ;

		gm_fr.setLocation(xPos,yPos);
		
	
	}
	
}
