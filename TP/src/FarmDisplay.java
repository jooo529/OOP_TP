import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;

public class FarmDisplay {
	
	FarmFrame farm_fr = new FarmFrame();
	FarmingFrame farming_fr = new FarmingFrame();
	
	public void go(){
		farm_fr.setSize(1000,590);
		farm_fr.setTitle("Farming Game");
		farm_fr.setVisible(true);
		farm_fr.setResizable(false);
		farm_fr.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - farm_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - farm_fr.getSize().height/2 ;

		farm_fr.setLocation(xPos,yPos);	
	}
	
	public void go_game(){
		farming_fr.setSize(1000,590);
		farming_fr.setTitle("Farming Game");
		farming_fr.setVisible(true);
		farming_fr.setResizable(false);
		farming_fr.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - farming_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - farming_fr.getSize().height/2 ;

		farming_fr.setLocation(xPos,yPos);	
	}

}
