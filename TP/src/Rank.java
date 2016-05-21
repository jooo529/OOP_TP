import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Rank extends File{

	private JTable rank_tb;
	private JScrollPane rank_sp;
	JButton back_btn;
	JFrame rank_fr = new JFrame("Rank");

	void go(){
		rank_fr.setSize(500,400);
		rank_fr.setVisible(true);
		rank_fr.setResizable(false);
		rank_fr.setDefaultCloseOperation(rank_fr.DISPOSE_ON_CLOSE);
		
		this.fileLoad();
		
		String col[]={"Name", "Level", "Money","Login Data"};
		Object row[][] = new Object[Users.size()][4];
		for(User num: Users){
			int i = Users.indexOf(num);
			row[i][0] = Users.get(i).getId();
			row[i][1] = Users.get(i).getLevel();
			row[i][2] = Users.get(i).getMoney();
			row[i][3] = Users.get(i).getLogindata();
		}
		
		DefaultTableModel model = new DefaultTableModel(row,col){
			public boolean isCellEditable(int i, int c){
		          return false;
		    }
		};
		
		rank_tb = new JTable(model);
		rank_sp = new JScrollPane(rank_tb);
		rank_fr.add(rank_sp);
	
		back_btn = new JButton("Back");
		back_btn.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent event){
				rank_fr.setVisible(false);
		}});
		
		rank_fr.add(BorderLayout.NORTH, back_btn);
		
		//전체 창 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  
		//창을 중앙에 위치시킬 수 있다.
		int xPos = screenSize.width/2 - rank_fr.getSize().width/2 ;
		int yPos = screenSize.height/2 - rank_fr.getSize().height/2 ;

		rank_fr.setLocation(xPos,yPos);
	
	}

}
