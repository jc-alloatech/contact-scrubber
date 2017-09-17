package com.alloatech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactFileReader {
	public static List<Contact> getContactsFromFile(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;

		List<Contact> list = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			while ((text = reader.readLine()) != null) {
				String[] chunk = text.split(",");
				Contact curContact = new Contact(Integer.valueOf(chunk[0]), chunk[1], chunk[2]);

				list.add(curContact);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		
		return list;
	}
}
