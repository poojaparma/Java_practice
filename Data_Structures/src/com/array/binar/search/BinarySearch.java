package com.array.binar.search;

public class BinarySearch {
public static void main(String[] args) {
	BinarySearch bn = new BinarySearch();
	int Arr[] ={1,2,3,4,5,6};
System.out.println("searching result: " + Arr[bn.binarySearch(Arr,6,5)]);
System.out.println("searching result: " + Arr[bn.binaryRecSearch(Arr,0,5,5)]);
}

private int binarySearch(int[]arr,int n,int data){
int low=0;
int high=n-1;
while(low<=high){
int mid =low+(high-low/2);//to avoid overflow
if(arr[mid]==data){
	return mid;
}else if(arr[mid]<data){
	low=mid+1;
	
}else{
	high=mid-1;
}
}	return -1;
}
//Binar search with recursive call
private int binaryRecSearch(int[]arr,int low,int high,int data){

int mid =low+(high-low/2);//to avoid overflow
if(arr[mid]==data){
	return mid;
}else if(arr[mid]<data){
return binaryRecSearch(arr, mid+1,high, data);	
}else{
	return binaryRecSearch(arr, low,mid-1, data);		
}
}
}
