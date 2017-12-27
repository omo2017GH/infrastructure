package cn.com.omo.infrastructure.common.util.collection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hezh
 *
 */
public class ListUtils {

	public static <T> List<T> ArrayToList(T[] array) {
		List<T> list = new ArrayList<T>(Arrays.asList(array));
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] ListToArray(List<T> list, Class<T> classType) {
		if (list == null) {
			return null;
		}

		if (list.isEmpty()) {
			return (T[]) list.toArray((T[]) Array.newInstance(classType, 0));
		}

		T[] array = (T[]) list.toArray((T[]) Array.newInstance(classType, list.size()));
		return array;
	}
}
