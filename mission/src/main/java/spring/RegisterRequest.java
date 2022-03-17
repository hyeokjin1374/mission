package spring;

import org.springframework.web.multipart.MultipartFile;

public class RegisterRequest {

	  
	   private String bookisbn ;
       private String bookname ;
       private String writer ;  //작가
       private String publisher ;  //출판사
       private int money ;
       private String uploadFile ;
       private MultipartFile image ;
       private String contents ;  // 책 내용
       
	public String getBookisbn() {
		return bookisbn;
	}
	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public MultipartFile getImage() {
		return image ;
	}
    public void setImage(MultipartFile image) {
    	this.image = image ;
    }
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	
	
	
}
