package com.example.algorithm.sort;

import java.util.Arrays;

/**
 *@DATE Mar 14, 2020
 *@AUTHOR michael
 *@DESC  快速排序(单轴排序)|双轴排序 思路:在一个数组中将要排序的数组分割成独立的两部分,其中一部分的数据比另一部分的所有数据都要小,然后递归此方法对这两部分数据进行快速排序
 */
public class Quick {

	public static void main(String[] args) {
		int[] arr =  {1,4,6,7,10,2,3,5,8,9};
		sort(arr,0,arr.length-1);
	}
	
	/**
	 * @param arr 待排序数据
	 * @param leftAxis 最小下标
	 * @param rightAxis 最大下标
	 */
	public static void sort(int[] arr,int leftAxis,int rightAxis) {
		int mid = (rightAxis+leftAxis)/2;
		int left = leftAxis;
		int right = rightAxis-1;
		int axis = arr[mid];//中间轴数
		while(left < right) {
			while(left < right && axis > arr[left]) {//轴数<左边,数据往右移动,指针往左
				left++;
			}
			while(left < right && axis < arr[right]) {//轴数>右,数据往左移动,指针往右
				right--;
			}
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right]= temp;
			}
			
		}
		System.out.println(Arrays.toString(arr));
	}

}
