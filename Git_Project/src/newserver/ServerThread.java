package newserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ServerThread extends Thread {
	
    // 클라이언트 소켓 저장
    Socket s;

    // ChatGUIServer 클래스의 객체를 멤버 변수로 선언, has-a 관계를 위함
    ChatGUIServer cg;

    // 입출력
    BufferedReader br;
    PrintWriter pw;

    // 전달할 문자열
    String str;

    // 대화명(ID)
    String name;

    // 생성자
    public ServerThread(ChatGUIServer cg, Socket s) {
        /* cg = new ChatGUIServer(); → 작성 불가, 서버가 두 번 가동되기 때문에 충돌이 일어남
        따라서 매개변수를 이용해서 객체를 얻어온(call by reference) 뒤에 cg와 s값을 초기화해야 함
        */
        this.cg = cg;
        
        // 접속한 클라이언트 정보 저장
        this.s = s;
       
        

        // 데이터 전송을 위한 입출력 스트림 생성
        try {
            // =========== 입력 ===========
            // s.getInputStream() => 접속 클라이언트(소켓 객체)의 InputStream을 얻어 옴
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            // =========== 출력 ===========
            /*
            BufferedWriter의 경우 버퍼링 기능을 가지기 때문에 PrintWriter 스트림 사용
            PrintWriter 스트림의 경우 생성자의 두 번째 인자로 autoFlush 기능을 지정할 수 있음
            BufferedWriter를 사용하는 경우 flush() 메소드를 사용해야 함
            */
            pw = new PrintWriter(s.getOutputStream(), true);
            name = br.readLine();
            System.out.println("이름정보를 가져옴!!"+name);
            cg.broadCast("\n===== " + name  + "님 입장"+" =====\n");
//            cg.broadCast("member-이민혁");
            
        } catch (Exception e) {
            System.out.println("에러 발생>>>>>" + e);
        }
    }

    // 메세지(입력 문자열) 출력 메소드
    public void send(String str) {
        // 문자열 출력
        pw.println(str);
        // 혹시나 버퍼에 남아있는 것을 비워냄
        pw.flush();
    }
    // run()_ServerThread -> broadCast(str)_ChatGUIServer -> send(str)_ServerThread
    public void run() {
        try {
        	 cg.broadCast("member-"+cg.userlist);

            // 무한 대기하며 입력한 메세지를 각 클라이언트에 계속 전달
            while ((str = br.readLine()) != null) {
        		cg.broadCast(name +"님 (☞ﾟヮﾟ)☞ " + str);
            }
        } catch (Exception e) {
            // 접속자 퇴장시 v에서 해당 클라이언트 스레드 제거
            cg.removeThread(this); // this: ServerThread 객체, 접속 클라이언트
             // 서버에서 각 클라이언트에 출력
            cg.broadCast("member-"+cg.userlist);
            cg.broadCast("\n===== " + name  + "님 퇴장"+" =====\n");
            System.out.println("현재 몇명?? : "+cg.joinnum);
            
            cg.txtLog.append(name + "님이 퇴장했습니다.\n");
            cg.txtLog.setCaretPosition(cg.txtLog.getDocument().getLength());// 맨아래로 스크롤한다
            // 콘솔에 퇴장 클라이언트 IP 주소 출력
            System.out.println(s.getInetAddress() + "의 연결이 종료됨!");
        }
    }

}
