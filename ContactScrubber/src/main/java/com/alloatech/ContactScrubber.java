/**
 * Proprietary and Confidential AlloaTech, LLC. This document contains material which is proprietary and confidential property of ThorCode. The right
 * to view, reproduce, modify, distribute, or in any way display this work is prohibited without the expressed written consent of ThorCode Copyright
 * &copy; 2017 Initial commit: Sep 17, 20176:33:29 PM User: thor
 */
package com.alloatech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.xdrop.fuzzywuzzy.FuzzySearch;

/**
 * @author thor
 */
public class ContactScrubber {

    public List<ScrubbingResult> scrub(List<Contact> list) {
        List<ScrubbingResult> result = new ArrayList<>();
        // NAME
        list.stream().forEach((c) -> {
            ScrubbingResult curResult = new ScrubbingResult();
            curResult.setContact(c);
            list.stream().forEach(oc -> {
                ResultKey curKey = new ResultKey(c.getId(), oc.getId());
                ScrubbingResultData curData = new ScrubbingResultData();
                curData.setFieldName("Name");
                curData.setFieldValue(oc.getName());
                curData.setSimpleRatio(FuzzySearch.ratio(c.getName(), oc.getName()));
                curData.setPartialRatio(FuzzySearch.partialRatio(c.getName(), oc.getName()));
                curData.setTokenSortRatio(FuzzySearch.tokenSortPartialRatio(c.getName(), oc.getName()));
                curData.setTokenSetRatio(FuzzySearch.tokenSetPartialRatio(c.getName(), oc.getName()));
                curData.setWeightedRation(FuzzySearch.weightedRatio(c.getName(), oc.getName()));
                if (curKey != null && curResult != null) {
                    result.add(curResult);
                }
            });
        });
        return filterResults(result);
    }

    private List<ScrubbingResult> filterResults(List<ScrubbingResult> result) {
        return result;
    }

    public static List<BadContact> analyzeContacts() {
        return new ArrayList<>();
    }
}
