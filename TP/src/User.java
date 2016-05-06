
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

class FORRANK {

	String NAME = new String();
	String PASS = new String();
	
	int[] DATA = new int[2]; // money, level
	int[] bareDATA = new int[19];
}

public class User {// USER HAS ALL THE INFORMATION OF USER IN
							// Data.TXT
	AudioClip click_button;
	FORRANK[] DAT = new FORRANK[100];
	int top;
	// TYPE protected IS ONLY USED BY LOWER CLASS(INHERITTED CLASS)
	protected JInternalFrame RANK = new JInternalFrame();
	JTextArea JTA = new JTextArea();
	JScrollPane scroll = new JScrollPane(JTA);
	JComboBox box = new JComboBox();
	JButton cancel = new JButton("Cancel");
	protected JInternalFrame login_frame;
	protected JInternalFrame join_frame;
	protected boolean Success = false;
	protected boolean Cancel = false;
	protected boolean end = false;

	private String ID;
	private String PW;

	private int earnedMoney;
	private int level;
	
	private int nofFRAM; // THE NUMBERS OF FRAME
	private int nofAFRAM; // THE NUMBERS OF ANOTHR FRAME

	String GetID() {
		return ID;
	}

	void SetID(String id) {
		ID = id;
	}

	String GetPW() {
		return PW;
	}

	void SetPW(String pw) {
		PW = pw;
	}

	int GetearnedMoney() {
		return earnedMoney;
	}

	void SetearnedMoney(int money) {
		earnedMoney = money;
	}


	int GetnofAFRAM() {
		return nofAFRAM;
	}

	void SetnofAFRAM(int AFRAM) {
		nofAFRAM = AFRAM;
	}

	int GetnofFRAM() {
		return nofFRAM;
	}

	void SetnofFRAM(int FRAM) {
		nofFRAM = FRAM;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean getEnd() {
		return end;
	}

	public boolean getSuccess() {
		return Success;
	}

	public User() {

		URL url_click = null;
		
		try {
			url_click = new URL("file", "localhost", "button-19.wav");
		} catch (Exception exception) {
		}
		click_button = JApplet.newAudioClip(url_click);

		RANK.setLayout(null);
		RANK.setVisible(true);
		RANK.setSize(600, 400);
		scroll.setBounds(10, 15, 260, 300);
		JTA.setEditable(false);
		RANK.add(scroll);

		cancel.setVisible(true);
		cancel.setBounds(280, 150, 85, 20);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				RANK.dispose();
			}

		}

		);		
		RANK.add(cancel);
		
		box.setVisible(true);
		box.setBounds(280, 100, 100, 30);
		box.setVisible(true);
		box.setMaximumRowCount(3);
		box.addItem("MONEY");
		box.addItem("LEVEL");
		box.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent E) {
				// TODO Auto-generated method stub
				if (E.getStateChange() == ItemEvent.SELECTED) {
					if (box.getSelectedItem().equals("MONEY")) {
						ShowMoneyRank();
					} else if (box.getSelectedItem().equals("LEVEL")) {
						ShowLevelRank();
					} 
				}
			}

		});
		RANK.add(box);

	}

	private boolean IsMyID(String MY, String DT) {
		if (MY.length() == DT.length()) {
			for (int i = 0; i < MY.length(); i++) {
				if (MY.charAt(i) != DT.charAt(i)) {
					return false;
				}
			}
		} else
			return false;
		return true;
	}

	void OutAllDATA() {
		FileWriter W = null;
		try {
			W = new FileWriter("Data.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter B = new BufferedWriter(W);

		try {
			W.write(GetID() + " " + GetPW() + " " + getLevel() + " " + GetearnedMoney() + " " + GetnofAFRAM() + " " + GetnofFRAM()	+ " \n");
			for (int i = 0; i < top; i++) {
				if (IsMyID(GetID(), DAT[i].NAME)) {
					continue;
				} else {
					W.write(DAT[i].NAME + " " + DAT[i].PASS + " ");
					for (int j = 0; j < 17; j++) {
						W.write(DAT[i].bareDATA[j] + " ");
					}
					W.write("\n");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			B.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void GetAllDATA() throws IOException { // show RANKING in NEW FRAME
		
		BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));

		String temp;

		reader = new BufferedReader(new FileReader("Data.txt"));
		
		top = 0;
		
		while ((temp = reader.readLine()) != null) {
			
			DAT[top] = new FORRANK();
			int length = temp.length();
			String s = new String();
			String p = new String();
			Character C;
			int IDcount = 0;
			int mode = 0;
			int N = 0;

			for (int i = 0; i < length; i++) {
				
				C = temp.charAt(i);
				
				if (C == ' ') {
					IDcount++;
					if (IDcount == 1) {
						DAT[top].NAME = s;
						continue;
					} else if (IDcount == 2) {
						DAT[top].PASS = p;
					}
					for (int j = i + 1; IDcount == 2 && j < length; j++) {
						C = temp.charAt(j);
						if (C == ' ') {
							mode++;
							if (mode == 1) {
								DAT[top].DATA[0] = N;
								DAT[top].bareDATA[0] = N;
							} else if (mode == 2) {
								DAT[top].DATA[1] += N;
								DAT[top].bareDATA[1] = N;
							}
							
							N = 0;

						} else {
							int tmp = C - '0';
							N = N * 10 + tmp;
						}
					}
					break;
				} else {
					if (IDcount == 0) {
						s += C;
					} else if (IDcount == 1) {
						p += C;
					}
				}
			}
			top++;
		}
	}

	void ShowMoneyRank() {
		RANK.setTitle("TOP 10 for MONEY");
		for (int i = 0; i < top; i++) {
			for (int j = i + 1; j < top; j++) {
				if (DAT[i].DATA[0] < DAT[j].DATA[0]) {
					FORRANK temp = DAT[i];
					DAT[i] = DAT[j];
					DAT[j] = temp;
				}
			}
		}
		String tmp = "";
		for (int i = 0; i < 10; i++) {
			tmp += (i + 1 + "placed " + DAT[i].NAME + " " + DAT[i].DATA[0] + "$\n");
		}
		JTA.setText(tmp);
	}

	
	void ShowLevelRank() {
		RANK.setTitle("TOP 10 for PLAYER who are high level ");
		for (int i = 0; i < top; i++) {
			for (int j = i + 1; j < top; j++) {
				if (DAT[i].DATA[1] < DAT[j].DATA[1]) {
					FORRANK temp = DAT[i];
					DAT[i] = DAT[j];
					DAT[j] = temp;
				}
			}
		}
		String tmp = "";
		for (int i = 0; i < 10; i++) {
			tmp += (i + 1 + "placed " + DAT[i].NAME + " " + DAT[i].DATA[1] + "\n");
		}
		JTA.setText(tmp);
	}

}