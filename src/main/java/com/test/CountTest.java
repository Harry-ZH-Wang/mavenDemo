package com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Count 类
 * 
 * @author chenkun
 *
 */
public class CountTest {
	private String oneNum;// 第一个数
	private String twoNum;// 第二个数
	private String sum;// 计算后得数
	private char find;// 运算符

	public CountTest() {
		super();
	}

	public String getOneNum() {
		return oneNum;
	}

	public void setOneNum(String oneNum) {
		this.oneNum = oneNum;
	}

	public String getTwoNum() {
		return twoNum;
	}

	public void setTwoNum(String twoNum) {
		this.twoNum = twoNum;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public char getFind() {
		return find;
	}

	public void setFind(char find) {
		this.find = find;
	}

	public void count() {
		// BigDecimal提供的算术操作
		BigDecimal a = new BigDecimal(this.oneNum);
		BigDecimal b = new BigDecimal(this.twoNum);
		switch (this.find) {
		case '+':
			this.sum = a.add(b).toString();
			break;

		default:
			break;
		}
	}

	// 二次方程计算式，数学判断式
	public static double[] equation(int a, int b, int c) throws Exception {
		double i = 0;
		double s1 = 1.0;
		double s2 = 1.0;
		double[] ary = new double[2];
		i = b * b - 4 * a * c;
		if (i > 0) {// 大于等于零才有根
			ary[0] = ((-b) + Math.sqrt(i)) / (2 * a);// 解二次方程的通用式子
			ary[1] = ((-b) - Math.sqrt(i)) / (2 * a);

		} else if (i == 0) {
			ary[0] = (-b) / (2 * a);
		} else {
			throw new Exception("无实数解！！！！！!!!");
		}
		return ary;
	}

	// 插入排序：时间复杂度o(n^2)
	public static List insertSort(int[] array) {
		
		System.out.println("这是插入排序");
		//存放过程排序字符串
		List list = new ArrayList();
		for (int i = 1; i < array.length; i++)// 第0位独自作为有序数列，从第1位开始向后遍历
		{
			if (array[i] < array[i - 1])// 0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
			{
				int temp = array[i];// 保存第i位的值
				int k = i - 1;
				for (int j = k; j >= 0 && temp < array[j]; j--)// 从第i-1位向前遍历并移位，直至找到小于第i位值停止
				{
					array[j + 1] = array[j];
					k--;

				}
				array[k + 1] = temp;// 插入第i位的值
				System.out.println(temp);
				//存放排序过程数组
				StringBuffer tempBuffer = new StringBuffer();
				for(int b = 0;b<array.length;b++){
					tempBuffer.append(array[b]+" ");
				}
				list.add(tempBuffer.toString());
				System.out.println(tempBuffer.toString());
			}
			
		}
		return list;
	}
	/*
	 * public static List<int[]> insertSort(int a[]) { List<int[]> list = new
	 * ArrayList<int[]>(); for (int i = 0; i < a.length - 1; i++) { int temp =
	 * a[i]; int j = i - 1; while (j >= 0 && a[j] > temp) { a[j + 1] = a[j];
	 * --j; } a[j + 1] = temp; list.add(a); } return list; }
	 */

	// 快速排序：时间复杂度o(nlgn)
	public static List<int[]> quickSort(int arr[], int l, int r) {
		System.out.println("这是快速排序");
		List<int[]> list = new ArrayList<int[]>();
		if (l < r) {
			// Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
			int i = l, j = r, x = arr[l];
			while (i < j) {
				while (i < j && arr[j] >= x) // 从右向左找第一个小于x的数
					j--;
				if (i < j)
					arr[i++] = arr[j];

				while (i < j && arr[i] < x) // 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					arr[j--] = arr[i];
			}
			arr[i] = x;
			quickSort(arr, l, i - 1); // 递归调用
			quickSort(arr, i + 1, r);
			list.add(arr);
		}
		return list;
	}

	// 选择排序：时间复杂度o(n^2)
	public static List<int[]> selectSort(int a[]) {
		System.out.println("这是选择排序");
		List<int[]> list = new ArrayList<int[]>();
		int minIndex = 0;
		int temp = 0;
		if ((a == null) || (a.length == 0))
			return list;
		for (int i = 0; i < a.length - 1; i++) {
			minIndex = i;// 无序区的最小数据数组下标
			for (int j = i + 1; j < a.length; j++) {
				// 在无序区中找到最小数据并保存其数组下标
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				// 如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
				temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
			list.add(a);
			System.out.println(a[i]);
		}
		return list;
	}

	// 归并排序：时间复杂度o(nlgn)
	public static void mergeSort(int a[], int n) {
		System.out.println("这是归并排序");
		_mergeSort(a, 0, n - 1);
	}

	public static void _mergeSort(int a[], int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			_mergeSort(a, left, mid);
			_mergeSort(a, mid + 1, right);
			_merge(a, left, mid, right);
		}
	}

	public static void _merge(int a[], int left, int mid, int right) {
		int length = right - left + 1;
		int newA[] = new int[length];
		for (int i = 0, j = left; i <= length - 1; ++i, ++j) {
			newA[i] = a[j];
		}
		int i = 0;
		int j = mid - left + 1;
		int k = left;
		for (; i <= mid - left && j <= length - 1; ++k) {
			if (newA[i] < newA[j]) {
				a[k] = newA[i++];
			} else {
				a[k] = newA[j++];
			}
		}
		while (i <= mid - left) {
			a[k++] = newA[i++];
		}
		while (j <= right - left) {
			a[k++] = newA[j++];
		}
	}

}
