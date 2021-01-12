package test;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

class DrawPanel extends JPanel  //그림 그리기 위한 기본 드로링 클래스 선언
{
//	@Override
	public void paint(Graphics g){
		super.paint(g);
//		g.drawRect(50, 50, 100, 150);   // 사각형 그리기 함수 (시작 x좌표, 시작 y좌표, 가로, 세로)
//		g.drawOval(50, 50, 120, 120);   // 원형 그리기 함수 (시작 x좌표, 시작 y좌표, 가로, 세로)  가로*세로 크기의 내접하는 원을 그린다.
//		g.drawLine(10, 10, 100, 100);    // 선 그리기 함수 (시작 x,y좌표   끝x,y좌표)
		
		
		//===============================글짜 셋팅하기!!======================================//
//		g.setFont(new Font("궁서", Font.BOLD,40));   //  (1) 글자 셋팅
//		g.drawString("HerMinHyeok", 50, 50);       //  (2) 글자 그리기  !!)꼭 셋팅하고 그리기!!
		//===============================글짜 셋팅하기!!======================================//
		
		
		
		//===============================이미지 셋팅하기!!======================================//
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Heomh\\Desktop\\good.png");
		g.drawImage(img, 50, 50, this);
		//===============================이미지 셋팅하기!!======================================//
		
		
		
		
		
	}
}
