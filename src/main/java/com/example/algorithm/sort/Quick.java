package com.example.algorithm.sort;

import java.util.Arrays;

/**
 *@DATE Mar 14, 2020
 *@AUTHOR michael
 *@DESC  快速排序(单轴排序)|双轴排序 思路:在一个数组中将要排序的数组分割成独立的两部分,其中一部分的数据比另一部分的所有数据都要小,然后递归此方法对这两部分数据进行快速排序
 */
public class Quick {

	public static void main(String[] args) {
		int[] arr =  {4,10,5,3,7};
		quick(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	
	private static void quick(int[] arr,int low,int high) {
		if(low >= high)  return  ;
		int mid= partion(arr, low, high);
		quick(arr,low,mid-1);//左区间递归快速排序
		quick(arr,mid+1,high); //右区间递归快速排序
	}
	
	/**
	 * @param arr 待排序数据
	 * @param leftAxis 最小下标
	 * @param rightAxis 最大下标
	 */
	public static int partion(int[] arr,int low,int high) {
		int pivot = arr[high];//中间轴数
		
		int i = low;
		int j = high-1;
		
		while(i <= j) {
			while(i <=j && pivot < arr[j]) {//指针往左
				j--;
			}
			if(i <=j) {
				swap(arr,i++,j);
			}
			while(i <=j && arr[i] <= pivot) {//指针往右
				i++;
			}
			if(i <=j) {
				swap(arr,i,j--);
			}
			//System.out.println("------------------i="+i);
			System.out.println(Arrays.toString(arr));
		}
		swap(arr,i,j);
		return i;
	}
	
	//位置交换
	public static void swap(int[] arr ,int a,int b) {
		int temp = arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	
	

}
