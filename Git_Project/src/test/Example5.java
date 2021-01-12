package test;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example5 {

	public static void main(String[] args) {

		Dimension dim = new Dimension(300,300);
		
		JFrame frame = new JFrame("Example5's House");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		frame.setResizable(false); // 창크기 수정불가
		
		JLabel label1 = new JLabel(new ImageIcon("C:\\Users\\Heomh\\Desktop\\good.png"));
		JButton but = new JButton("클릭");
		label1.add(but);
		
		
		DrawPanel1 drawpanel = new DrawPanel1();
//		JLabel l = new JLabel("tsecst");
//		drawpanel.add(l);
		drawpanel.add(label1);
		
		
		frame.add(drawpanel);
		frame.pack();
		frame.setVisible(true);
	}

}
class DrawPanel1 extends JPanel  //그림 그리기 위한 기본 드로링 클래스 선언
{
//	@Override
	public void paint(Graphics g){
		super.paint(g);
	}
}

