import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;

public class checkDisplay {

	checkFrame cf_fr = new checkFrame();
	
	public void go(){
		cf_fr.setSize(700,350);
		cf_fr.setTitle("Check Mission");
		cf_fr.setVisible(true);
		cf_fr.setResizable(false);
		cf_fr.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - cf_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - cf_fr.getSize().height/2 ;

		cf_fr.setLocation(xPos,yPos);
		
	
	}
	
}