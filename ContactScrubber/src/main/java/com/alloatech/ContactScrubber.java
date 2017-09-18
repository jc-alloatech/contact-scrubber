/**
 * Proprietary and Confidential AlloaTech, LLC. This document contains material which is proprietary and confidential property of ThorCode. The right
 * to view, reproduce, modify, distribute, or in any way display this work is prohibited without the expressed written consent of ThorCode Copyright
 * &copy; 2017 Initial commit: Sep 17, 20176:33:29 PM User: thor
 */
package com.alloatech;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.xdrop.fuzzywuzzy.FuzzySearch;

/**
 * @author thor
 */
public class ContactScrubber {

    public List<ScrubbingResult> scrub(List<Contact> list, ContactScrub scrub) {
        System.out.println("Incoming size:" + list.size());
        list = analyzeContacts(list, scrub);
        System.out.println("Post Analyzed size:" + list.size());
        List<ScrubbingResult> result = new ArrayList<>();
        // LOOP THROUGH THE LIST INCREMETALLY STEPPING DOWN THROUGH
        for (int i = 0; i < list.size(); i++) {
            ScrubbingResult curResult = new ScrubbingResult();
            Contact curContact = list.get(i);
            curResult.setContact(curContact);
            for (int j = 0; j < list.size(); j++) {
                Contact nextContact = list.get(j);
                if (!curContact.getId().equals(nextContact.getId())) {
                    curResult.getData().add(analyzeName(curContact, nextContact));
                    curResult.getData().addAll(analyzeAddresses(curContact, nextContact));
                }
            }
            result.add(curResult);
        }
        return result;
    }

    private ScrubbingResultData analyzeName(Contact curContact, Contact nextContact) {
        ScrubbingResultData curData = new ScrubbingResultData();
        curData.setKey(nextContact.getId());
        curData.setFieldName("Name");
        curData.setFieldValue(nextContact.getName());
        analyzeStrings(curData, curContact.getName(), nextContact.getName());
        return curData;
    }

    private List<ScrubbingResultData> analyzeAddresses(Contact curContact, Contact nextContact) {
        List<ScrubbingResultData> result = new ArrayList<>();
        for (Address curAddress : curContact.getAddresses()) {
            for (Address nextAddress : nextContact.getAddresses()) {
                ScrubbingResultData data = analyzeAddress(curAddress, nextAddress);
                data.setKey(nextContact.getId());
                result.add(data);
            }
        }
        return result;
    }

    private ScrubbingResultData analyzeAddress(Address curAddress, Address nextAddress) {
        ScrubbingResultData curData = new ScrubbingResultData();
        curData.setFieldName("Address");
        curData.setFieldValue(nextAddress.getAddress());
        analyzeStrings(curData, curAddress.getAddress(), nextAddress.getAddress());
        return curData;
    }

    private ScrubbingResultData analyzeStrings(ScrubbingResultData curData, String curString, String nextString) {
        curData.setSimpleRatio(FuzzySearch.ratio(curString, nextString));
        curData.setPartialRatio(FuzzySearch.partialRatio(curString, nextString));
        curData.setTokenSortRatio(FuzzySearch.tokenSortPartialRatio(curString, nextString));
        curData.setTokenSetRatio(FuzzySearch.tokenSetPartialRatio(curString, nextString));
        curData.setWeightedRation(FuzzySearch.weightedRatio(curString, nextString));
        return curData;
    }

    private List<Contact> analyzeContacts(List<Contact> list, ContactScrub scrub) {
        for (Contact contact : list) {
            ContactQuality conQual = new ContactQuality();
            conQual.setScore(100);
            if (contact.getName() == null || contact.getName().length() < 2) {
                conQual.adjustScore(.75);
                conQual.getIssues().add("Contact Name has low quality");
            }
            for (Address address : contact.getAddresses()) {
                if (address.getAddress() == null || address.getAddress().trim().split(" ").length < 4) {
                    conQual.adjustScore(.75);
                    conQual.getIssues().add("Contact " + address.getType() + " has low quality.");
                }
            }
            contact.setQuality(conQual);
            if (conQual.getScore() <= 75) {
                scrub.getBadContacts().add(contact);
            }
        }
        // FILTER OUT 75 and below
        int preSize = list.size();
        list = list.stream().filter(c -> c.getQuality().getScore() > 75).collect(Collectors.toList());
        int postSize = list.size();
        System.out.println("Bad Contact Count:" + scrub.getBadContacts().size());
        System.out.println("Filter Count:" + (preSize - postSize) + ", original size:" + preSize + ", post size:" + postSize);
        return list;
    }
}
