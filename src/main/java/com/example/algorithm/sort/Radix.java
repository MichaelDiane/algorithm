package com.example.algorithm.sort;

import java.util.Arrays;

/**
 *@DATE Mar 14, 2020
 *@AUTHOR michael
 *@DESC  基数排序:
 *		多关键词排序|桶排序思想 其思路为从个位数分桶,其次 十位数,百位数...若数据的长度不同时以最长的排起;不足的前面补0.
 *		基数排序有低位优先和高位优先两种: LSD[记数算法思想]、 MSD[属于分治思想]
 *		
 */
public class Radix {

	public static void main(String[] args) {
		
		int[] arr =  {412,211,323,335,334,449,406};
		sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static int[] sort(int[] arr) {
		int[] result =  new int[arr.length];
		int[] count = new int[10];
		int maxNum = arr[0];
		for (int number : arr) {
			if(maxNum < number) {
				maxNum = number;
			}
		}
		System.out.println("maxNum="+maxNum);
		
		System.out.println("length="+String.valueOf(maxNum).length());
		
		for (int i = 0; i < String.valueOf(maxNum).length(); i++) {
			int division =  (int) Math.pow(10, i);
			System.out.println("division="+division);
			for (int j = 0; j < arr.length; j++) {
				int num = arr[j]/division % 10;
				System.out.println(num+" ");
				count[num]++;
			}
			
			//计数排序算法
			System.out.println(Arrays.toString(count));
			for (int z = 1; z < count.length; z++) {
				count[z] = count[z]+count[z-1];
			}
			System.out.println(Arrays.toString(count));
			
			for (int n = arr.length-1; n >0 ; n--) {
				int num = arr[n]/division % 10;
				result[--count[num]] = arr[n];
			}
			
			System.arraycopy(result, 0, arr, 0, arr.length);
			Arrays.fill(count, 0);
			System.out.println(Arrays.toString(count));
		}
		return result;
	}

}
