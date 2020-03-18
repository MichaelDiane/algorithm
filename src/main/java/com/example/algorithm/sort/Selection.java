package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序算法
 * @author michael
 */
public class Selection {
	
	public static void main(String[] args) {
		int[] arr =  {2,1,3,5,4,9,0};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	//选择排序实现
	public static void sort(int[] arr) {
		for(int i = 0;i<arr.length-1;i++) {
			int flat=i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					flat=j;
				}
			}
			int temp =  arr[i];
			arr[i]=arr[flat];
			arr[flat]=temp;
		}
	}

}
