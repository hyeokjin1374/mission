package spring;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class LibDaoImpl implements LibDao{

	  private SqlSessionTemplate sqlSessionTemplate ;
	  
	  public LibDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		  this.sqlSessionTemplate = sqlSessionTemplate ;
	  }
	  @Override
	  public void insert(LibVO libvo) {
		  sqlSessionTemplate.insert("insert", libvo) ;
	  }
	  @Override
	  public List<LibVO> selectAll() {
		  return sqlSessionTemplate.selectList("list") ;
	  }
      @Override
      public LibVO selectById(int id) {
    	  List<LibVO> results = sqlSessionTemplate.selectList("selectById",id) ;
    	  return results.isEmpty() ? null:results.get(0);
      }
      @Override
      public List<LibVO> selectBySearch(String keyword, String searchType){
    	  HashMap<String, String> map = new HashMap<String, String>() ;
    	  map.put("searchType", searchType);
    	  map.put("keyword", keyword) ;
    	  System.out.println(map.get("searchType"));
    	  System.out.println(map.get("keyword"));
    	  List<LibVO> list = sqlSessionTemplate.selectList("selectBySearch", map);
    	  return list ;
      }
      @Override
      public Object selectByIsbn(String isbn) {
             return sqlSessionTemplate.selectOne("selectByIsbn", isbn) ;
          }
      
	  
}
