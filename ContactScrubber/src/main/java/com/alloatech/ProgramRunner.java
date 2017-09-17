/**
 * 
 */
package com.alloatech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author cairn
 *
 */
public class ProgramRunner {

	private static final String file1 = "C:\\Users\\cairn\\eclipse-workspace\\NameReconciliation\\resources\\file1.csv";
	private static final String file2 = "C:\\Users\\cairn\\eclipse-workspace\\NameReconciliation\\resources\\file2.csv";

	public static void main(String[] args) {
		List<Contact> list = new ArrayList<Contact>();
		ContactFileReader cfr = new ContactFileReader();
		list = cfr.getContactsFromFile(file1);
		list.addAll(cfr.getContactsFromFile(file2));

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Contact contact = (Contact) iterator.next();
			System.out.println(contact);

		}

	}

}
