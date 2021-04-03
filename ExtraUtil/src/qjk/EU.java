package qjk;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
/**
 * 扩展类ExtraUtil
 * 
 * <p>包括改进的输入输出方法，产生整数数组的range方法，精确的浮点数计算方法等</p>
 * @author qjk
 * @author qjksxy@163.com
 * @version 0.4
 */
public class EU {
	
	private EU() {}
	
	private static Scanner sc;
	private static int lineNumbers = 0;
	private static boolean printLineNumbers = false;
	private static final File file = new File("settings.xml");
	private static String separator = ">>";
	private static boolean clearBlank = true;
	static {
		if(file.exists()) {
			try {
				Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
				Element root = doc.getDocumentElement();
		        Element pLN = (Element) root.getElementsByTagName("printLineNumber").item(0);
		        Element sep = (Element) root.getElementsByTagName("separator").item(0);
		        Element clearB = (Element) root.getElementsByTagName("clearBlank").item(0);
		        if(pLN.getTextContent().contentEquals("true")) {
		        	EU.printLineNumbers = true;
		        }
		        if(clearB.getTextContent().contentEquals("false")) {
		        	EU.clearBlank = false;
		        }
		        EU.separator = sep.getTextContent();
			} catch (SAXException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }else {
        	System.err.println("WARN:Cannot find 'settings.xml'");
        }
	}
	private static Scanner getSc() {
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		return sc;
	}
	
	private static int getLN() {
		lineNumbers++;
		return lineNumbers;
	}
	
	private static void printLN() {
		System.out.print(printLineNumbers?(getLN()+separator):"");
	}
	
	private static String replaceBlank(String str) {
		if(str.equals("")) {
			return "";
		}else {
			String dest;
			Pattern p = Pattern.compile("\\s*");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
			return dest;
		}
	}
	/**
	 * 设置在输出时是否显示行号，默认不显示
	 * @param b 在输出时是否显示行号
	 */
	public static void setLN(boolean b) {
		printLineNumbers = b;
	}
	
	/**
	 * 设置行号与待输出文本之间的间隔符
	 * @param separator 间隔符
	 */
	public static void setSep(String separator) {
		EU.separator = separator;
	}
	
	/**
	 * 打印对象数组，独占一行输出，中间以", "间隔，并以方括号包裹
	 * <p>该方法有对基本数据类型的重载</p>
	 * @param <T> 任意类
	 * @param arr 任意数组对象
	 */
	public static <T> void printArr(T[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(int[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(long[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(short[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(char[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(float[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(double[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(boolean[] arr) {
		printLN();
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 改进的输出方法，接受多个参数，对每个参数换行输出
	 * @param obj 欲输出的对象或数据 
	 */
	public static void println(Object... obj) {
		for(Object o : obj) {
			printLN();
			System.out.println(o);
		}
	}
	/**
	 * 简写的输出方法
	 * @param format 与System.out.printf方法中相同
	 * @param obj 与System.out.printf方法中相同
	 */
	public static void printf(String format, Object... obj) {
		printLN();
		System.out.printf(format, obj);
	}
	/**
	 * 改进的输出方法，接受多个参数，对每个参数不换行输出，并以", "间隔
	 * @param obj 欲输出的对象或数据
	 */
	public static void print(Object... obj) {
		int i;
		printLN();
		for(i=0; i<obj.length-1; i++) {
			System.out.print(obj[i]);
			System.out.print(", ");
		}
		System.out.print(obj[i]);
	}
	/**
	 * 设置方法scanLine获取字符串时是否清空前空白
	 * @param b 是否清空前空白
	 */
	public static void setCB(boolean b) {
		EU.clearBlank = b;
	}
	
	/**
	 * 获取一个byte类型输入数据
	 * <p>请在使用结束后统一调用close方法</p>
	 * @return 读取到的byte值
	 */
	public static byte scanByte() {
		return getSc().nextByte();
	}
	/**
	 * 获取一个int类型输入数据
	 * <p>请在使用结束后统一调用close方法</p>
	 * @return 读取到的int值
	 */
	public static int scanInt() {
		return getSc().nextInt();
	}
	/**
	 * 获取一个double类型输入数据
	 * <p>请在使用结束后统一调用close方法</p>
	 * @return 读取到的double值
	 */
	public static double scanDouble() {
		return getSc().nextDouble();
	}
	/**
	 * 获取一个String类型输入数据
	 * <p>请在使用结束后统一调用close方法</p>
	 * @return 读取到的String值
	 */
	public static String scanString() {
		if(EU.clearBlank) {
			return EU.replaceBlank(getSc().next());
		}else {
			return getSc().next();
		}
	}
	/**
	 * 获取一行输入
	 * <p>请在使用结束后统一调用close方法</p>
	 * @return 读取到的字符串
	 */
	public static String scanLine() {
		if(EU.clearBlank) {
			return EU.replaceBlank(getSc().nextLine());
		}else {
			return getSc().nextLine();			
		}
	}
	/**
	 * 请在调用scan类方法后调用，以释放资源
	 */
	public static void close() {
		if(sc != null)
			sc.close();
	}
	/**
	 * 生成一个从0开始的int数组
	 * @param len 指定数组长度
	 * @return 从0开始，长度为len的数组
	 */
	public static int[] range(int len) {
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index;
		}
		return array;
	}
	/**
	 * 生成一个int数组
	 * <p>如果begin大等于end，会自动交换这两个值</p>
	 * @param begin 数组起始值(包含)
	 * @param end 数组结束值(不包含)
	 * @return 从begin开始，至end结束的int数组
	 */
	public static int[] range(int begin, int end) {
		if(begin >= end) {
			int t = end;
			end = begin;
			begin = t;
		}
		final int len = end-begin;
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index + begin;
		}
		return array;
	}
	/**
	 * 生成一个int数组
	 * <p>如果begin大等于end，会自动交换这两个值</p>
	 * @param begin 数组起始值(包含)
	 * @param end 数组结束值(不包含)
	 * @param step 数组相邻元素之间差值
	 * @return 从begin开始，至end结束的int数组
	 */
	public static int[] range(int begin, int end, int step) {
		if(begin >= end) {
			int t = end;
			end = begin;
			begin = t;
		}
		final int t = (end-begin)%step==0?0:1;
		final int len = (end-begin) / step + t;
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index*step + begin;
		}
		return array;
	}
	/**
	 * 进行精确计算的加法方法
	 * @param addend1 第一个加数
	 * @param addend2 第二个加数
	 * @return 加法运算的和
	 */
	public static double add(double addend1, double addend2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(addend1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(addend2);
		return bigdecimal1.add(bigdecimal2).doubleValue();
	}
	/**
	 * 进行精确计算的减法方法
	 * @param minuend 被减数
	 * @param subtrahend 减数
	 * @return 减法运算的差
	 */
	public static double sub(double minuend, double subtrahend) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(minuend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(subtrahend);
		return bigdecimal1.subtract(bigdecimal2).doubleValue();
	}
	/**
	 * 进行精确计算的乘法方法
	 * @param multiplier1 第一个乘数
	 * @param multiplier2 第二个乘数
	 * @return 乘法运算的积
	 */
	public static double mul(double multiplier1, double multiplier2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(multiplier1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(multiplier2);
		return bigdecimal1.multiply(bigdecimal2).doubleValue();
	}
	/**
	 * 进行精确计算的除法方法
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale 计算精度
	 * @return 除法运算的商，末尾四舍五入
	 */
	public static double div(double dividend, double divisor, int scale) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(dividend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(divisor);
		return bigdecimal1.divide(bigdecimal2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
