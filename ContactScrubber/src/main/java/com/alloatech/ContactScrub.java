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
 *  Initial commit:  Sep 17, 20177:49:32 PM
 *  User:  thor 
 */
package com.alloatech;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thor
 */
public class ContactScrub {
    private int count;
    private List<FileConfig> fileConfigs;
    private List<String> errors;
    private List<ScrubbingResult> results;
    private List<Contact> badContacts;
    
    
    public ContactScrub() {
        fileConfigs = new ArrayList<>();
        errors = new ArrayList<>();
        results = new ArrayList<>();
        badContacts = new ArrayList<>();
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public List<FileConfig> getFiles() {
        return fileConfigs;
    }
    
    public void setFiles(List<FileConfig> files) {
        this.fileConfigs = files;
    }
    
    public List<ScrubbingResult> getResults() {
        return results;
    }
    
    public void setResults(List<ScrubbingResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ContactScrub [count=" + count + ", files=" + fileConfigs + ", results=" + results + ", badContacts=" + badContacts
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + count;
        result = prime * result + ((fileConfigs == null) ? 0 : fileConfigs.hashCode());
        result = prime * result + ((results == null) ? 0 : results.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContactScrub other = (ContactScrub) obj;
        if (count != other.count)
            return false;
        if (fileConfigs == null) {
            if (other.fileConfigs != null)
                return false;
        } else if (!fileConfigs.equals(other.fileConfigs))
            return false;
        if (results == null) {
            if (other.results != null)
                return false;
        } else if (!results.equals(other.results))
            return false;
        return true;
    }

    
    public List<Contact> getBadContacts() {
        return badContacts;
    }

    
    public void setBadContacts(List<Contact> badContacts) {
        this.badContacts = badContacts;
    }

    
    public List<String> getErrors() {
        return errors;
    }

    
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
