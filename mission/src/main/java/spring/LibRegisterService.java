package spring;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import utils.FileUtils;

public class LibRegisterService {
            
	      private LibDao libDao ;
	      
	      public LibRegisterService(LibDao libDao) {
	    	  this.libDao = libDao ;
	      }
	      public void regist(RegisterRequest req,
	    		  HttpServletRequest request) throws IllegalStateException, IOException {
	    	 LibVO libvo = (LibVO) libDao.selectByIsbn(req.getBookisbn());
	    	 if(libvo!= null) {
	    		 throw new AlreadyExistingBookException("dup bookisbn" + req.getBookisbn());
	    	 }
	    	 MultipartFile uploadFile = req.getImage();
	    	 if(!uploadFile.isEmpty()) {
	    		 try {

	    				 InputStream inputStream = uploadFile.getInputStream();
	    				boolean isValid = FileUtils.validImgFile(inputStream) ;
	    				if(!isValid) {
	    					throw new NotImageFileException("image" + 	req.getImage());
	    				}
	    				String filename = null ;  
	    				String orinalFileName = uploadFile.getOriginalFilename();
	    				String ext = FilenameUtils.getExtension(orinalFileName); //확장자 jpg,PNG같은걸 빼둔다
	    				UUID uuid = UUID.randomUUID(); //이름을 랜덤으로 바꾸는건데 확장자까지 바꾸면안되서 위에 Extejsion작업을 한다
	    				
	    				filename = uuid +"."+ext ;
	    				
	    				String root_path=request.getSession().getServletContext().getRealPath("/"); //리소스/파일업로드 폴더의 경로를 뜻함
	    				String attach_path = "resources/upload" ;
	    				
	    				File makeFolder = new File(root_path + attach_path) ;
	    				if(!makeFolder.exists()) {
	    					makeFolder.mkdir();
	    				}
	    				System.out.println(root_path+attach_path+filename);
	    				//경로
	    				uploadFile.transferTo(new File(root_path + attach_path + "/" + filename));
	    			    req.setUploadFile(filename);
	    			 
	    			    LibVO lib = new LibVO(req.getBookname(), req.getWriter(), req.getPublisher(),
	    			    		req.getBookisbn(), req.getMoney(), req.getContents(), req.getUploadFile());
	    			    libDao.insert(lib);
	    			 
	    		 }catch(IOException e) {
	    			 e.printStackTrace();
	    		 }
	    	 }
	      }
}
