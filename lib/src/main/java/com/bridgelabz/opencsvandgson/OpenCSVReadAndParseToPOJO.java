package com.bridgelabz.opencsvandgson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVReadAndParseToPOJO {
	private static final String SAMPLE_CSV_FILE_PATH ="users.csv";
	
	public static void main(String[] args) throws IOException {
		try (
				Reader reader =  Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
	)
		{
			 CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
					 .withType(CSVUser.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();
			 Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
			 while (csvUserIterator.hasNext()) {
	                CSVUser csvUser = csvUserIterator.next();
	                System.out.println("Name : " + csvUser.getName());
	                System.out.println("Email : " + csvUser.getEmail());
	                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
	                System.out.println("Country : " + csvUser.getCountry());
	                System.out.println("==========================");
	            }
		}
	}
}
