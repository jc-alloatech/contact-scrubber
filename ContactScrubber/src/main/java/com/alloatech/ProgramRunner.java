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
        List<FileConfig> files = new ArrayList<>();
        setUpFileConfigs(files);
        ContactScrub scrub = new ContactScrub();
        List<Contact> list = new ArrayList<Contact>();
        list = ContactFileReader.getContactsFromFiles(files, scrub);
        ContactScrubber contactScrubber = new ContactScrubber();
        scrub.setCount(list.size());
        scrub.setResults(contactScrubber.scrub(list, scrub));
        System.out.println(scrub);
        ;
    }

    private static void setUpFileConfigs(List<FileConfig> files) {
        FileConfig fileConf1 = new FileConfig();
        List<AddressConfig> addressConfigs = new ArrayList<>();
        AddressConfig addConf = new AddressConfig();
        addConf.setType(AddressType.SHIPPING);
        addConf.setIndex(2);
        addressConfigs.add(addConf);
        fileConf1.setFileName(file1);
        fileConf1.setAddressConfigs(addressConfigs);
        files.add(fileConf1);
        FileConfig fileConf2 = new FileConfig();
        List<AddressConfig> addressConfigs2 = new ArrayList<>();
        AddressConfig addConf2 = new AddressConfig();
        addConf2.setType(AddressType.SHIPPING);
        addConf2.setIndex(2);
        addressConfigs2.add(addConf2);
        AddressConfig addConf3 = new AddressConfig();
        addConf3.setType(AddressType.BILLING);
        addConf3.setIndex(3);
        addressConfigs2.add(addConf3);
        files.add(fileConf2);
    }
}
