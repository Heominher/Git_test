package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class test {

	public static void main(String[] args) {
		
		Dimension dim = new Dimension(400,150);
		
		JFrame frame = new JFrame("test's House");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		JPanel panel1 = new JPanel();  //조각 프레임
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(new JLabel("이름 : "));
		panel1.add(new JTextArea());

		JPanel panel2 = new JPanel();  //조각 프레임
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(new JLabel("나이 : "));
		panel2.add(new JTextArea());
		
		JPanel panel3 = new JPanel();  //조각 프레임
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel3.add(panel1);
		panel3.add(panel2);
		
		frame.add(panel3, BorderLayout.CENTER);
		frame.add(new JButton("클릭하기"), BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setVisible(true);
		
		
		

	}

}
