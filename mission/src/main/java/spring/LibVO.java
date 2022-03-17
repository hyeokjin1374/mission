package spring;

public class LibVO {
       private int num ;
       private String bookname ;
       private String writer ;  //작가
       private String publisher ;  //출판사
       private String bookisbn ;
       private int money ;
       private String contents ;  // 책 내용
       private String image ;
       
       public LibVO() {}

	public LibVO(String bookname, String writer, String publisher, String bookisbn, int money, String contents, String image) {
		super();
		this.bookname = bookname;
		this.writer = writer;
		this.publisher = publisher;
		this.bookisbn = bookisbn;
		this.money = money;
		this.contents = contents;
		this.image = image ;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

       
       
       
       
       
       
}
