package General_Assignment_BTJB_opt2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class baiTap8 {
  public static void main(String[]args) {
	  Scanner input = new Scanner(System.in);
	  System.out.println("Nhập số lượng phần tử của ArrayList : ");	  int n = input.nextInt();
	  ArrayList<Integer> a = new ArrayList<>();
	  for (int i = 0; i < n; i++) {
          System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
         int element = input.nextInt();
         a.add(element);
	  }
	  int count = 0;
//	 short count = 	120;
//	 
//	 int c = (int) count;
//	 
//	 a.add(c);
//	 
//	 for (Integer i : a) {
//		System.out.println(i);
//	}
//	 
      for (int element : a) {
    	  if( element %2 > 0) {
    		  count ++;
    	  } 
          
      }System.out.println("Tổng số nguyên lẻ của mảng a = : " + count) ;
    
      
    
	
      ArrayList<Integer> b = new ArrayList<>();
      System.out.println("\n Nhập Số cần tìm trong mảng: ");
      int k = input.nextInt();
     for(int i = 0 ; i < a.size() ; i++) {
    	 if(k == a.get(i)) {
    		b.add(i+1);

    	 }
     }
    if (b.size() > 0 ) {
    	System.out.println("Vị Trí Của " + k + " Trong Mảng Là : " );
    	for (Integer integer : b) {
			System.out.print(integer + " ");
		}
		}  Collections.sort(a);
	      System.out.println("\nMảng A sau khi được sắp xếp : ");
	      for (Integer mangsx : a) {
			System.out.print(mangsx + " ");
    }
	   
	      System.out.println("\nHãy Nhập Phần Tử Cần Chèn Vào Mảng a : ");
	      int p = input.nextInt();
	     int vitri = 0;
	     while(vitri < a.size() && a.get(vitri)<p) {
	    	 vitri++;
			}a.add(vitri, p);
	     System.out.println("Mảng a Khi add thêm phần tử : ");
	      for (int j = 0;j < a.size() ; j++) {
				System.out.print(a.get(j) + " ");
	      }
	
  }    
  }

