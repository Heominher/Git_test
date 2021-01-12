package test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example5 {

	public static void main(String[] args) {

		Dimension dim = new Dimension(300,300);
		
		JFrame frame = new JFrame("Example5's House");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);

		
		
		DrawPanel drawpanel = new DrawPanel();
//		JLabel l = new JLabel("tsecst");
//		drawpanel.add(l);
		
		
		frame.add(drawpanel);
		frame.pack();
		frame.setVisible(true);
	}

}
class DrawPanel extends JPanel
{
	@Override
	public void paint(Graphics g){
		 
		super.paint(g);
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Heomh\\Desktop\\good.png");
		
		g.drawImage(img, 50, 50, this);
	}
}
