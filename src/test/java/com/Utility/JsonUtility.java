package com.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constant.Environment;
import com.google.gson.Gson;
import com.ui.pojo.config;

public class JsonUtility {
	public static com.ui.pojo.Environment readJSON(Enum env) {
		
		
		
		Gson gson = new Gson();
		File jsonfile = new File(System.getProperty("user.dir")+"\\config\\config.json");
		FileReader fileReader=null;
		try {
			
			 fileReader = new FileReader(jsonfile);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		config config =gson.fromJson(fileReader, config.class);
		com.ui.pojo.Environment environment = config.getEnvironment().get("QA");
		return environment;
	}

}
