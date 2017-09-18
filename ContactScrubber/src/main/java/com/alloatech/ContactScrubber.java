/**
 * Proprietary and Confidential AlloaTech, LLC. This document contains material which is proprietary and confidential property of ThorCode. The right
 * to view, reproduce, modify, distribute, or in any way display this work is prohibited without the expressed written consent of ThorCode Copyright
 * &copy; 2017 Initial commit: Sep 17, 20176:33:29 PM User: thor
 */
package com.alloatech;

import java.util.ArrayList;
import java.util.List;
import me.xdrop.fuzzywuzzy.FuzzySearch;

/**
 * @author thor
 */
public class ContactScrubber {

    public List<ScrubbingResult> scrub(List<Contact> list, ContactScrub scrub) {
        analyzeContacts(list, scrub);
        List<ScrubbingResult> result = new ArrayList<>();
        // LOOP THROUGH THE LIST INCREMETALLY STEPPING DOWN THROUGH
        for (int i = 0; i < list.size(); i++) {
            ScrubbingResult curResult = new ScrubbingResult();
            Contact curContact = list.get(i);
            curResult.setContact(curContact);
            for (int j = i + 1; j < list.size(); j++) {
                Contact nextContact = list.get(j);
                curResult.getData().add(analyzeName(curContact, nextContact));
                result.add(curResult);
            }
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

    private ScrubbingResultData analyzeAddress(Contact curContact, Contact nextContact) {
        ScrubbingResultData curData = new ScrubbingResultData();
        curData.setFieldName("Address");
        curData.setFieldValue(nextContact.getName());
        analyzeStrings(curData, curContact.getName(), nextContact.getName());
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

    private void analyzeContacts(List<Contact> list, ContactScrub scrub) {
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
        list.stream().filter(c -> c.getQuality().getScore() <= 75);
    }
}
