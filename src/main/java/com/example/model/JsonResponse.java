/**
 * 
 */
package com.example.model;

/**
 * @author rajesh
 *
 */
public class JsonResponse {
	
	private String status = "";
	  private String message = "";
	  private String subString = "";
	  private int statusCode = -1;
	 
	  public int getHttpStatusCode() {
		return statusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		statusCode = httpStatusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubString() {
		return subString;
	}

	public void setSubString(String subString) {
		this.subString = subString;
	}

	public JsonResponse(String status, String Message,String subString,int statusCode) {
	    this.status = status;
	    this.message = Message;
	    this.subString = subString;
	    this.statusCode = statusCode;
	  }

	public JsonResponse(String status, String Message, String temp) {
		this.status = status;
	    this.message = Message;
	    this.subString = temp;
	}

}
