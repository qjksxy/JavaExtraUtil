import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public Client() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) throws Exception{
		
		System.out.println("�ͻ��˷�������");
        //1.����Socket��ip,port����ȷ�����ӵ�����
        Socket client=new Socket("127.0.0.1", 7700);
        //2.��ȡ������.�����
        OutputStream os=client.getOutputStream();
        //3.д������
        os.write("".getBytes());
        //4.�ر���Դ
        os.close();
        client.close();
	}
}
