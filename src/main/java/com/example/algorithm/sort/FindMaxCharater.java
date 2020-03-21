package com.example.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 *@DATE Mar 21, 2020
 *@AUTHOR michael
 *@DESC  找出字符串中次数出现最多的字符,若次数相同返回 acii最小的字符串
 */
public class FindMaxCharater {
	public static void main(String[] args) {
		String str = "aa121244";
		HashMap<Character, Integer> map =  new HashMap<Character, Integer>();
		for (int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}else {
				map.put(str.charAt(i), 1);
			}
		}
		HashMap<Character, Integer> resultMap =  new HashMap<Character, Integer>();
		int count=0;
		for (Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue() > count &&  resultMap.isEmpty()) {
				count = entry.getValue();
				resultMap.put(entry.getKey(), entry.getValue());
			} else if (entry.getValue()>count&&!resultMap.isEmpty())
            {
				resultMap.clear();
                count = entry.getValue();
                resultMap.put(entry.getKey(),entry.getValue());
            }
            else if(entry.getValue()==count)
            {
            	resultMap.put(entry.getKey(),entry.getValue());
            }
		}
		
		String maxChar = null;
		if(resultMap.size()>1) {
			List<Set<Entry<Character, Integer>>> entryList = Arrays.asList( resultMap.entrySet());
			Integer ascii = 0;
			Iterator< Entry<Character, Integer> > it = entryList.get(0).iterator();
			while(it.hasNext() ) {
				Entry<Character, Integer> en = it.next();
				ascii = Integer.valueOf(en.getKey());
				maxChar = en.getKey()+"";
			}
			
			for (int i=1;i<entryList.size();i++) {
				Iterator< Entry<Character, Integer> > it2	 = entryList.get(i).iterator();
				while(it2.hasNext() ) {
					Entry<Character, Integer> en = it2.next();
					if(ascii.compareTo(Integer.valueOf(en.getKey()+""))>0) {
						ascii = Integer.valueOf(en.getKey());
						maxChar = en.getKey()+"";
					}
				}
			}
			System.out.println("出现最多的:"+maxChar+",ascii = "+ascii);
		}else {
			for (Entry<Character, Integer> entry:resultMap.entrySet()) {
				maxChar = entry.getKey()+"";
				System.out.println("出现最多的:"+entry.getKey()+",次数="+entry.getValue());
			}
		}
	}
}