import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainDisplay extends JFrame {

	MainDisplay() {


		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 550);


		JPanel p1 = new JPanel();
		p1.setBackground(Color.yellow);
		p1.setLayout(null);
		p1.setBounds(0, 0, 900, 400);

		this.add(p1);
		JButton jb1 = new JButton("House");
		jb1.setBounds(100, 150, 100, 100);
		p1.add(jb1);

		JButton jb2 = new JButton("Farm");
		jb2.setBounds(400, 150, 100, 100);
		p1.add(jb2);
		
		JButton jb3 = new JButton("Store");
		jb3.setBounds(700, 150, 100, 100);
		p1.add(jb3);

		JPanel p2 = new JPanel();
		p2.setBackground(Color.green);
		p2.setLayout(null);
		p2.setBounds(0, 400, 900, 100);

		this.add(p2);
		JButton quit = new JButton("Save and Quit");
		quit.setBounds(350, 25, 200, 50);
		p2.add(quit);


		this.setTitle("MainDisplay");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainDisplay();
	}
}