package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Example2 {

	public static void main(String[] args) {

		Dimension dim = new Dimension(300,200);
		
		JFrame frame = new JFrame("Example2's Test");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		
		JTextArea textfield = new JTextArea();  //택스트 입력창 생성
		textfield.setText("미리 설정함");
		textfield.setEnabled(true);  //텍스트박스 수정을 막는 설정
		textfield.setFont(new Font("궁서채", Font.BOLD, 30));   // 폰트 설정법 : (글짜이름,굵기정도,크기)
		
		
		JLabel label = new JLabel("초기값 셋팅");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);   //배경색 넣어주기 전에 true해야됨
		
		
		
		JButton btn = new JButton("입력하기ㄱㄱ");
		btn.addActionListener(new ActionListener() {    //버튼 클릭 함수설정
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(textfield.getText());
			}
		});
		
		
		frame.add(textfield, BorderLayout.CENTER);   //보드레이아웃 설정
		frame.add(label, BorderLayout.NORTH);
		frame.add(btn, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setVisible(true);
		
		
		
	}

}
