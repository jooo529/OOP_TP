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
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - cf_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - cf_fr.getSize().height/2 ;

		cf_fr.setLocation(xPos,yPos);
		
	
	}
	
}