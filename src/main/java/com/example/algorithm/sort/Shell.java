package com.example.algorithm.sort;

import java.util.Arrays;

/**
 *@DATE Mar 14, 2020
 *@AUTHOR michael
 *@DESC  希尔排序「核心思路是多了一个间隔数;其他的思路与插入排序思路一致;其中gap要不断变小至1;gap定义多少合适呢?可以借鉴 Knuth 序列思路」
 */
public class Shell {

	public static void main(String[] args) {
		int[] arr =  {2,1,3,5,4,9,0,11,10,8,20,15,24,23,17,14};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 =  {2,1,3,5,4,9,0,11,10,8,20,15,24,23,17,14};
		knuthSort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
	//希尔排序
	public static void sort(int[] arr) {
		int h=1;
		while (h<arr.length/3) {
			h=3*h+1;
		}
		//位移处理方式:其实就是 arr.length / 2;或者 h [效率高]
		for (int gap = arr.length >> 1; gap >0; gap = gap/2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i; j > gap-1; j=j-gap) {
					if(arr[j]< arr[j-gap]) {
						int temp = arr[j];
						arr[j]=arr[j-gap];
						arr[j-gap]=temp;
					}
				}
			}
		}
	}
	//希尔排序,Knuth 序列间隔排序
	public static void knuthSort(int[] arr) {
		//Knuth 序列思想
		int h=1;
		while (h<arr.length/3) {
			h=3*h+1;
		}
		//Knuth 序列[效率高]
		for (int gap = h; gap >0; gap = (gap-1)/3) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i; j > gap-1; j=j-gap) {
					if(arr[j]< arr[j-gap]) {
						int temp = arr[j];
						arr[j]=arr[j-gap];
						arr[j-gap]=temp;
					}
				}
			}
		}
	}
}
