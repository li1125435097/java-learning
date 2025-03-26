import java.net.*;
import java.io.*;
//import java.util.concurrent.*;

public class TcpServer{
	private static final int PORT = 14567;
  public static void main(String[] args) throws IOException {
	try(ServerSocket ss = new ServerSocket(PORT)){
    		System.out.println("等待连接");
		while(true){
			Socket cli = ss.accept();
    			System.out.println("客户端接入："+cli.getInetAddress());

			BufferedReader in = new BufferedReader(new InputStreamReader(cli.getInputStream()));
			PrintWriter out = new PrintWriter(cli.getOutputStream(),true);
			
			String msg = in.readLine();
    			System.out.println("服务器收到："+msg);
			out.println("12123");

			cli.close();
		}

	}
  }
}
