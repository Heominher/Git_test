package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Example1 {

	public static void main(String[] args) {

		Dimension dim = new Dimension(400,100);
		
		JFrame frame = new JFrame("Min's Test");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
//		GridLayout grid = new GridLayout(3,1);
//		frame.setLayout(grid);
		
		JLabel label = new JLabel("0");
		label.setBackground(Color.black);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(label);
		
		JButton btn = new JButton("Click btn");
		btn.setBackground(Color.pink);
		frame.add(btn);
		
		JButton btn1 = new JButton("Reset btn");
		btn1.setBackground(Color.yellow);
		frame.add(btn1);
		
		ActionListener listener = new ActionListener() {  
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(String.valueOf(Integer.valueOf(label.getText())+1034));
			}
		};
		btn.addActionListener(listener);
		
		ActionListener listener1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("0");
			}
		};
		btn1.addActionListener(listener1);
		
		
		frame.add(btn);
		frame.add(btn1);
		
		
		
		frame.add(label, BorderLayout.CENTER);
		frame.add(btn, BorderLayout.NORTH);
		frame.add(btn1, BorderLayout.EAST);
		
		
		
		
		frame.pack();
		frame.setVisible(true);
		
		
		
		
	}

}
