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
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - gm_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - gm_fr.getSize().height/2 ;

		gm_fr.setLocation(xPos,yPos);
		
	
	}
	
}
