/**
 * 
 */
package com.example.servlet;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.model.JsonResponse;
import com.example.model.RequestModel;
import com.example.model.RequestStrings;
import com.example.validator.ValidationError;
import com.example.validator.ValidationErrorBuilder;

/**
 * @author rajesh
 *
 */
@Controller
public class SimpleController {

	private final Logger logger = LoggerFactory.getLogger(SimpleController.class);


	/**
	 * 
	 * @return 
	 * @return
	 */
	@RequestMapping(value = "/getSubString", method = {RequestMethod.POST},headers = {"Content-type=application/json"},produces = "application/json")
	public @ResponseBody JsonResponse handleSubStringRequest( @Validated @RequestBody RequestModel reqModel, Errors error) {

		logger.debug("handleSubStringRequest() : {}");
		JsonResponse jsonRsp =null;
		HashSet<String> set = new HashSet<String>();
		for(RequestStrings str: reqModel.getSetOfStrings()){
			set.add(str.getValue());
		}
		if(error.hasErrors()){
			jsonRsp = new JsonResponse("Failure", "The list of string can not be empty!" ,"", HttpStatus.BAD_REQUEST.value());
		}else if(null == reqModel.getSetOfStrings()){
			jsonRsp = new JsonResponse("Failure", "The list of string can not be empty!" ,"",-1);
		}else if(set.size()< reqModel.getSetOfStrings().size()) {	
			
			jsonRsp = new JsonResponse("Failure", "The collection of strings have to be unique!" ,"",HttpStatus.OK.value());
		}else{

			jsonRsp = getLargestSubString(reqModel.getSetOfStrings());
			jsonRsp.setHttpStatusCode(HttpStatus.OK.value());
		}
	      return jsonRsp;
		
	}
	
	 @ExceptionHandler
	  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	    public ValidationError handleException(MethodArgumentNotValidException exception) {
	        return ValidationErrorBuilder.fromBindingErrors(exception.getBindingResult());
	    }
	 
	/**
	 * 
	 * @param setOfStrings
	 * @return
	 */
	private JsonResponse getLargestSubString(List<RequestStrings> setOfStrings) {
		Iterator<RequestStrings> itr = setOfStrings.iterator();
		String temp = null;
		JsonResponse jsonRsp = null ;
		while(itr.hasNext())
		{
			temp = longestCommonSubstring(((RequestStrings)itr.next()).getValue(),itr.hasNext() ? ((RequestStrings)itr.next()).getValue() : temp );
			if(!StringUtils.isEmpty(temp)){
				jsonRsp = new JsonResponse("Success", "The lCS :: "+temp, temp);
			}else if(null != jsonRsp && StringUtils.isEmpty(temp)){
				temp = jsonRsp.getSubString();
			}else if(null == jsonRsp && StringUtils.isEmpty(temp)){
				jsonRsp = new JsonResponse("Success", "The was no matching lCS  string found! ", "");
			}else{
				jsonRsp = new JsonResponse("Failure", "Please enter valid json string", "");
			}
		}
		
		return jsonRsp;
	}

	
	
	/**
	 * 
	 * @param initialList
	 * @param outList
	 * @return
	 */
	String getLargestSubString(List<String> initialList, List<String> outList){
		Iterator<String> itr = initialList.iterator();
		String temp = null;
		while(itr.hasNext())
		{
			temp = longestCommonSubstring(itr.next(),itr.hasNext() ? itr.next() : temp );
		}
		return temp;
	}
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @param strList
	 * @return
	 * @throws ConcurrentModificationException
	 */
	List<String> getLargestSubString(String  str1, String str2,List<String> strList ) throws ConcurrentModificationException{
		String temp = null;
		try {
			
		
		
			for(int i=0;i<str1.length();i++){
			    //System.out.println(str1.substring(i,str1.length()));
			      
			    	if(str2.contains(str1.substring(i))){
			    		temp = str1.substring(i);
			    		if(null != strList && strList.size()>0){
			    		for(String str:strList){
			    			System.out.println("matches :: " +str);
			    			if(temp.length() > str.length()){
			    				strList.add(temp);
			    				System.out.println("subString match :: "+temp);
					    		}
			    			}
			    		}else{
			    			System.out.println("subString match in else :: "+temp);
			    			strList.add(temp);
		    			}
			    				    	
			    }
			    
			    
			    }
			for(int i=0;i<str2.length();i++){
			    //System.out.println(str1.substring(i,str1.length()));
			      
			    	if(str1.contains(str2.substring(i))){
			    		temp = str1.substring(i);
			    		if(null != strList && strList.size()>0){
			    		for(String str:strList){
			    			System.out.println("matches :: " +str);
			    			if(temp.length() > str1.length()){
			    				strList.add(temp);
			    				System.out.println("subString match :: "+temp);
					    		}
			    			}
			    		}else{
			    			System.out.println("subString match in else :: "+temp);
			    			strList.add(temp);
		    			}
			    				    	
			    }
			    
			    
			    }
			/*if(null != strList && strList.size()<0){
				strList = getLargestSubString(str2,str1,strList);
			}*/
			for(String str:strList)
			    System.out.println("matches list:: " +str +" size :: "+strList.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception .... ");
		}
			return strList;
			}
	
	/**
	 * 
	 * @param S1
	 * @param S2
	 * @return
	 */
	private static String longestCommonSubstring(String S1, String S2)
	{
	    int st = 0;
	    int maxIdx = 0;
	    for (int inti = 0; inti < S1.length(); inti++)
	    {
	        for (int intj = 0; intj < S2.length(); intj++)
	        {
	            int idx = 0;
	            while (S1.charAt(inti + idx) == S2.charAt(intj + idx))
	            {
	                idx++;
	                if (((inti + idx) >= S1.length()) || ((intj + idx) >= S2.length())) break;
	            }
	            if (idx > maxIdx)
	            {
	                maxIdx = idx;
	                st = inti;
	            }
	         }
	    }
	    //System.out.println("S1.substring(Start, (Start + Max)):: "+S1.substring(Start, (Start + Max)));
	    return S1.substring(st, (st + maxIdx));
	}

}
