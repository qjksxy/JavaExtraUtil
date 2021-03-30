package qjk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 扩展类ExtraFile
 * 
 * <p>将文件读写打包成单方法</p>
 * @author qjk
 * @author qjksxy@163.com
 * @version 0.2.1
 */
public class EFile {
	private EFile() {}

	public static String fileRead(String filepath) {
		String text = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
			byte[] b = new byte[1024];
			int i = fis.read(b);
			while (i != -1) {
				text += new String(b);
				i = fis.read(b);
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return text;
	}
}
