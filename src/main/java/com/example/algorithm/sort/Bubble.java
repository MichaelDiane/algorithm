package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author michael
 *
 */
public class Bubble {
	
	public static void main(String[] args) {
		int[] arr =  {2,1,3,5,4,9,0};
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}
	//冒泡排序
	public static void sort(int[] arr) {
		for (int i = arr.length-1; i>0;i--) {
			for (int j = 0; j < i; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}			
		}
	}
}
