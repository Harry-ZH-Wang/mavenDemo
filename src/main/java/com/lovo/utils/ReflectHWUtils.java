package com.lovo.utils;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


public class ReflectHWUtils {

	/***
	 * get all field ,including fields in father/super class
	 * 
	 * @param clazz
	 * @return
	 */
	public static List<Field> getAllFieldList(Class<?> clazz) {
		List<Field> fieldsList = new ArrayList<Field>();// return object
		if (clazz == null) {
			return null;
		}

		Class<?> superClass = clazz.getSuperclass();// father class
		if (!superClass.getName().equals(Object.class.getName()))/*
																 * java.lang.Object
																 */{

			// System.out.println("has father");
			fieldsList.addAll(getAllFieldList(superClass));// Recursive
		}
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			// 排除因实现Serializable 接口而产生的属性serialVersionUID
			if (!field.getName().equals("serialVersionUID")) {
				fieldsList.add(field);
			}
		}
		return fieldsList;
	}

	/***
	 * 设置对象的属性值。
	 * 
	 * @param obj
	 * @param propertyName
	 *            : property name
	 * @param propertyValue
	 *            : value of property
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void setObjectValue(Object obj, String propertyName,
			String propertyValue) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		if (StringUtils.isEmpty(propertyName)
				|| StringUtils.isEmpty(propertyValue)) {
			return;
		}
		Class<?> clazz = obj.getClass();
		Field name = getSpecifiedField(clazz, propertyName);
		name.setAccessible(true);
		name.set(obj, propertyValue);

	}

	/***
	 * 利用反射设置对象的属性值. 注意:属性可以没有setter 方法.
	 * 
	 * @param obj
	 * @param params
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void setObjectValue(Object obj, Map<String, Object> params)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		if (ValueWidget.isNullOrEmpty(params)) {
			return;
		}
		Class<?> clazz = obj.getClass();
		for (Iterator it = params.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
			String key = entry.getKey();
			Object propertyValue = entry.getValue();
			if (ValueWidget.isNullOrEmpty(propertyValue)) {
				continue;
			}
			Field name = getSpecifiedField(clazz, key);
			if (name != null) {
				name.setAccessible(true);
				name.set(obj, propertyValue);
			}
		}

	}

	/***
	 * Get Specified Field
	 * 
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	public static Field getSpecifiedField(Class<?> clazz, String fieldName) {
		Field f = null;
		if (ValueWidget.isNullOrEmpty(clazz)) {
			return null;
		}
		try {
			f = clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			return getSpecifiedField(clazz.getSuperclass()/*
														 * may be null if it is
														 * Object .
														 */, fieldName);
			// e.printStackTrace();
		}
		return f;
	}

	/***
	 * 获取指定对象的属性值
	 * 
	 * @param obj
	 * @param name
	 *            :Field
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getObjectValue(Object obj, Field name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {

		// Field f = getSpecifiedField(obj.getClass(), name.getName());
		if (name == null) {
			System.out.println("[ReflectHWUtils.getObjectValue]"
					+ obj.getClass().getName() + " does not has field " + name);
			return null;
		}
		name.setAccessible(true);
		return name.get(obj);
	}

	/***
	 * 获取指定对象的属性值
	 * 
	 * @param obj
	 * @param propertyName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getObjectValue(Object obj, String propertyName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		if (StringUtils.isEmpty(propertyName)) {
			return null;
		}
		Class<?> clazz = obj.getClass();
		Field name = getSpecifiedField(clazz, propertyName);
		if (ValueWidget.isNullOrEmpty(name)) {
			System.out.println("[ReflectHWUtils.getObjectValue]"
					+ obj.getClass().getName() + " does not has field "
					+ propertyName);
			return null;
		}
		return getObjectValue(obj, name);
	}

	/***
	 * Determine whether the object's fields are empty
	 * 
	 * @param obj
	 * @param isExcludeZero  :true:数值类型的值为0,则当做为空;----false:数值类型的值为0,则不为空
	 * 
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static boolean isNullObject(Object obj, boolean isExcludeZero)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException {
		List<Field> fieldList = ReflectHWUtils.getAllFieldList(obj.getClass());
		boolean isNull = true;
		for (int i = 0; i < fieldList.size(); i++) {
			Field f = fieldList.get(i);
			Object propertyValue = null;
			try {
				propertyValue = getObjectValue(obj, f);
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}

			if (!ValueWidget.isNullOrEmpty(propertyValue)) {// 字段不为空
				if (propertyValue instanceof Integer) {// 是数字
					if (!((Integer) propertyValue == 0 && isExcludeZero)) {
						isNull = false;
						break;
					}
				} else if (propertyValue instanceof Double) {// 是数字
					if (!((Double) propertyValue == 0 && isExcludeZero)) {
						isNull = false;
						break;
					}
				}else if (propertyValue instanceof Float) {// 是数字
					if (!((Float) propertyValue == 0 && isExcludeZero)) {
						isNull = false;
						break;
					}
				}else if (propertyValue instanceof Short) {// 是数字
					if (!((Short) propertyValue == 0 && isExcludeZero)) {
						isNull = false;
						break;
					}
				}else {
					isNull = false;
					break;
				}
			}
		}
		return isNull;
	}

	/***
	 * 判断两个对象的属性值是否都相等.
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static boolean isSamePropertyValue(Object obj1, Object obj2)
			throws SecurityException, IllegalArgumentException,
			NoSuchFieldException, IllegalAccessException {
		List<String> exclusiveProperties = null;
		return isSamePropertyValue(obj1, obj2, exclusiveProperties);
	}

	/***
	 * 判断两个对象的属性值是否都相等.
	 * 
	 * @param obj1
	 * @param obj2
	 * @param exclusiveProperty
	 *            or String[]
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static boolean isSamePropertyValue(Object obj1, Object obj2,
			String... exclusiveProperty) throws SecurityException,
			IllegalArgumentException, NoSuchFieldException,
			IllegalAccessException {
		List<String> exclusiveProperties = new ArrayList<String>();
		exclusiveProperties.addAll(Arrays.asList(exclusiveProperty));
		return isSamePropertyValue(obj1, obj2, exclusiveProperties);
	}

	/***
	 * 判断两个对象的属性值是否都相等.
	 * 
	 * @param obj1
	 * @param obj2
	 * @param exclusiveProperties
	 *            : 要过滤的属性
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	public static boolean isSamePropertyValue(Object obj1, Object obj2,
			List<String> exclusiveProperties) throws SecurityException,
			IllegalArgumentException, NoSuchFieldException,
			IllegalAccessException {
		List<Field> fieldsList = getAllFieldList(obj1.getClass());
		for (int i = 0; i < fieldsList.size(); i++) {
			Field f = fieldsList.get(i);
			if ((!ValueWidget.isNullOrEmpty(exclusiveProperties))
					&& exclusiveProperties.contains(f.getName())) {// 过滤掉，不比较
				continue;
			}
			Object propertyValue1 = getObjectValue(obj1, f);
			Object propertyValue2 = getObjectValue(obj2, f);

			System.out.println(f.getName());
			if (propertyValue1 == propertyValue2) {// if propertyValue1 is null
				continue;
			}
			if (!isSameBySimpleTypes(propertyValue1, propertyValue2)) {
				return false;
			}
		}
		return true;
	}

	/***
	 * 比较java 基本类型的值是否相同.
	 * 
	 * @param obj1
	 *            : String,Integer,Double,Boolean
	 * @param obj2
	 * @return
	 */
	public static boolean isSameBySimpleTypes(Object obj1, Object obj2) {
		if (obj1 == obj2) {
			return true;
		}
		if (obj1 instanceof Integer) {// int
			Integer int1 = (Integer) obj1;
			Integer int2 = (Integer) obj2;
			return int1.intValue() == int2.intValue();
		} else if (obj1 instanceof Double) {// double
			Double double1 = (Double) obj1;
			Double double2 = (Double) obj2;
			return double1.compareTo(double2) == 0;
		} else if (obj1 instanceof Boolean) {// double
			Boolean boolean1 = (Boolean) obj1;
			Boolean boolean2 = (Boolean) obj2;
			return boolean1.compareTo(boolean2) == 0;
		} else if (obj1 instanceof String) {
			String str1 = (String) obj1;
			String str2 = (String) obj2;
			return str1.equals(str2);
		} else if (obj1 instanceof Timestamp) {
			Timestamp time1 = (Timestamp) obj1;
			Timestamp time2 = (Timestamp) obj2;
			return time1.compareTo(time2) == 0;
		} else if (obj1 instanceof java.util.Date) {
			java.util.Date time1 = (java.util.Date) obj1;
			java.util.Date time2 = (java.util.Date) obj2;
			return time1.compareTo(time2) == 0;
		} else if (obj1 instanceof java.sql.Date) {
			java.sql.Date time1 = (java.sql.Date) obj1;
			java.sql.Date time2 = (java.sql.Date) obj2;
			return time1.compareTo(time2) == 0;
		}
		return obj1 == obj2;
	}

	

}
