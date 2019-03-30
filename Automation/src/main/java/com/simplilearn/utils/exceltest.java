package com.simplilearn.utils;
import java.io.IOException;
import java.util.ArrayList;

public class exceltest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try {
			GetCellData  g= new GetCellData();
			ArrayList data=g.GetExcelData("Sign_in");
			
			
			System.out.println(data.get(0));
			System.out.println(data.get(1));
			System.out.println(data.get(2));
			System.out.println(data.get(3));
			System.out.println(data.get(4));
		
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
