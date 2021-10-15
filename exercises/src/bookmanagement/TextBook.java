package bookmanagement;

public class TextBook extends Book{
	private Status status;
	
	public TextBook() {
	}

	public TextBook(String id, double cost, String publisher, Status status) {
		super(id, cost, publisher);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return super.toString() + " >> " + status;
	}
	
}