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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
        }
        System.out.println(outputfile.getAbsolutePath());
		while(true) {
			//1.����ServerSocket���󣬰󶨶˿ڣ���ʼ�ȴ�����
	        ServerSocket ss;
			try {
				ss = new ServerSocket(7700);
				//2.��������accept����������socket����
		        Socket server = ss.accept();
				//3.ͨ��Socket���󣬻�ȡ������
				InputStream is = server.getInputStream();
		        //4 һ���Զ�ȡ����
		        //4.1 �����ֽ�����
		        byte[] b = new byte[1024];
		        //4.2 ���ݶ�ȡ���ֽ�������
		        int len = is.read(b);
		        if(len!=0) {
		        	//4.3 �������飬��ӡ�ַ�����Ϣ
		        	String msg = new String(b, 0, len);
			        FileWriter fw = new FileWriter("output.txt", true);
			        fw.write(new Date().toString() + ": " + msg + "\n");
			        fw.close();
		        }
		        //5.�ر���Դ
		        is.close();
		        ss.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	        
		}
		
        
        
	}
}
