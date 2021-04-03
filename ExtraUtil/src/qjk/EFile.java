package qjk;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * ��չ��ExtraFile
 * 
 * <p>���ļ���д����ɵ�����</p>
 * @author qjk
 * @author qjksxy@163.com
 * @version 0.3
 */
public class EFile {
	private EFile() {}

	/**
	 * ���ļ����ݣ������ļ���������
	 * @param filepath �ļ�·��
	 * @return �ļ�����
	 */
	public static String readFile(String filepath) {
		File f = new File(filepath);
		if(!f.exists()) {
			System.err.println("�ļ�������: "+f.getAbsolutePath());
			return "";
		}
		String[] str = {""};
		try {
			
			Stream<String> lines = Files.lines(Paths.get(filepath));
			List<String> content = lines.collect(Collectors.toList());
			content.forEach(x -> str[0] = str[0]+ x +"\n");
			lines.close();

		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return str[0];
	}
}
