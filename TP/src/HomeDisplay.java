import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;

public class HomeDisplay {


	HomeFrame home_fr = new HomeFrame();
	
	public void go(){
		home_fr.setSize(1000,590);
		home_fr.setTitle("Farming Game");
		home_fr.setVisible(true);
		home_fr.setResizable(false);
		home_fr.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - home_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - home_fr.getSize().height/2 ;

		home_fr.setLocation(xPos,yPos);
		
	
	}
}
