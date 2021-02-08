package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator2 {

	public static void main(String[] args) {
		
		Dimension dim = new Dimension(400,500);
		
		JFrame frame = new JFrame("Calculator");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
		
		JPanel top = new JPanel();
		top.setOpaque(true);
		top.setBackground(Color.black);
		
		
		
		
		//===============================================수식 입력  부분=============================================//
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BoxLayout(pan1, BoxLayout.X_AXIS));
		
		JLabel label1 = new JLabel("수식을 입력하세요");
		label1.setFont(new Font("고딕", Font.BOLD, 20));
		label1.setForeground(Color.white);
		pan1.setOpaque(true);
		pan1.setBackground(Color.black);
		pan1.add(label1);
		
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2, BoxLayout.X_AXIS));
		JLabel result = new JLabel("");
		result.setFont(new Font("고딕", Font.BOLD, 20));
		result.setForeground(Color.white);
//		result.setHorizontalAlignment(SwingConstants.RIGHT);   ????왜 위치가 안돼지??
		pan2.setOpaque(true);
		pan2.setBackground(Color.black);
		pan2.add(result);
		
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.setOpaque(true);
		center.setBackground(Color.BLACK);
		
		center.add(pan1);
		center.add(pan2);
		
		//===============================================수식 입력 부분=============================================//
		
		
		
		
		
		
		
		
		//===============================================숫자판 부분=============================================//
		GridLayout grid = new GridLayout(4,4,4,4);
		JPanel bottom = new JPanel();
		bottom.setOpaque(true);
		bottom.setBackground(Color.black);
		bottom.setLayout(grid);

		
		JButton[] bt = new JButton[16];
		bt[0] = new JButton("7");
		bt[1] = new JButton("8");
		bt[2] = new JButton("9");
		bt[3] = new JButton("÷");
		
		bt[4] = new JButton("4");
		bt[5] = new JButton("5");
		bt[6] = new JButton("6");
		bt[7] = new JButton("×");
		
		bt[8] = new JButton("1");
		bt[9] = new JButton("2");
		bt[10] = new JButton("3");
		bt[11] = new JButton("-");
		
		bt[12] = new JButton("C");
		bt[13] = new JButton("0");
		bt[14] = new JButton("=");
		bt[15] = new JButton("+");
		
		
		Color orage = new Color(0xea9648);
		Color whitegray = new Color(0xc0c0c0);
		
		for(int i=0; i<=15;i++){
			
			bt[i].setFont(new Font("고딕",Font.BOLD,25));
			bt[i].setBackground(Color.gray);
			bt[i].setForeground(Color.white);
			bottom.add(bt[i]);
			if(i==3||i==7||i==11||i==15){
				bt[i].setFont(new Font("고딕",Font.BOLD,25));
				bt[i].setBackground(orage);
				bt[i].setForeground(Color.white);
			}
			else if(i==14||i==12){
				bt[i].setFont(new Font("고딕",Font.BOLD,25));
				bt[i].setBackground(whitegray);
				bt[i].setForeground(Color.white);
			}
		}
		//===============================================숫자판 부분=============================================//
		
		
		
		
		
		
		
		
		
		
		
		
		
		//===============================================계산 기능 부분=============================================//
		try {
			
			for(int j=0; j<=15;j++){
				
				bt[j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						String text = result.getText();
						String text1 = e.paramString().substring(21, 22);  //해당 버튼 문자열 가져오기
						result.setText(text+text1);
						
						if(text1.equals("C")){    //==============================지우기 버튼 눌렀을시 내용 삭제
							result.setText("");
						}
						if(text1.equals("=")){   //=====================================계산 결과 확인시!!!
							result.setText("");

							
							int idx = 0;
							int resut = 0;
							String num1;
							String num2;
							
								if(text.indexOf("+",0) !=-1 ){   //더하기 일 경우
									resut = 0;
									idx = text.indexOf("+"); //인덱스값 찾아내기
									
									num1 = text.substring(0,idx);  //앞 부분 숫자 추출
									num2 = text.substring(idx+1);     //뒷부분 숫자 추출
									
									resut = Integer.parseInt(num1) + Integer.parseInt(num2);  //더하기!
									
									label1.setText("더하기 결과 입니당~");
									result.setText(String.valueOf(resut));
									
								}
								if(text.indexOf("-",0) !=-1 ){   //빼기 일 경우
									resut = 0;
									idx = text.indexOf("+"); //인덱스값 찾아내기
									
									num1 = text.substring(0,idx);  //앞 부분 숫자 추출
									num2 = text.substring(idx+1);     //뒷부분 숫자 추출
									
									resut = Integer.parseInt(num1) - Integer.parseInt(num2);  //빼기!
									label1.setText("빼기 결과 입니당~");
									result.setText(String.valueOf(resut));
									
								}
								if(text.indexOf("×",0) !=-1 ){   //곱하기 일 경우
									resut = 1;
									String data[] = text.split("×");
									for(int y=0; y<data.length; y++){
										resut = resut * Integer.valueOf(data[y]);
									}
									label1.setText("곱하기 결과 입니당~");
									result.setText(String.valueOf(resut));
								}
								if(text.indexOf("÷",0) !=-1 ){   //나누기 일 경우   
									double resut1 = 0;
									String data1[] = text.split("÷");
									for(int y=1; y<data1.length; y++){
										resut1 = Float.valueOf(data1[y-1]) / Float.valueOf(data1[y]);
									}
									label1.setText("나누기 결과 입니당~");
									result.setText(String.valueOf(resut1).substring(0, 3));
								}
							
							
						}						//=====================================계산 결과 확인시!!!
						
						text1 = null;  //값 초기화 버튼 누를때마다 들어가기때문에 한번쓰고 초기화!
					}
				});
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errrrr");
		}
		//===============================================계산 기능 부분=============================================//
		
		
		
		
		
		
		frame.setResizable(false); // 창크기 수정불가
		frame.add(center, BorderLayout.CENTER);
		frame.add(top,BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.SOUTH);
		
		
		frame.pack();
		frame.setVisible(true);
		
		
		
		

	}

}
