package ex01_04;

public class Ex03 {
	public static void main(String[] args) {
		int[] a = {2,6,8};
		System.out.println(getLeastCommonMultiple(a));
	}
	
	private static int commonDivisor(int a, int b) {
		if( b == 0)
			return a;
		return commonDivisor(a, a% b);
	}
	
	private static int commonMultiples(int a, int b) {
		return (a * b / commonDivisor(a, b));
	}
	
	private static int getLeastCommonMultiple(int[] a) {
		int temp = commonMultiples(a[0], a[1]);
		for(int i = 2; i < a.length; i++) {
			temp = commonMultiples(temp, a[i]);
		}
		return temp;
	}
}
