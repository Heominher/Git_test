package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator {

	public static void main(String[] args) {
		
		Dimension dim = new Dimension(350,500);
		
		JFrame frame = new JFrame("Calculator");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		JPanel top = new JPanel();   //상단 패널!!!!!!!!!!!!!!!!!!
//		top.setPreferredSize(new Dimension(350,50));
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		top.add(new JTextField());
		top.add(new JTextField());
		top.add(new JTextField());
		top.add(new JTextField());
		
		
		GridLayout grid = new GridLayout(3,3);  //센터 번호판!!!!!!!!!!!!!!!!
		JPanel center = new JPanel();
		center.setLayout(grid);
		
		JButton num1 = new JButton("1");
		num1.setOpaque(true);
		num1.setBackground(Color.red);
		JButton num2 = new JButton("2");
		num2.setOpaque(true);
		num2.setBackground(Color.orange);
		JButton num3 = new JButton("3");
		num3.setOpaque(true);
		num3.setBackground(Color.yellow);
		JButton num4 = new JButton("4");
		num4.setOpaque(true);
		num4.setBackground(Color.green);
		JButton num5 = new JButton("5");
		num5.setOpaque(true);
		num5.setBackground(Color.blue);
		JButton num6 = new JButton("6");
		num6.setOpaque(true);
		num6.setBackground(Color.white);
		JButton num7 = new JButton("7");
		num7.setOpaque(true);
		num7.setBackground(Color.PINK);
		JButton num8 = new JButton("8");
		num8.setOpaque(true);
		num8.setBackground(Color.CYAN);
		JButton num9 = new JButton("9");
		num9.setOpaque(true);
		num9.setBackground(Color.gray);
		
		center.add(num1);
		center.add(num2);
		center.add(num3);
		center.add(num4);
		center.add(num5);
		center.add(num6);
		center.add(num7);
		center.add(num8);
		center.add(num9);
		
		
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		left.add(new JButton("+"));
		left.add(new JButton("-"));
		left.add(new JButton("/"));
		left.add(new JButton("*"));
		

		frame.add(top,BorderLayout.NORTH);
		frame.add(center, BorderLayout.CENTER);
		frame.add(left, BorderLayout.EAST);
		JButton result = new JButton("계산하기");
		frame.add(result, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setVisible(true);
		
		
		
		

	}

}
