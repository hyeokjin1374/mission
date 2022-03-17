package spring;

import java.util.List;

public interface LibDao {

	public void insert(LibVO libvo);
	 
	public List<LibVO> selectAll();
	 
	 public LibVO selectById(int id) ;
	 
	 public List<LibVO> selectBySearch(String seachType, String keyword) ;
	 
	 public Object selectByIsbn(String isbn) ;
	
}
