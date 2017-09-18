/**
 * 
 */
package com.alloatech;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author cairn
 */
public class ProgramRunner {

    private static final String file1 = "src\\main\\resources\\file1.csv";
    private static final String file2 = "src\\\\main\\resources\\file2.csv";

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        List<String> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);
        List<Contact> list = new ArrayList<Contact>();
        
        list = ContactFileReader.getContactsFromFile(file1);
        list.addAll(ContactFileReader.getContactsFromFile(file2));
        ContactScrubber contactScrubber = new ContactScrubber();
        ContactScrub scrub = new ContactScrub();
        scrub.setBadContacts(ContactScrubber.analyzeContacts());
        scrub.setCount(list.size());
        scrub.setFiles(files);
        scrub.setResults(contactScrubber.scrub(list));
        System.out.println(scrub);;
    }
}
