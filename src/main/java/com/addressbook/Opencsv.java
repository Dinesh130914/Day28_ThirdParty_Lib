package com.addressbook;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

public class Opencsv {
	public static String CONTACT_CSV_FILE = "Address.csv";

	public static void main(String[] args) {
		writecsv();
		readcsv();
	}

	public static void writecsv() {
		try {
			FileWriter writter = new FileWriter(CONTACT_CSV_FILE);
			List<Contact> contactlist = new ArrayList<>();

			Contact cont1 = new Contact("Dinesh", "Thiyagarajan", "Virudhunagar", "Tamilnadu", "8608894623", "626119",
					"dinesh@gmail.com");

			contactlist.add(cont1);

			ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
			mappingStrategy.setType(Contact.class);
			String[] header = { "FirstName", "LastName", "City", "State", "Phonenumber", "Email" };
			mappingStrategy.setColumnMapping(header);

			StatefulBeanToCsvBuilder<Contact> builder = new StatefulBeanToCsvBuilder(writter);
			StatefulBeanToCsv beanwritter = builder.withMappingStrategy(mappingStrategy).build();

			beanwritter.write(contactlist);
			System.out.println("File Writed");
			writter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void readcsv() {

		try {
			Reader reader = Files.newBufferedReader(Paths.get(CONTACT_CSV_FILE));
			CSVReader csvReader = new CSVReader(reader);
			String[] record;
			while ((record = csvReader.readNext()) != null) {
					System.out.println("FirstName :"+record[0]);
					System.out.println("LastName :"+record[1]);
					System.out.println("City :"+record[2]);
					System.out.println("State :"+record[3]);
					System.out.println("Phonenumber :"+record[4]);
					System.out.println("Email :"+record[5]);
					
					reader.close();
					csvReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException c) {
			c.printStackTrace();
		}

	}
}
