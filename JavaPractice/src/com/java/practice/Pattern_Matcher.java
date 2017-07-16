package com.java.practice;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern_Matcher {
public static void main(String[] args) {
	int arr[]= {2,1,3,3,3,2,3,3,2,4,4};
	Arrays.sort(arr);
	String str="(( sddd))))))))))))";
	String ptr ="(" ;
	String ptr1=")";
	
	Pattern pattern = Pattern.compile(Pattern.quote(ptr));
    Matcher matcher = pattern.matcher(str);
	Pattern pattern1 = Pattern.compile(Pattern.quote(ptr1));
    Matcher matcher1 = pattern1.matcher(str);

int count=0;
int count1=0;
    while(matcher.find()){
	count++;
	//matcher.group();
}
    while(matcher1.find()){
    	count1++;
    //	matcher1.group();
    }
    int i = count-count1;
System.out.println("value is : " + i) ;
}
}
