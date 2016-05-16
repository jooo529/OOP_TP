import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;

public class FarmDisplay {
	
	FarmFrame farm_fr = new FarmFrame();
	
	public void go(){
		farm_fr.setSize(1000,590);
		farm_fr.setTitle("Farming Game");
		farm_fr.setVisible(true);
		farm_fr.setResizable(false);
		farm_fr.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - farm_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - farm_fr.getSize().height/2 ;

		farm_fr.setLocation(xPos,yPos);
		
	
	}

}
