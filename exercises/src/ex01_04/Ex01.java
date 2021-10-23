package ex01_04;
import static java.lang.Math.*;
/**
 * Bài 1: Viết hàm kiểm tra một số có phải là lũy thừa của một số khác không ?
 * VD: a là lũy thừa của b hoặc b là lũy thừa của a
 */
public class Ex01 {
	public static void main(String[] args) {
		int a = 6;
		int b = 2;
		System.out.println("isPowerOf " + a + "," + b + ": " + ( a>b ? isPowerOf(a, b) : isPowerOf(b, a)));
	}
	
	public static boolean isPowerOf(int a, int b) {
		if(a == 0)
			return false;
		if(a == 1 || a == b)
			return true;
		double base = log(a)/log(b);
		return ceil(base) == floor(base);
	}
}
