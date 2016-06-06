import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.*;

public class HelpFrame extends JFrame {

	public HelpFrame() {
		// set frame's state
		this.setSize(700, 350);
		this.setTitle("Help~");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(LoginFrame.DISPOSE_ON_CLOSE);

		// entire window's size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// locate frame in center
		int xPos = screenSize.width / 2 - this.getSize().width / 2;
		int yPos = screenSize.height / 2 - this.getSize().height / 2;

		this.setLocation(xPos, yPos);

		this.go_help();
	}

	private Container container;
	private BufferedImage mission_ex;
	private JButton mission1, mission2, mission3, mission4, mission5;
	private JLabel label1, label2, label3, label4, label5;

	private JTextArea textarea;
	private JPanel buttonPanel;
	private JPanel textPanel;

	private Font font = new Font("Kristen ITC", Font.BOLD, 20);
	private Font font2 = new Font("Kristen ITC", Font.BOLD, 14);

	private Mission[] m = new Mission[5];

	void go_help() {

		mission1 = new JButton();
		mission1.setIcon(new ImageIcon("mission_b_300.png"));
		mission1.addActionListener(new mission_b_listener());
		mission1.setRolloverIcon(new ImageIcon(""));
		label1 = new JLabel("        M i s s i o n 1 ");
		label1.setFont(font);

		mission2 = new JButton();
		mission2.setIcon(new ImageIcon("mission_b_300.png"));
		mission2.addActionListener(new mission_b_listener());
		mission2.setRolloverIcon(new ImageIcon(""));
		label2 = new JLabel("        M i s s i o n 2 ");
		label2.setFont(font);

		mission3 = new JButton();
		mission3.setIcon(new ImageIcon("mission_b_300.png"));
		mission3.addActionListener(new mission_b_listener());
		mission3.setRolloverIcon(new ImageIcon(""));
		label3 = new JLabel("        M i s s i o n 3 ");
		label3.setFont(font);

		mission4 = new JButton();
		mission4.setIcon(new ImageIcon("mission_b_300.png"));
		mission4.addActionListener(new mission_b_listener());
		mission4.setRolloverIcon(new ImageIcon(""));
		label4 = new JLabel("        M i s s i o n 4 ");
		label4.setFont(font);

		mission5 = new JButton();
		mission5.setIcon(new ImageIcon("mission_b_300.png"));
		mission5.addActionListener(new mission_b_listener());
		mission5.setRolloverIcon(new ImageIcon(""));
		label5 = new JLabel("        M i s s i o n 5 ");
		label5.setFont(font);

		mission1.add(label1);
		mission2.add(label2);
		mission3.add(label3);
		mission4.add(label4);
		mission5.add(label5);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1, 0, 0));
		buttonPanel.setBounds(0, 0, 300, 310);

		buttonPanel.add(mission1);
		buttonPanel.add(mission2);
		buttonPanel.add(mission3);
		buttonPanel.add(mission4);
		buttonPanel.add(mission5);

		container = this.getContentPane(); // frame
		container.setLayout(null);

		try {
			mission_ex = ImageIO.read(new File("mission_ex.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e2) {
			e2.printStackTrace();
		}

		textPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(mission_ex, 0, 0, 400, 310, this);
			}
		}; // text background image
		textPanel.setLayout(null);
		textPanel.setBounds(300, 0, 400, 310);

		textarea = new JTextArea(10, 20);
		textarea.setFont(font2);
		textarea.setEditable(false);
		textarea.setLineWrap(true);

		JScrollPane scroller = new JScrollPane(textarea);
		scroller.setBounds(40, 55, 320, 200);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		/*
		 * scroller.addMouseWheelListener(new MouseWheelListener() { public void
		 * mouseWheelMoved(MouseWheelEvent arg0) { boolean scrollermove = false;
		 * } });
		 */// it does not work....
		textPanel.add(scroller);
		container.add(buttonPanel);
		container.add(textPanel);
		// container.add(BorderLayout.EAST,eastPanel);

	}

	class mission_b_listener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			m[0] = new Mission1();
			m[1] = new Mission2();
			m[2] = new Mission3();
			m[3] = new Mission4();
			m[4] = new Mission5();

			// show help message
			if (event.getSource() == mission1)
				textarea.setText(m[0].helpMission());
			else if (event.getSource() == mission2)
				textarea.setText(m[1].helpMission());
			else if (event.getSource() == mission3)
				textarea.setText(m[2].helpMission());
			else if (event.getSource() == mission4)
				textarea.setText(m[3].helpMission());
			else if (event.getSource() == mission5)
				textarea.setText(m[4].helpMission());
		}
	}
}