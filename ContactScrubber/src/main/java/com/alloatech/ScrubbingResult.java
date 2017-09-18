/**
 * Proprietary and Confidential
 *           AlloaTech, LLC.
 *   
 * 	This document contains material which is proprietary and confidential 
 *  property of ThorCode.
 *   
 *  The right to view, reproduce, modify, distribute, or in any way display
 *  this work is prohibited without the expressed written consent of 
 *  ThorCode
 *
 *  Copyright &copy; 2017
 *  Initial commit:  Sep 17, 20176:27:01 PM
 *  User:  thor 
 */
package com.alloatech;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thor
 */
public class ScrubbingResult {
    private Contact contact;
    private ContactQuality quality;
    private List<ScrubbingResultData> data = new ArrayList<>();

    @Override
    public String toString() {
        return "ScrubbingResult [contact=" + contact + ", data=" + data + "]";
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<ScrubbingResultData> getData() {
        return data;
    }

    public void setData(List<ScrubbingResultData> data) {
        this.data = data;
    }

    
    public ContactQuality getQuality() {
        return quality;
    }

    
    public void setQuality(ContactQuality quality) {
        this.quality = quality;
    }
    
}
