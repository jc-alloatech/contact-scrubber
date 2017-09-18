package com.alloatech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactFileReader {

    public static List<Contact> getContactsFromFile(FileConfig fileConfig, ContactScrub scrub) {
        File file = new File(fileConfig.getFileWithPath());
        fileConfig.setFileName(file.getName());
        BufferedReader reader = null;
        List<Contact> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            scrub.getFileConfigs().add(fileConfig);
            String text = null;
            while ((text = reader.readLine()) != null) {
                String[] chunk = text.split(",");
                List<Address> addresses = new ArrayList<>();
                for  (AddressConfig conf: fileConfig.getAddressConfigs()){
                    Address curAddress = new Address();
                    curAddress.setType(conf.getType());
                    curAddress.setAddress(chunk[conf.getIndex()]);
                    addresses.add(curAddress);
                }
                Contact curContact = new Contact(fileConfig.getFileName() + "::" + Integer.valueOf(chunk[0]), chunk[1], addresses);
                list.add(curContact);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            scrub.getErrors().add(e.getLocalizedMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
            scrub.getErrors().add(e.getLocalizedMessage());
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }
            catch (IOException e) {}
        }
        fileConfig.setContactCount(list.size());
        return list;
    }

    public static List<Contact> getContactsFromFiles(List<FileConfig> files, ContactScrub scrub) {
        List<Contact> result = new ArrayList<>();
        for (FileConfig conf : files) {
            result.addAll(getContactsFromFile(conf, scrub));
        }
        return result;
    }
}
