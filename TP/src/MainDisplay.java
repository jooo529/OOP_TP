import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainDisplay extends JFrame {

	MainDisplay() {


		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(950, 700);
		this.setBackground(Color.yellow);

		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 250, 400);

		this.add(p1);
		JButton jb1 = new JButton("House");
		jb1.setBounds(75, 150, 100, 100);
		p1.add(jb1);
/*
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(300, 0, 250, 400);

		this.add(p2);
		JButton jb2 = new JButton("Farm");
		jb2.setBounds(375, 150, 100, 100);
		p2.add(jb2);

		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBounds(600, 0, 250, 400);

		this.add(p3);
		JButton jb3 = new JButton("Store");
		jb3.setBounds(700, 150, 50, 100);
		p3.add(jb3);

		JPanel p4 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 450, 900, 100);

		this.add(p4);
		JButton quit = new JButton("Save and Quit");
		quit.setBounds(150, 100, 100, 50);
		p4.add(quit);

*/
		this.setTitle("MainDisplay");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainDisplay();
	}
}