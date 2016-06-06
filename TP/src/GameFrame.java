import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class GameFrame extends JFrame {
	/*Crating Labels that have user information*/
	private JLabel userAPPLE_label = new JLabel();
	private JLabel userGRAPE_label = new JLabel();
	private JLabel userORANGE_label = new JLabel();
	private JLabel userSTRAWBERRY_label = new JLabel();
	private JLabel userMONEY_label = new JLabel();
	
	/* Crate User file*/
	private UserFile f = new UserFile();
	private int idx;
	
	void getUserIdx(){
		
		/* get user information in user file */
		for (int i = 0; i < UserFile.Users.size(); i++) {
			if (UserFile.Users.get(i).getIndex() > 0)
				idx = i;
		}
		
	}
	
	/* User information label change */
	void changeImfo() {
		userMONEY_label.setText("    Money   :   " + UserFile.Users.get(idx).getMoney());
		userAPPLE_label.setText("    Apple  BOX :   " + UserFile.Users.get(idx).getApplebox());
		userGRAPE_label.setText("    Grape  BOX  :   " + UserFile.Users.get(idx).getGrapebox());
		userORANGE_label.setText("    Orange  BOX  :   " + UserFile.Users.get(idx).getOrangebox());
		userSTRAWBERRY_label.setText("    Strawberry  BOX  :   " + UserFile.Users.get(idx).getStrawberrybox());
	}

	
	
	

}
