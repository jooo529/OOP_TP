import java.awt.*;

public class LoginDisplay {
	
	LoginFrame log_fr = new LoginFrame();
	
	public void go(){
		log_fr.setSize(400,600);
		log_fr.setTitle("Farming Game");
		log_fr.setVisible(true);
		log_fr.setResizable(true);
		log_fr.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.width+","+screenSize.height);
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - log_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - log_fr.getSize().height/2 ;

		log_fr.setLocation(xPos,yPos);
		
	
	}
	
}
