package main;

import java.math.BigDecimal;
/*
 * 基本扩展类
 * 包括改进的输出方法，产生整数数组的range方法，精确的浮点数计算方法
 * @author qjk
 * @author qjksxy@163.com
 * @version 0.1
 */
public class EU {
	/*
	 * 改进的输出方法，接受多个参数，对每个参数逐行输出
	 * @param obj 欲输出的对象或数据
	 * @return 无返回值
	 * @throws 无异常
	 */
	public static void println(Object... obj) {
		for(Object o : obj) {
			System.out.println(o);
		}
	}
	/*
	 * 简写的输出方法
	 * @return 无返回值
	 * @throws 无异常
	 */
	public static void printf(String format, Object... obj) {
		System.out.printf(format, obj);
	}
	/*
	 * 改进的输出方法，接受多个参数，对每个参数不换行输出，并以", "间隔
	 * @param obj 欲输出的对象或数据
	 * @return 无返回值
	 * @throws 无异常
	 */
	public static void print(Object... obj) {
		int i;
		for(i=0; i<obj.length-1; i++) {
			System.out.print(obj[i]);
			System.out.print(", ");
		}
		System.out.print(obj[i]);
	}
	/*
	 * 生成一个从0开始的int数组
	 * @param len 指定数组长度
	 * @return 从0开始，长度为len的数组
	 * @throws 无异常
	 */
	public static int[] range(int len) {
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index;
		}
		return array;
	}
	/*
	 * 生成一个int数组
	 * @param begin 数组起始值(包含)
	 * @param end 数组结束值(不包含)
	 * @return 从begin开始，至end结束的int数组
	 * @throws BaseException 当参数begin大等于参数end时抛出此异常
	 */
	public static int[] range(int begin, int end) throws BaseException {
		if(begin > end) {
			throw new BaseException("range: begin 大于 end");
		}
		final int len = end-begin;
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index + begin;
		}
		return array;
	}
	/*
	 * 生成一个int数组
	 * @param begin 数组起始值(包含)
	 * @param end 数组结束值(不包含)
	 * @param step 数组相邻元素之间差值
	 * @return 从begin开始，至end结束的int数组
	 * @throws BaseException 当参数begin大等于参数end时抛出此异常
	 */
	public static int[] range(int begin, int end, int step) throws BaseException {
		if(begin > end) {
			throw new BaseException("range: begin 大于 end");
		}
		final int t = (end-begin)%step==0?0:1;
		final int len = (end-begin) / step + t;
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index*step + begin;
		}
		return array;
	}
	/*
	 * 进行精确计算的加法方法
	 * @param addend1 第一个加数
	 * @param addend2 第二个加数
	 * @return 加法运算的和
	 * @throws 无异常
	 */
	public static double add(double addend1, double addend2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(addend1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(addend2);
		return bigdecimal1.add(bigdecimal2).doubleValue();
	}
	/*
	 * 进行精确计算的减法方法
	 * @param minuend 被减数
	 * @param subtrahend 减数
	 * @return 减法运算的差
	 * @throws 无异常
	 */
	public static double sub(double minuend, double subtrahend) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(minuend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(subtrahend);
		return bigdecimal1.subtract(bigdecimal2).doubleValue();
	}
	/*
	 * 进行精确计算的乘法方法
	 * @param multiplier1 第一个乘数
	 * @param multiplier2 第二个乘数
	 * @return 乘法运算的积
	 * @throws 无异常
	 */
	public static double mul(double multiplier1, double multiplier2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(multiplier1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(multiplier2);
		return bigdecimal1.multiply(bigdecimal2).doubleValue();
	}
	/*
	 * 进行精确计算的除法方法
	 * @param dividend 被除数
	 * @param divisor 除数
	 * @param scale 计算精度
	 * @return 除法运算的商，末尾四舍五入
	 * @throws 无异常
	 */
	public static double div(double dividend, double divisor, int scale) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(dividend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(divisor);
		return bigdecimal1.divide(bigdecimal2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
