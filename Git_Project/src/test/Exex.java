package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Exex {

	static String nn="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Dimension dim = new Dimension(400,150);
		
		JFrame frame = new JFrame("test's House");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		
		
		
		
		JPanel panel3 = new JPanel();  //조각 프레임
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		
		JTextPane fie = new JTextPane();
		JScrollPane fo = new JScrollPane();
		fo.add(fie);
		fie.setBackground(Color.yellow);
		fie.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		

		fie.setEditable(false);

		JButton btn = new JButton("추가");
		
		
		panel3.add(fo);
		
		
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nn = nn + "\nzzzzzz";
				fie.setText(nn);
				
			}
		});
		
		frame.add(panel3, BorderLayout.CENTER);
		frame.add(btn, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);

	}

}



