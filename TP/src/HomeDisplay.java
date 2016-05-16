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
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - home_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - home_fr.getSize().height/2 ;

		home_fr.setLocation(xPos,yPos);
		
	
	}
}
