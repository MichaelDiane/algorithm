package com.example.algorithm.sort;

import java.util.Arrays;

/**
 *@DATE Mar 14, 2020
 *@AUTHOR michael
 *@DESC  归并排序的算法思路是将原有的数组通过递归分解子数组至最后一个数据[每个数据都是有序的],然后再合并一个数组的思路.这里写的是简版主要写的是核心的合并「归并」排序
 */
public class Merge {

	public static void main(String[] args) {
		int[] arr =  {1,4,6,7,10,2,3,5,8,9};
		System.out.println(Arrays.toString(sort(arr)));
	}
	
	public static int[] sort(int[] arr) {
		int tag = arr.length%2;
		int[] temp =  new int[arr.length];
		int i=0;
		int mid = arr.length/2 ;
		int j= (tag ==0 ? mid:mid+1);//祖数组进行子数组分割点
		int k=0;
		while (i<=mid && j<arr.length) {
			if(arr[i]<=arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		while ( i<= mid && k<temp.length) {
			temp[k++] = arr[i++];
		}
		while (j<arr.length && k<temp.length) {
			temp[k++] = arr[j++];
		}
		return temp;
	}
}
