package Loop;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = {10, 20, 30, 40, 50};
		for(int x : numbers) {
			if(x > 10)
				System.out.print(x + " ");
		}
		System.out.println("\n");
		String[] names = {"James", "Larry", "Tom", "Lacy"};
		
		for (String name: names) {
			System.out.print(name);
			System.out.print(",");
		}
	}
}
