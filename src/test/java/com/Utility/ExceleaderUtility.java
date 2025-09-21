package com.Utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExceleaderUtility {
	public static  Iterator<User> readExcelFile (String fileName) {
	
			//XLSX File
		File xlsxFile = new File(System.getProperty("user.dir")+ "//testData//"+fileName);
		XSSFWorkbook xssfworkbook = null;
		Row row;
		Cell firstCell;
		Cell secoundCell;
		
		
		try {
			xssfworkbook = new XSSFWorkbook(xlsxFile);
		
		
		List<User> userList = new ArrayList<User>();
		
		XSSFSheet xssfsheet = xssfworkbook.getSheet("LoginTestData");
		Iterator<Row>  rowIterator = xssfsheet.iterator();
		rowIterator.next();//skip the coloum name first 
		
		while(rowIterator.hasNext()){
			 row=rowIterator.next();
			
			 firstCell = row.getCell(0);
			 secoundCell=row.getCell(1);
			System.out.println(firstCell.toString());
			System.out.println(secoundCell.toString());
			User user = new User(firstCell.toString(),secoundCell.toString());
			userList.add(user);
			xssfworkbook.close();
			return userList.iterator();
			
		}
		
			
		} catch (InvalidFormatException e) {
						e.printStackTrace();
		} catch(IOException e) {
		e.printStackTrace();
		
			
		}
	return null;
	
}
}


