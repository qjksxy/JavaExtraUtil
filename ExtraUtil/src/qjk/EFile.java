package qjk;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * 扩展类ExtraFile
 * 
 * <p>将文件读写打包成单方法</p>
 * @author qjk
 * @author qjksxy@163.com
 * @version 0.3
 */
public class EFile {
	private EFile() {}

	/**
	 * 读文件内容，返回文件所有内容
	 * @param filepath 文件路径
	 * @return 文件内容
	 */
	public static String readFile(String filepath) {
		File f = new File(filepath);
		if(!f.exists()) {
			System.err.println("文件不存在: "+f.getAbsolutePath());
			return "";
		}
		String[] str = {""};
		try {
			
			Stream<String> lines = Files.lines(Paths.get(filepath));
			List<String> content = lines.collect(Collectors.toList());
			content.forEach(x -> str[0] = str[0]+ x +"\n");
			lines.close();

		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return str[0];
	}
}
