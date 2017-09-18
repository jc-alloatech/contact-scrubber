/**
 * 
 */
package com.alloatech;

import java.sql.ResultSet;
import java.time.Duration;
import java.time.Instant;
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
        Instant start = Instant.now();
        System.out.println(System.getProperty("user.dir"));
        List<FileConfig> files = new ArrayList<>();
        setUpFileConfigs(files);
        System.out.println("Processing: " + files);
        ContactScrub scrub = new ContactScrub();
        List<Contact> list = new ArrayList<Contact>();
        list = ContactFileReader.getContactsFromFiles(files, scrub);
        ContactScrubber contactScrubber = new ContactScrubber();
        scrub.setCount(list.size());
        List<ScrubbingResult> scrubResult = contactScrubber.scrub(list, scrub);
        scrub.setResults(scrubResult);
        System.out.println(scrub);
        calculateStats(list, scrub);
        Instant stop = Instant.now();
        scrub.setDuration(Duration.between(start, stop));
        ReportGenerator.generateReport(scrub);
    }

    private static void calculateStats(List<Contact> list, ContactScrub scrub) {
        for (FileConfig fConf : scrub.getFileConfigs()) {
            fConf.setContactQuality(list.stream().filter(c -> c.getId().contains(fConf.getFileName()))
                    .mapToInt(c -> c.getQuality().getScore()).average().getAsDouble());
            fConf.setBadContactCount(scrub.getBadContacts().stream().filter(c -> c.getId().contains(fConf.getFileName())).count());
        }
    }

    private static void setUpFileConfigs(List<FileConfig> files) {
        FileConfig fileConf1 = new FileConfig();
        List<AddressConfig> addressConfigs = new ArrayList<>();
        AddressConfig addConf = new AddressConfig();
        addConf.setType(AddressType.SHIPPING);
        addConf.setIndex(2);
        addressConfigs.add(addConf);
        fileConf1.setFileWithPath(file1);
        fileConf1.setAddressConfigs(addressConfigs);
        files.add(fileConf1);
        // FILE 2
        FileConfig fileConf2 = new FileConfig();
        fileConf2.setFileWithPath(file2);
        List<AddressConfig> addressConfigs2 = new ArrayList<>();
        AddressConfig addConf2 = new AddressConfig();
        addConf2.setType(AddressType.SHIPPING);
        addConf2.setIndex(2);
        addressConfigs2.add(addConf2);
        AddressConfig addConf3 = new AddressConfig();
        addConf3.setType(AddressType.BILLING);
        addConf3.setIndex(3);
        addressConfigs2.add(addConf3);
        fileConf2.setAddressConfigs(addressConfigs2);
        files.add(fileConf2);
    }
}
