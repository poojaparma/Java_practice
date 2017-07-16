package com.array.binar.search;

public class QuickSort {
	static int  array[]={0,5/*,4,1,59,3,44,21,34,21*/};
	int temp[]= new int[10];
public static void main(String[] args) {
	

	
	
	int lower=0;
	int higher=array.length-1;
	arraySort(lower ,higher);
	
for(int i=0;i<higher;i++){
	System.out.println("print: " + array[i]);
}
}

private static void arraySort( int lowerIndex, int higherIndex) {
	// TODO Auto-generated method stub
	 int i = lowerIndex;
     int j = higherIndex;
     // calculate pivot number, I am taking pivot as middle index number
     int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
  
     while(i<=j){
     while(i<pivot){
    	 i++;
     }
     while(j>pivot){
    	 j++;
     }
	if(i<=j){
		exchange(i,j);
		i++;
		j--;
	}
	 // call quickSort() method recursively
    if (lowerIndex < j)
    	arraySort(lowerIndex, j);
    if (i < higherIndex)
    	arraySort(i, higherIndex);
     }
}


private static void exchange(int i,int j) {
	   int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
	
}

}
