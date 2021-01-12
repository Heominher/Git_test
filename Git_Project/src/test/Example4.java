package test;

import java.awt.Color;
import java.awt.Dimension;
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
class DrawPanel extends JPanel  //그림 그리기 위한 기본 드로링 클래스 선언
{
	public void paint(Graphics g){
		super.paint(g);
//		g.drawRect(50, 50, 100, 150);   // 사각형 그리기 함수 (시작 x좌표, 시작 y좌표, 가로, 세로)
//		g.drawOval(50, 50, 120, 120);   // 원형 그리기 함수 (시작 x좌표, 시작 y좌표, 가로, 세로)  가로*세로 크기의 내접하는 원을 그린다.
		g.drawLine(10, 10, 100, 20);    // 선 그리기 함수 (시작 x,y좌표   끝x,y좌표)
		
	}
}
