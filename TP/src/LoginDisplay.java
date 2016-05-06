import java.awt.*;

public class LoginDisplay {
	
	LoginFrame log_fr = new LoginFrame();
	
	public void go(){
		log_fr.setSize(400,600);
		log_fr.setTitle("Farming Game");
		log_fr.setVisible(true);
		log_fr.setResizable(true);
		log_fr.setDefaultCloseOperation(LoginFrame.EXIT_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.width+","+screenSize.height);
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - log_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - log_fr.getSize().height/2 ;

		log_fr.setLocation(xPos,yPos);
		
	
	}
	
}
