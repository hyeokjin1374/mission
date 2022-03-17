package utils;

import java.io.IOException ;
import java.io.InputStream;
import java.util.Arrays ;
import java.util.List ;

import org.apache.tika.Tika ;

public class FileUtils {

         private static final Tika tika = new Tika() ;	
	
	     public static boolean validImgFile(InputStream inputStream) {
	    	 try {
	    		 List<String> notValidTypeList = Arrays.asList("image/jpeg",
	    			"image/pjpeg","image/png", "image/gif","image/bmp") ;
	    		 String mimeType = tika.detect(inputStream) ;
	    		 //stream은 한번 훑어본다의 의미  anyMatch에 쓴건 위에 Arrays.asList안에 파일형식이 있는지 확인
	    		 boolean isValid = notValidTypeList.stream().anyMatch(
	    	notValidType-> notValidType.equalsIgnoreCase(mimeType)) ; //IgnoreCase 대소문자 구분없이
	    		 return isValid ;
	    	 }catch(IOException e) {
	    		 e.printStackTrace();
	    		 return false ;
	    	 }
	     }
	
	
}
