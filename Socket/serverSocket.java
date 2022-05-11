import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;

public class serverSocket extends Thread {
	
	private static final Logger logger = Logger.getLogger(SocketThreadServer.class);
	
	private Socket socket;

	public SocketThreadServer(Socket socket){
		this.socket=socket;
	}
	
	// Thread server
	public void run(){
		BufferedReader br = null;
		PrintWriter pw = null;
		try{
			String ipCheck = socket.getInetAddress().getHostAddress();
			System.out.println(ipCheck + "에서 연결 시도.");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			
			// 클라이언트에서 보낸 문자열 출력
			System.out.println(br.readLine());
			
			// 클라이언트에 문자열 전송
			pw.println("받음 from SERVER");
			pw.flush();		
		}catch(IOException e){
			logger.error(e);
		}finally{
			try{
				if(pw != null) { pw.close();}
				if(br != null) { br.close();}
				if(socket != null){socket.close();}
			}catch(IOException e){
				logger.error(e);
			}
		}
	}
}
