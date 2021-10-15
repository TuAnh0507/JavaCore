package ex01;
/*
 * In tam giác vuông với kí tự * 
 */
import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("\n----------------------------------");
	}
}

