import java.awt.Dimension;
import java.awt.Toolkit;

public class MainDisplay {
	
	MainFrame main_fr = new MainFrame();
	
	public void go(){
		
		main_fr.setSize(1000,590);
		main_fr.setTitle("Farming Game");
		main_fr.setVisible(true);
		main_fr.setResizable(false);
		main_fr.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
		
		/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - main_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - main_fr.getSize().height/2 ;

		main_fr.setLocation(xPos,yPos);*/
	
	}

}
