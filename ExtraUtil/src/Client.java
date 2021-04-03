import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public Client() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) throws Exception{
		
		System.out.println("客户端发送数据");
        //1.创建Socket（ip,port），确定连接到哪里
        Socket client=new Socket("127.0.0.1", 7700);
        //2.获取流对象.输出流
        OutputStream os=client.getOutputStream();
        //3.写出数据
        os.write("".getBytes());
        //4.关闭资源
        os.close();
        client.close();
	}
}
