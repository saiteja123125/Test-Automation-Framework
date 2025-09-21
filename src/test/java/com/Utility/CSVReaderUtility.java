package com.Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	public static Iterator<User> readCSVFile(String fileName) {
		
		File csvFile = new File(System.getProperty("user.dir")+ "//testData//" + fileName);
		FileReader fileReader = null;
		CSVReader csvReader ;
		String[] line;
		 List<User> userList = null;
		 User userData;
	
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			 
		csvReader.readNext();//read the col names --row1	 row 1 skip the colnames		
//			csvReader.readNext();//Row2
//			csvReader.readNext();//Row3
//			
//		 data=	csvReader.readNext();//Row4 [No row we have reache the csv file show Null]
		 
		 
		  userList = new ArrayList<User>();
		 
		
		 while((line = csvReader.readNext())!=null){
			  userData = new User(line[0],line[1]);
			 userList.add(userData);
			 
		 }
//			for(User userData1 : userList) {
//				System.out.println(userData1);
//			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		 catch (CsvValidationException | IOException e) {
			
			e.printStackTrace();
		}
		return userList.iterator();
		
	}
	}

