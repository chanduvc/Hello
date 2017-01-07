package com.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StringCount {

	public static void main(String[] args) {
		testSuit();
	}

	private static void testSuit() {
		List<String> list = new ArrayList<String>();
		for(int i=1;i<=4;i++){
			if(i==1){
					String result=test(uniqueCount("This is a test TeSt"),2);
					String cons="Test"+i+ " "+"Count words with a repeated word but different case." + "         "+"Result" +" "+ result;
					System.out.println(cons);
					list.add(result);
					}
			if(i==2){
					String result=test(uniqueCount(",,"), 0);
					String cons="Test"+i+" "+"Count words in an empty string with separator." +"             "+"Result"+ " "+result;
					System.out.println(cons);
					list.add(result);
					}
			if(i==3){
				String result=test(uniqueCount("The Web Accessibility Initi^ative (WAI) describes the strategy for prelimi%^nary and confor,mance re		views of web site"), 2);
				String cons="Test"+i+" "+"Count words in with reperated word but diffrent delimeters and diffrent case  " +"             "+"Result"+ " "+result;
				System.out.println(cons);
				list.add(result);
					}
			
			if(i==4){
				String result=test(uniqueCount("india is a conutry,india is:subcontinent,india.india-india capital delhi	india "), 6);
				String cons="Test"+i+" "+"Count words in with reperated word but diffrent delimeters and diffrent case  " +"             "+"Result"+ " "+result;
				System.out.println(cons);
				list.add(result);
					}
		}
		
		if(list.contains("NOK")){
			System.out.println("Overall result is                              FAIL ");
		}else{
			System.out.println("Overall result is                              PASS");
		}
		}

	private static String test(int uniqueCount, int i) {
		String result=null;
		if(uniqueCount==i){
			result="OK";
		}else{
			result="NOK";
		}
		return result;
		
	}

	private static int uniqueCount(String str1) {
		String[] test1 = str1.split("[\\-.,\\s\\t]");
		int length = test1.length;
		int count = 0;
		Map<String, Integer> strMap = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		if (str1 != null && str1.length() > 0) {
			if (length <= 255) {
				for (String str : test1) {
					if (strMap.containsKey(str)) {
						strMap.put(str, strMap.get(str) + 1);
					} else {
						strMap.put(str, 1);
					}

				}

				Set<String> strSet = strMap.keySet();
				for (String str2 : strSet) {
					if (strMap.get(str2)>1) {
						count=strMap.get(str2);
					}
				}

			} else {
				try {
					throw new InvalidLengthException(
							"The given string contains more than 255 words!!!!");
				} catch (InvalidLengthException e) {
					System.out.println(e);

				}
			}
		}
		return count;
	}
}
