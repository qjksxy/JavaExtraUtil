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
 * ��չ��ExtraUtil
 * 
 * <p>�����Ľ�����������������������������range��������ȷ�ĸ��������㷽����</p>
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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO �Զ����ɵ� catch ��
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
	 * ���������ʱ�Ƿ���ʾ�кţ�Ĭ�ϲ���ʾ
	 * @param b �����ʱ�Ƿ���ʾ�к�
	 */
	public static void setLN(boolean b) {
		printLineNumbers = b;
	}
	
	/**
	 * �����к��������ı�֮��ļ����
	 * @param separator �����
	 */
	public static void setSep(String separator) {
		EU.separator = separator;
	}
	
	/**
	 * ��ӡ�������飬��ռһ��������м���", "��������Է����Ű���
	 * <p>�÷����жԻ����������͵�����</p>
	 * @param <T> ������
	 * @param arr �����������
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
	 * �Ľ���������������ܶ����������ÿ�������������
	 * @param obj ������Ķ�������� 
	 */
	public static void println(Object... obj) {
		for(Object o : obj) {
			printLN();
			System.out.println(o);
		}
	}
	/**
	 * ��д���������
	 * @param format ��System.out.printf��������ͬ
	 * @param obj ��System.out.printf��������ͬ
	 */
	public static void printf(String format, Object... obj) {
		printLN();
		System.out.printf(format, obj);
	}
	/**
	 * �Ľ���������������ܶ����������ÿ���������������������", "���
	 * @param obj ������Ķ��������
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
	 * ���÷���scanLine��ȡ�ַ���ʱ�Ƿ����ǰ�հ�
	 * @param b �Ƿ����ǰ�հ�
	 */
	public static void setCB(boolean b) {
		EU.clearBlank = b;
	}
	
	/**
	 * ��ȡһ��byte������������
	 * <p>����ʹ�ý�����ͳһ����close����</p>
	 * @return ��ȡ����byteֵ
	 */
	public static byte scanByte() {
		return getSc().nextByte();
	}
	/**
	 * ��ȡһ��int������������
	 * <p>����ʹ�ý�����ͳһ����close����</p>
	 * @return ��ȡ����intֵ
	 */
	public static int scanInt() {
		return getSc().nextInt();
	}
	/**
	 * ��ȡһ��double������������
	 * <p>����ʹ�ý�����ͳһ����close����</p>
	 * @return ��ȡ����doubleֵ
	 */
	public static double scanDouble() {
		return getSc().nextDouble();
	}
	/**
	 * ��ȡһ��String������������
	 * <p>����ʹ�ý�����ͳһ����close����</p>
	 * @return ��ȡ����Stringֵ
	 */
	public static String scanString() {
		if(EU.clearBlank) {
			return EU.replaceBlank(getSc().next());
		}else {
			return getSc().next();
		}
	}
	/**
	 * ��ȡһ������
	 * <p>����ʹ�ý�����ͳһ����close����</p>
	 * @return ��ȡ�����ַ���
	 */
	public static String scanLine() {
		if(EU.clearBlank) {
			return EU.replaceBlank(getSc().nextLine());
		}else {
			return getSc().nextLine();			
		}
	}
	/**
	 * ���ڵ���scan�෽������ã����ͷ���Դ
	 */
	public static void close() {
		if(sc != null)
			sc.close();
	}
	/**
	 * ����һ����0��ʼ��int����
	 * @param len ָ�����鳤��
	 * @return ��0��ʼ������Ϊlen������
	 */
	public static int[] range(int len) {
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index;
		}
		return array;
	}
	/**
	 * ����һ��int����
	 * <p>���begin�����end�����Զ�����������ֵ</p>
	 * @param begin ������ʼֵ(����)
	 * @param end �������ֵ(������)
	 * @return ��begin��ʼ����end������int����
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
	 * ����һ��int����
	 * <p>���begin�����end�����Զ�����������ֵ</p>
	 * @param begin ������ʼֵ(����)
	 * @param end �������ֵ(������)
	 * @param step ��������Ԫ��֮���ֵ
	 * @return ��begin��ʼ����end������int����
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
	 * ���о�ȷ����ļӷ�����
	 * @param addend1 ��һ������
	 * @param addend2 �ڶ�������
	 * @return �ӷ�����ĺ�
	 */
	public static double add(double addend1, double addend2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(addend1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(addend2);
		return bigdecimal1.add(bigdecimal2).doubleValue();
	}
	/**
	 * ���о�ȷ����ļ�������
	 * @param minuend ������
	 * @param subtrahend ����
	 * @return ��������Ĳ�
	 */
	public static double sub(double minuend, double subtrahend) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(minuend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(subtrahend);
		return bigdecimal1.subtract(bigdecimal2).doubleValue();
	}
	/**
	 * ���о�ȷ����ĳ˷�����
	 * @param multiplier1 ��һ������
	 * @param multiplier2 �ڶ�������
	 * @return �˷�����Ļ�
	 */
	public static double mul(double multiplier1, double multiplier2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(multiplier1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(multiplier2);
		return bigdecimal1.multiply(bigdecimal2).doubleValue();
	}
	/**
	 * ���о�ȷ����ĳ�������
	 * @param dividend ������
	 * @param divisor ����
	 * @param scale ���㾫��
	 * @return ����������̣�ĩβ��������
	 */
	public static double div(double dividend, double divisor, int scale) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(dividend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(divisor);
		return bigdecimal1.divide(bigdecimal2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
