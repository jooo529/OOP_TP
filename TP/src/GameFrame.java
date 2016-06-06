import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GameFrame extends JFrame {
	/*Crating Labels that have user information*/
	private JLabel userAPPLE_label = new JLabel();
	private JLabel userGRAPE_label = new JLabel();
	private JLabel userORANGE_label = new JLabel();
	private JLabel userSTRAWBERRY_label = new JLabel();
	private JLabel userMONEY_label = new JLabel();
	private JLabel userLEVEL_label = new JLabel();
	private JLabel userID_label = new JLabel();
	
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
	
	/* crate Jpanel that have user information Jlebel */
	JPanel userImfoPane() {

		JPanel menupanel = new JPanel();

		Font font = new Font("Dialog", Font.BOLD, 13); // 20은 글자 크기

		userID_label = new JLabel("User   :   " + UserFile.Users.get(idx).getId());
		userID_label.setFont(font);

		userMONEY_label.setText("    Money   :   " + UserFile.Users.get(idx).getMoney());
		userMONEY_label.setFont(font);

		userLEVEL_label = new JLabel("    Level   :   " + UserFile.Users.get(idx).getLevel());
		userLEVEL_label.setFont(font);

		userAPPLE_label.setText("    Apple  BOX :   " + UserFile.Users.get(idx).getApplebox());
		userAPPLE_label.setFont(font);

		userGRAPE_label.setText("    Grape  BOX  :   " + UserFile.Users.get(idx).getGrapebox());
		userGRAPE_label.setFont(font);

		userORANGE_label.setText("    Orange  BOX  :   " + UserFile.Users.get(idx).getOrangebox());
		userORANGE_label.setFont(font);

		userSTRAWBERRY_label.setText("    Strawberry  BOX  :   " + UserFile.Users.get(idx).getStrawberrybox());
		userSTRAWBERRY_label.setFont(font);

		changeImfo();

		menupanel.add(userID_label);
		menupanel.add(userLEVEL_label);
		menupanel.add(userMONEY_label);
		menupanel.add(userAPPLE_label);
		menupanel.add(userGRAPE_label);
		menupanel.add(userORANGE_label);
		menupanel.add(userSTRAWBERRY_label);

		return menupanel;

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
