package ex01_04;
/**
 * Bài 2: Tìm số nguyên còn lại trong khoảng [1,n] không tồn tại trong mảng A 
 */
public class Ex02 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,7,6};
		int b = missNumber(a);
		System.out.println("Miss number is : " + b);
	}
	
	private static int missNumber(int[] array) {
		int sum = 0;
		int sumS = 0;
		int n = array.length + 1;
		sum = ( n  *( n + 1 )) / 2;
		for(int j = 0; j < array.length; j++) {
			sumS += array[j];
		}
		return sum - sumS;
	}
}
