package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;


///테이블 생성 지우고 추가하기 예제
public class Example3 {

	public static void main(String[] args) {
		
		Dimension dim = new Dimension(400,250);
		
		JFrame frame = new JFrame("Example3's House");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		
		String header[] = {"학생이름", "국어","영어", "수학"};    //헤더는 1차원 배열
		String contents[][] = {                               //내용은 2차원 배열
				{"허민혁","90","89","100"},
				{"허민헐","80","54","87"},
				{"허민헐","80","54","87"},
				{"허민헐","80","54","87"},
				{"허민헐","80","54","87"},
				{"허민헐","80","54","87"},
				{"허민헐","80","54","87"},
				{"허민혹","70","15","23"}
		};
		DefaultTableModel model = new DefaultTableModel(contents,header);    //테이블 데이터 관리 리모컨 생성 (Step1)
		JTable table = new JTable(model);   //리모컨을 넘겨받아 데이블 정의   (Step2)
		JScrollPane scrollpane = new JScrollPane(table);    //스크롤 생성   (Step3)
		
//		table.setValueAt("손오공", 3, 0);  //테이블 컬럼값 셋팅 : (문자,세로줄, 가로줄);
//		System.out.println(table.getColumnName(0));   //헤더값 가져오기
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JTextField nameField = new JTextField(5);
		JTextField koreaField = new JTextField(3);
		JTextField englishField = new JTextField(3);
		JTextField mathField = new JTextField(3);
		
		panel.add(nameField);
		panel.add(koreaField);
		panel.add(englishField);
		panel.add(mathField);
		
		
		JButton btn1 = new JButton("추가");
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String input[] = new String[4];
				
				input[0] = nameField.getText();  //배열에 글짜 가져다가 넣기
				input[1] = koreaField.getText();
				input[2] = englishField.getText();
				input[3] = mathField.getText();
				model.addRow(input);  //모델 표에 글짜 추가하기
				
				nameField.setText("");  //글짜 초기화
				koreaField.setText("");  //글짜 초기화
				englishField.setText("");  //글짜 초기화
				mathField.setText("");  //글짜 초기화
				
				
			}
		});
		
		JButton btn2 = new JButton("삭제");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()== -1){  //로우가 배열의 시작0 아래시 리턴 처리하기
					return;
				}
				else
				{
					model.removeRow(table.getSelectedRow());  //선택된 셀 줄 지우기 없애기
				}
				
			}
		});
		panel.add(btn1);
		panel.add(btn2);
		
		
		
		

		
		
		frame.add(scrollpane,BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		
		
		
		frame.pack();
		frame.setVisible(true);
		

	}

}
