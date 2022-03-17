package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.LibDao;
import spring.LibVO;

@Controller
public class LibListController {
     
	   private LibDao libDao ;
	   
	   public void setLibDao(LibDao libDao) {
		   this.libDao = libDao ;
	   }
	   
	   @RequestMapping(value="/list", method=RequestMethod.GET)
	   public String list(Model model) {
		   List<LibVO> books = libDao.selectAll();
		   model.addAttribute("books", books);
		   return "/book_list" ;
	   }
	   
	   @RequestMapping(value="/search", method=RequestMethod.GET)
	   public String list(@ModelAttribute("condition")ListCommand listCommand, Model model) {
		   if(listCommand.getKeyword() != null ) {
			   List<LibVO> books = libDao.selectBySearch(listCommand.getKeyword(),
					   listCommand.getSearchType());
			      System.out.println(listCommand.toString());
			      model.addAttribute("books" , books);
			      System.out.println(model.toString());
			      return "book_list" ;
		   }
			   return "book_list" ;
	   }
	   
	   
}
