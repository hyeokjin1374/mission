package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AlreadyExistingBookException;
import spring.LibRegisterService;
import spring.LibVO;
import spring.NotImageFileException;
import spring.RegisterRequest;

@Controller
@RequestMapping("/add")
public class RegisterController {

	 private LibRegisterService libRegisterService ;
	 public void setLibRegisterService(LibRegisterService libRegisterService) {
		 this.libRegisterService = libRegisterService ;
	 }
	 @RequestMapping(method=RequestMethod.GET)
	 public String handle1(@ModelAttribute("formData") LibVO libvo) {
		 return "/lib_reg_form";
	 }
	 @RequestMapping(method=RequestMethod.POST)
	 public String jandle2(@ModelAttribute("formData") RegisterRequest regReq,
			 HttpServletRequest request, Errors errors){
	 
       new RegisterValidator().validate(regReq, errors);
          if(errors.hasErrors()) {
           return "/lib_reg_form" ;
          }
	       
	      try  {
	    	  libRegisterService.regist(regReq, request);
	    	    return "redirect:/list" ;
	      }catch(AlreadyExistingBookException e) {
	    	  errors.rejectValue("bookisbn", "duplicate", "이미 있는 ISBN 번호 입니다.");
	    	  return "/lib_reg_form" ;
	      }catch(NotImageFileException e) {
	    	  errors.rejectValue("image", "bad", "이미지 파일이 아닙니다.");
	    	  return "/lib_reg_form" ;
	      }catch(IOException e) {
	    	  return "/lib_reg_form" ;
	      }
}
	 }
	 

