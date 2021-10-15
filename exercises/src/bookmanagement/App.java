package bookmanagement;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Book[] books = getAll();
		show(books);
		System.out.println("==================");
		Book[] result = getBooks(books,"NhiDong");
		show(result);
		System.out.println("=======================");
		Book[] cost = getCost(books,50);
		show(cost);
		System.out.println("========================");
		Book[] MinMax = getCost(books, 0, 100);
		show(MinMax);
		// anonymous class
		/*
		 * Biểu thức Lamda có 3 phần:
		 * (Danh sách tham số) -> {Thân hàm // override}
		 */
		System.out.println("=============================");
		Book[] value = getBooks(books, book -> book.getPublisher().contains("NhiDong"));
		show(value);
		// "ab".equals("ab"); // So sanh chinh xac den tung ki tu
		// "ab".contains("ab"); // So sanh tuong doi gia tri 
		
		// C4:
		System.out.println("========================");
		Book[] saleBooks = {books[0], books[1], books[5]};
		System.out.println("Total Of Money: "+ getMoney(saleBooks));
	}
	
	private static double getMoney(Book[] books) {
		double totalOfMoney = 0;
		for (Book book: books) {
			
			double realCost = book.getCost();
			
			if (book instanceof TextBook && ((TextBook)book).getStatus().equals(Status.OLd)) {
				realCost *= 0.7d;
			}else if(book instanceof ReferenceBook){
				realCost *= (1 + ((ReferenceBook)book).getTax()/100);
			}
			
			totalOfMoney += realCost;
		}
		return totalOfMoney;
	}
	
	private static Book[] getBooks(Book[] books, Function function) {
		Book[] result =  new Book[books.length];
		int i = 0;
		for(Book book:books) {
			if(function.test(book)) {
				result[i++] = book;
			}
		}
		//return actualResult;
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static Book[] getBooks(Book[] books, String publisher) {
		// Array: Fixed - length >> null
		Book[] result =  new Book[books.length];
		int i = 0;
		for(Book book:books) {
			if(book.getPublisher().equals(publisher)) {
				result[i++] = book;
			}
		}
		Book[] actualResult = new Book[i];
		for(int j = 0; j < actualResult.length; j++) {
			actualResult[j] = result[j];
		}
		//return actualResult;
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static Book[] getCost(Book[] books, double cost) {
		// Array: Fixed - length >> null
		Book[] result =  new Book[books.length];
		int i = 0;
		for(Book book:books) {
			if(book.getCost() < cost) {
				result[i++] = book;
			}
		}
		Book[] actualResult = new Book[i];
		for(int j = 0; j < actualResult.length; j++) {
			actualResult[j] = result[j];
		}
		//return actualResult;
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static Book[] getCost(Book[] books, double minCost, double maxCost) {
		// Array: Fixed - length >> null
		Book[] result =  new Book[books.length];
		int i = 0;
		for(Book book:books) {
			/*
			 * if(book.getClass().getSimpleName().equals(TextBook.class.getSimpleName())
			 * && minCost <book.getCost() && book.getCost()< maxCost) 
			 */
			if(book instanceof TextBook && minCost <book.getCost() && book.getCost()< maxCost) {
				result[i++] = book;
			}
		}
		Book[] actualResult = new Book[i];
		for(int j = 0; j < actualResult.length; j++) {
			actualResult[j] = result[j];
		}
		//return actualResult;
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static void show(Book[] books) {
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	private static Book[] getAll() {
		Book t1 = new TextBook("SGK01", 20, "AuCo", Status.New);
		Book t2 = new TextBook("SGK02", 10, "NhiDong", Status.New);
		Book t3 = new TextBook("SGK03", 160, "NhiDong", Status.OLd);
		Book t4 = new TextBook("SGK04", 45, "VietNam", Status.OLd);
		Book t5 = new TextBook("SGK05", 124, "AuCo", Status.New);
		
		Book r1 = new ReferenceBook("STK01", 68, "NhiDong", 6);
		Book r2 = new ReferenceBook("STK02", 78, "NhiDong", 6);
		Book r3 = new ReferenceBook("STK03", 120, "VietNam", 12);
		Book r4 = new ReferenceBook("STK04", 125, "NhiDong", 6);
		Book r5 = new ReferenceBook("STK05", 97, "AuCo", 8);
		
		return new Book[] {t1, t2, t3, t4, t5, r1, r2, r3, r4, r5};
	}
}
