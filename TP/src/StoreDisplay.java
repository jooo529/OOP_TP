import java.awt.Dimension;
import java.awt.Toolkit;

public class StoreDisplay {
	
	StoreFrame store_fr = new StoreFrame();
	
	public void go(){
		store_fr.setSize(1000,590);
		store_fr.setTitle("Farming Game");
		store_fr.setVisible(true);
		store_fr.setResizable(false);
		store_fr.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - store_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - store_fr.getSize().height/2 ;

		store_fr.setLocation(xPos,yPos);
		
	
	}

}
