import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Farm_background extends JPanel {
	

	public void paintComponent(Graphics g)
		{
			Image image = new ImageIcon("C:\\Users\\Á¶°ÇÈñ\\Pictures\\FARM.jpg").getImage();
			
			g.drawImage(image, 0, 0, 900, 550, null);
		}
	

}