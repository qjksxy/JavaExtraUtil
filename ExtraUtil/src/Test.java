import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;



public class Test {

	public Test() { 
	}
	public static void main(String[] args) {
        File outputfile = new File("output.txt");
        if(!outputfile.exists()) {
        	try {
				outputfile.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
        System.out.println(outputfile.getAbsolutePath());
		while(true) {
			//1.创建ServerSocket对象，绑定端口，开始等待连接
	        ServerSocket ss;
			try {
				ss = new ServerSocket(7700);
				//2.接收连接accept方法，返回socket对象
		        Socket server = ss.accept();
				//3.通过Socket对象，获取输入流
				InputStream is = server.getInputStream();
		        //4 一次性读取数据
		        //4.1 创建字节数组
		        byte[] b = new byte[1024];
		        //4.2 数据读取到字节数组中
		        int len = is.read(b);
		        if(len!=0) {
		        	//4.3 解析数组，打印字符串信息
		        	String msg = new String(b, 0, len);
			        FileWriter fw = new FileWriter("output.txt", true);
			        fw.write(new Date().toString() + ": " + msg + "\n");
			        fw.close();
		        }
		        //5.关闭资源
		        is.close();
		        ss.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	        
		}
		
        
        
	}
}
