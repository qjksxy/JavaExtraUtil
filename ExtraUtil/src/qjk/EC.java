package qjk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * <p>ExtraCollection，简单的创建各种常用的容器对象</p>
 * 避免了重复的泛型参数列表
 * @author qjk
 * @author qjksxy@163.com
 */
public class EC {

	private EC() {}
	
	public static <K, V> Map<K, V> map(){
		return new HashMap<K, V>();
	}
	
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	
	public static <T> LinkedList<T> lList(){
		return new LinkedList<T>();
	}
	
	public static <T> Queue<T> queue(){
		return new LinkedList<T>();
	}
	
	public static <T> Set<T> set(){
		return new HashSet<T>();
	}

}
