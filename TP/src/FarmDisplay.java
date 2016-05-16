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
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - farm_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - farm_fr.getSize().height/2 ;

		farm_fr.setLocation(xPos,yPos);
		
	
	}

}
