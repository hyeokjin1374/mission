package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.LibDao;
import spring.LibVO;

@Controller
public class LibDetailController {
 
      private LibDao libDao ;
      
      public void setLibDao(LibDao libDao) {
    	  this.libDao = libDao ;
      }
	
      @RequestMapping("/detail/{num}")
      public String detail(@PathVariable("num") int booknum, Model model) {
    	  LibVO libvo = libDao.selectById(booknum);
    	  if(libvo == null) {
    		  
    	  }
    	  model.addAttribute("book", libvo) ;
    	  return "book_detail";
      }
      
      
}
