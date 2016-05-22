/**
 * 
 */
package com.example.model;

import java.util.List;

import org.springframework.validation.annotation.Validated;



/**
 * @author rajesh
 *
 */

@Validated
public class RequestModel {
	
	private List<RequestStrings> setOfStrings;
	
	RequestModel(){
	}

	public List<RequestStrings> getSetOfStrings() {
		return setOfStrings;
	}

	public void setSetOfStrings(List<RequestStrings> setOfStrings) {
		this.setOfStrings = setOfStrings;
	}

	

	

	
}
