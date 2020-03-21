package com.example.algorithm.sort;

import java.util.Arrays;

/**
 *@DATE Mar 14, 2020
 *@AUTHOR michael
 *@DESC  计算排序:思想-> 非比较排序,桶思想的一种适用场景:量大但是范围小 
 */
public class Counting {

	public static void main(String[] args) {
		int[] arr =  {2,1,3,5,4,9,0,1,5,7};
		int[] count = count(arr);
		System.out.println("count="+Arrays.toString(count));
		int[] result = sort(count);
		System.out.println("result="+Arrays.toString(result));
	}
	
	//即用下标映射其对于的数,统计每个数出现的次数,利用了数组下标的本身有序性进行排序
	public static int[] count(int[] arr) {
		int[] count =  new int[arr.length];
		for (int j = 0; j < count.length; j++) {
			for (int i=0; i< arr.length; i++) {
				if(j == arr[i]) {
					count[j] = count[j]+1;
				}
			}
		}
		return count;
	}
	//根据次数一次给一个新数组赋值
	public static int[] sort(int[] count) {
		int[] result =  new int[count.length];
		for (int i = 0,j=0; i < count.length; i++) {
			while(count[i]>0) {
				result[j++]=i;
				count[i]--;
			}
		}
		return result;
	}
}
