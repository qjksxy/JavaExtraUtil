package main;

import java.math.BigDecimal;
/*
 * ������չ��
 * �����Ľ�������������������������range��������ȷ�ĸ��������㷽��
 * @author qjk
 * @author qjksxy@163.com
 * @version 0.1
 */
public class EU {
	/*
	 * �Ľ���������������ܶ����������ÿ�������������
	 * @param obj ������Ķ��������
	 * @return �޷���ֵ
	 * @throws ���쳣
	 */
	public static void println(Object... obj) {
		for(Object o : obj) {
			System.out.println(o);
		}
	}
	/*
	 * ��д���������
	 * @return �޷���ֵ
	 * @throws ���쳣
	 */
	public static void printf(String format, Object... obj) {
		System.out.printf(format, obj);
	}
	/*
	 * �Ľ���������������ܶ����������ÿ���������������������", "���
	 * @param obj ������Ķ��������
	 * @return �޷���ֵ
	 * @throws ���쳣
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
	 * ����һ����0��ʼ��int����
	 * @param len ָ�����鳤��
	 * @return ��0��ʼ������Ϊlen������
	 * @throws ���쳣
	 */
	public static int[] range(int len) {
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index;
		}
		return array;
	}
	/*
	 * ����һ��int����
	 * @param begin ������ʼֵ(����)
	 * @param end �������ֵ(������)
	 * @return ��begin��ʼ����end������int����
	 * @throws BaseException ������begin����ڲ���endʱ�׳����쳣
	 */
	public static int[] range(int begin, int end) throws BaseException {
		if(begin > end) {
			throw new BaseException("range: begin ���� end");
		}
		final int len = end-begin;
		int[] array = new int[len];
		for(int index=0; index<len; index++) {
			array[index] = index + begin;
		}
		return array;
	}
	/*
	 * ����һ��int����
	 * @param begin ������ʼֵ(����)
	 * @param end �������ֵ(������)
	 * @param step ��������Ԫ��֮���ֵ
	 * @return ��begin��ʼ����end������int����
	 * @throws BaseException ������begin����ڲ���endʱ�׳����쳣
	 */
	public static int[] range(int begin, int end, int step) throws BaseException {
		if(begin > end) {
			throw new BaseException("range: begin ���� end");
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
	 * ���о�ȷ����ļӷ�����
	 * @param addend1 ��һ������
	 * @param addend2 �ڶ�������
	 * @return �ӷ�����ĺ�
	 * @throws ���쳣
	 */
	public static double add(double addend1, double addend2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(addend1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(addend2);
		return bigdecimal1.add(bigdecimal2).doubleValue();
	}
	/*
	 * ���о�ȷ����ļ�������
	 * @param minuend ������
	 * @param subtrahend ����
	 * @return ��������Ĳ�
	 * @throws ���쳣
	 */
	public static double sub(double minuend, double subtrahend) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(minuend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(subtrahend);
		return bigdecimal1.subtract(bigdecimal2).doubleValue();
	}
	/*
	 * ���о�ȷ����ĳ˷�����
	 * @param multiplier1 ��һ������
	 * @param multiplier2 �ڶ�������
	 * @return �˷�����Ļ�
	 * @throws ���쳣
	 */
	public static double mul(double multiplier1, double multiplier2) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(multiplier1);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(multiplier2);
		return bigdecimal1.multiply(bigdecimal2).doubleValue();
	}
	/*
	 * ���о�ȷ����ĳ�������
	 * @param dividend ������
	 * @param divisor ����
	 * @param scale ���㾫��
	 * @return ����������̣�ĩβ��������
	 * @throws ���쳣
	 */
	public static double div(double dividend, double divisor, int scale) {
		BigDecimal bigdecimal1 = BigDecimal.valueOf(dividend);
		BigDecimal bigdecimal2 = BigDecimal.valueOf(divisor);
		return bigdecimal1.divide(bigdecimal2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
