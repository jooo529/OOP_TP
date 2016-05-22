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
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - npc_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - npc_fr.getSize().height/2 ;

		npc_fr.setLocation(xPos,yPos);
		
	
	}
	
}
