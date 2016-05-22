import java.awt.Dimension;
import java.awt.Toolkit;

public class NpcDisplay {

	
	NpcFrame npc_fr = new NpcFrame();
	
	public void go(){
		npc_fr.setSize(700,350);
		npc_fr.setTitle("NPC");
		npc_fr.setVisible(true);
		npc_fr.setResizable(false);
		npc_fr.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);
		
		//��ü â ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//â�� �߾ӿ� ��ġ��ų �� �ִ�.
		int xPos = screenSize.width/2 - npc_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - npc_fr.getSize().height/2 ;

		npc_fr.setLocation(xPos,yPos);
		
	
	}
	
}
