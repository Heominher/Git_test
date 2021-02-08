package newserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatGUIServer {

    // 클라이언트와 연결할 때만 필요한 ServerSocket 클래스
    ServerSocket ss;

    // 서버로 접속한 클라이언트 Socket을 저장할 멤버 변수
    Socket s;

    // 접속 클라이언트 정보 실시간 저장
    Vector v;

    // ServerThread 자료형 멤버 변수 선언, has-a 관계 설정을 위함
    ServerThread st;
    
    static int joinnum = 0;
    String joinname;
    
    static String listname="";
    
    static ArrayList<String> userlist= new ArrayList<String>();//실시간 유저 배열 선언

    public static JLabel label2 = new JLabel("");
    public static JTextArea txtLog = new JTextArea();
    public static JFrame mainserverframe = new JFrame("Server");
    // 생성자, 멤버 변수 초기화
    public ChatGUIServer() {
        // 사용자 정보를 담을 v를 Vector 객체로 초기화
        v = new Vector();
        

        // 접속이 될 수도 있고 안 될 수도 있기 때문에 예외 처리
        try {
        	
            // ServerSocket 객체 생성 → 포트 번호 생성(임의의 번호 부여)
        	ss = new ServerSocket(8888);
            System.out.println("ss>>>" + ss);
            System.out.println("채팅 서버 가동중...");
            
            Dimension dim = new Dimension(400,500);
    		
            mainserverframe.setLocation(200, 400);
            mainserverframe.setPreferredSize(dim);
    		
    		JPanel top = new JPanel();
    		top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));
    		top.setOpaque(true);
    		top.setBackground(Color.pink);
    		
	        JButton closebtn = new JButton("서버 종료");
	        closebtn.setOpaque(true);
	        closebtn.setBackground(Color.black);
	        closebtn.setFont(new Font("고딕", Font.BOLD, 20));
	        closebtn.setForeground(Color.white);
	        
	        top.add(closebtn);
    		
    		JLabel label0 = new JLabel("");
    		label0.setFont(new Font("고딕", Font.BOLD, 25));
    		label0.setForeground(Color.black);
    		top.add(label0);
    		label0.setText("채팅 서버 가동중...");

    		JLabel label3 = new JLabel("");
    		label3.setFont(new Font("고딕", Font.BOLD, 13));
    		label3.setForeground(Color.black);
    		top.add(label3);
    		label3.setText("서버 정보 : "+ss);
    		
    		
    		JPanel center = new JPanel();
    		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
    		center.setOpaque(true);
    		center.setBackground(Color.yellow);
    		
    		JLabel label1 = new JLabel("현재 사용자는 : ");
    		label1.setFont(new Font("고딕", Font.BOLD, 25));
    		label1.setForeground(Color.red);
    		
    		label2.setText(joinnum+"명 접속중");
    		label2.setFont(new Font("고딕", Font.BOLD, 25));
    		label2.setForeground(Color.blue);
    		
    		txtLog.setForeground(Color.pink);
    		txtLog.setFont(new Font("고딕", Font.BOLD, 25));
    		txtLog.setEditable(false);
    		JScrollPane scrollPane = new JScrollPane(txtLog);
    		
    		center.add(label1);
    		center.add(label2);
    		center.add(scrollPane);
    		
    		
    		mainserverframe.add(top,BorderLayout.NORTH);
    		mainserverframe.add(center,BorderLayout.CENTER);
    		
    		mainserverframe.setResizable(false); // 창크기 수정불가
    		mainserverframe.pack();
    		mainserverframe.setVisible(true);
    		
    		closebtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
            
            // 서버 가동: 클라이언트가 접속할 때까지 기다리는 것(무한 대기)
            while (true) {
                // 접속 클라이언트 Socket을 s 변수에 저장
                s = ss.accept();
               
                System.out.println("Accepted from" + s);

                // 접속 클라이언트와 서버로 st객체 생성
                st = new ServerThread(this, s);
                joinname = st.name;
                txtLog.append(joinname+"님이 연결되었습니다.\n");
                txtLog.setCaretPosition(txtLog.getDocument().getLength());// 맨아래로 스크롤한다

                // 접속할 때마다 v에 접속 클라이언트 스레드 추가
                this.addThread(st);

                // Thread 가동 -> run() -> broadCast() -> send() 실시간 메소드 호출
                st.start();
            }

        } catch (Exception e) {
            // 접속 실패시 간단한 Error 메세지 출력
            System.out.println("서버 접속 실패>>>" + e);
        }
    }

    // 벡터 v에 접속 클라이언트의 스레드 저장
    public void addThread(ServerThread st) {
    	userlist.add(st.name);
    	System.out.println("@@@@@@@@@현재 접속 유저는 : "+userlist);
        v.add(st);
        joinnum +=1;
        label2.setText(joinnum+"명 접속중");
    }

    // 퇴장한 클라이언트 스레드 제거
    public void removeThread(ServerThread st) {
    	userlist.remove(st.name);
    	System.out.println("!!!!!!!!!퇴장후 접속자는 : "+userlist);
        v.remove(st);
        joinnum -=1;
        label2.setText(joinnum+"명 접속중");
    }

    // 각 클라이언트에게 메세지를 출력하는 메소드, send() 호출
    public void broadCast(String str) {
        for (int i = 0; i < v.size(); i++) {
            // 각각의 클라이언트를 ServerThread 객체로 형 변환 
            ServerThread st = (ServerThread) v.elementAt(i);
            // 각 스레드 객체에 str 문자열을 전송
            st.send(str);
        }
    }
//    static JFrame serverframe = new JFrame("Client");
//    public static void server(){
//    	
//    	Dimension dim = new Dimension(200,170);
//    	serverframe.setLocation(200, 400);
//    	serverframe.setPreferredSize(dim);
//		JPanel top = new JPanel();
//		top.setOpaque(true);
//		top.setBackground(Color.black);
//		JButton onbtn = new JButton("ON");
//		onbtn.setFont(new Font("고딕",Font.BOLD,40));
//		onbtn.setBackground(Color.black);
//		onbtn.setForeground(Color.white);
//		onbtn.setHorizontalAlignment(SwingConstants.CENTER);
//		JButton offbtn = new JButton("OFF");
//		offbtn.setFont(new Font("고딕",Font.BOLD,40));
//		offbtn.setBackground(Color.black);
//		offbtn.setForeground(Color.white);
//		offbtn.setHorizontalAlignment(SwingConstants.CENTER);
//		top.add(onbtn);
//		top.add(offbtn);
//		serverframe.add(top,BorderLayout.CENTER);
//		serverframe.setResizable(false); // 창크기 수정불가
//		serverframe.pack();
//		serverframe.setVisible(true);
//		
//		
//		try {
//			onbtn.addActionListener(new ActionListener() {  //on버튼 클릭 시
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					new ChatGUIServer();  //서버 실행
//				}
//			});
//			
//			offbtn.addActionListener(new ActionListener() {  //off버튼 클릭 시
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					mainserverframe.setVisible(false);
//					mainserverframe.dispose();
//				}
//			});
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//    }
    
    

    public static void main(String[] args) {
        // 익명 객체 생성
        new ChatGUIServer();

    }

}