/**
 * 
 */
package com.example.model;

import com.fasterxml.jackson.annotation.JsonRootName;





/**
 * @author rajesh
 *
 */

@JsonRootName(value="setOfStrings")
public class RequestStrings {

	private String value;
	
	
	
	public void RequestStrings(){}
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

}
