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
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - store_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - store_fr.getSize().height/2 ;

		store_fr.setLocation(xPos,yPos);
		
	
	}

}
