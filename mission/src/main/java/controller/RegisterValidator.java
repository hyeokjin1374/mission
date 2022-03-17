package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.RegisterRequest;

public class RegisterValidator implements Validator{
	
	 @Override
	 public boolean supports(Class<?> claszz) {
		 return RegisterRequest.class.isAssignableFrom(claszz) ;
	 }
	
	 @Override
	 public void validate(Object target, Errors errors) {
		 ValidationUtils.rejectIfEmpty(errors, "bookname", "required", "필수 정보입니다");
		 ValidationUtils.rejectIfEmpty(errors, "writer", "required", "필수 정보입니다");
		 ValidationUtils.rejectIfEmpty(errors, "publisher", "required", "필수 정보입니다");
		 ValidationUtils.rejectIfEmpty(errors, "bookisbn", "required", "필수 정보입니다");
		 ValidationUtils.rejectIfEmpty(errors, "money", "required", "필수 정보입니다");
		 ValidationUtils.rejectIfEmpty(errors, "contents", "required", "필수 정보입니다");
		 ValidationUtils.rejectIfEmpty(errors, "image", "required", "필수 정보입니다");
	 }

}
