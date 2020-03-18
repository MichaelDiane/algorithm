package com.example.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author michael
 */
public class Insertion {

	public static void main(String[] args) {
		int[] arr =  {2,1,3,5,4,9,0};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//插入排序
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j >0; j--) {
				if(arr[j]<arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
