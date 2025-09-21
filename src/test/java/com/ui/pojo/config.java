package com.ui.pojo;

import java.util.Map;

public class config {   
	
	// key and value json
	Map<String,Environment>environments;
	
	
	public Map<String,Environment> getEnvironment(){
		return environments;
		
	}
	
	public void setEnvironments(Map<String,Environment> environements) {
		this.environments=environments;
	}
		
	}


