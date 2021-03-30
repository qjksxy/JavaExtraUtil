package qjk;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 扩展类ExtraUtil
 * 
 * <p>包括改进的输入输出方法，产生整数数组的range方法，精确的浮点数计算方法</p>
 * @author qjk
 * @author qjksxy@163.com
 * @version 0.2.2
 */
public class EU {
	private EU() {}
	private static Scanner sc;
	private static Scanner getSc() {
		if(sc == null) {
			sc = new Scanner(System.in);
		}
		return sc;
	}
	
	/**
	 * 打印对象数组，独占一行输出，中间以", "间隔，并以方括号包裹
	 * <p>该方法有对基本数据类型的重载</p>
	 * @param <T> 任意类
	 * @param arr 任意数组对象
	 */
	public static <T> void printArr(T[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(long[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(short[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(char[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(float[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(double[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void printArr(boolean[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	/**
	 * 改进的输出方法，接受多个参数，对每个参数换行输出
	 * @param obj 欲输出的对象或数据 
	 */
	public static void println(Object... obj) {
		for(Object o : obj) {
			System.out.println(o);
		}
	}
	/**
	 * 简写的输出方法
	 * @param format 与System.out.printf方法中相同
	 * @param obj 与System.out.printf方法中相同
	 */
	public static void printf(String format, Object... obj) {
		System.out.printf(format, obj);
	}
	/**
	 * 改进的输出方法，接受多个参数，对每个参数不换行输出，并以", "间隔
	 * @param obj 欲输出的对象或数据
	 */
	public static void print(Object... obj) {
		int i;
		for(i=0; i<obj.length-1; i++) {
			System.out.print(obj[i]);
			System.out.print(", ");
		}
		System.out.print(obj[i]);
	}
	/**
	 * 获取一个char类型输入数据
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
		return getSc().next();
	}
	/**
	 * 获取一行输入
	 * <p>请在使用结束后统一调用close方法</p>
	 * @return 读取到的字符串
	 */
	public static String scanLine() {
		return getSc().nextLine();
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
	 * @param begin 数组起始值(包含)
	 * @param end 数组结束值(不包含)
	 * @return 从begin开始，至end结束的int数组
	 * @throws BaseException 当参数begin大等于参数end时抛出此异常
	 */
	public static int[] range(int begin, int end) throws BaseException {
		if(begin >= end) {
			throw new BaseException("range: begin 大等于 end");
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
	 * @param begin 数组起始值(包含)
	 * @param end 数组结束值(不包含)
	 * @param step 数组相邻元素之间差值
	 * @return 从begin开始，至end结束的int数组
	 * @throws BaseException 当参数begin大等于参数end时抛出此异常
	 */
	public static int[] range(int begin, int end, int step) throws BaseException {
		if(begin >= end) {
			throw new BaseException("range: begin 大等于 end");
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
