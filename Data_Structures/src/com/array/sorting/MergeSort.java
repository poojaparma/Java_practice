package com.array.sorting;

public class MergeSort {

	public static void main(String[] args) {
	int arr[]={0,5,4,1/*,59,3,44,21,34,21*/};
	int temp[]= new int[10];
	
	int lower=0;
	int higher=arr.length-1;
	arraySort(arr,temp,0 ,higher);
	
	for ( int i = 0; i < 4; i++) {
		 System.out.println("value array" + arr[i] );
   }
}

private static void arraySort(int A[],int temp[],int left ,int right) {
	if(left<right){
	int mid=(right+left)/2;
	arraySort(A,temp,left,mid);
	arraySort(A,temp,mid+1, right);
	mergeSort( A, temp,left,mid+1,right);
	}
}

private static void mergeSort(int A[],int tempMergArr[],int left, int middle, int right) {
	int i,left_end,temp_pos,size;
	left_end=middle-1;
	temp_pos=left;
	size=right-left+1;
	while(left<=left_end && middle<=right){
		if(A[left]<=A[middle]){
			tempMergArr[temp_pos]=A[left];
			temp_pos=temp_pos+1;
			left=left+1;
		}else{
			tempMergArr[temp_pos]=A[middle];
			temp_pos=temp_pos+1;
			middle=middle+1;
		}
	}while(left<=left_end){
		tempMergArr[temp_pos]=A[left];
		temp_pos=temp_pos+1;
		left=left+1;
	}
	while(middle<=right){
		tempMergArr[temp_pos]=A[middle];
		temp_pos=temp_pos+1;
		middle=middle+1;
	}
	for ( i = 0; i < size; i++) {
		 A[i]=tempMergArr[i] ;
		 System.out.println("value array" + A[i] +"size: "+size);
		 right=right-1;
    }
	
}
}
