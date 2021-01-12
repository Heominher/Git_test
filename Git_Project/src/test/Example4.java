package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



///그림 그리기 예제
public class Example4 {

	public static void main(String[] args) {
		
		Dimension dim = new Dimension(400,250);
		
		JFrame frame = new JFrame("Example4's House");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);

			
		DrawPanel drawpanel = new DrawPanel();
		frame.add(drawpanel);
		
		
		
		
		frame.pack();
		frame.setVisible(true);
		
		
	}

}
