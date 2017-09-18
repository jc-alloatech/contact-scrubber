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

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thor
 */
public class ContactScrub {
    private int count;
    private String timeStamp;
    private Duration duration;
    private List<FileConfig> fileConfigs;
    private List<String> errors;
    private List<ScrubbingResult> results;
    private List<Contact> badContacts;
    
    
    public ContactScrub() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm");
        timeStamp = date.format(formatter);
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
    
    
    public List<ScrubbingResult> getResults() {
        return results;
    }
    
    public void setResults(List<ScrubbingResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ContactScrub [count=" + count + ", timeStamp=" + timeStamp + ", duration=" + duration + ", fileConfigs="
                + fileConfigs + ", errors=" + errors + ", results=" + results + ", badContacts=" + badContacts + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((badContacts == null) ? 0 : badContacts.hashCode());
        result = prime * result + count;
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + ((errors == null) ? 0 : errors.hashCode());
        result = prime * result + ((fileConfigs == null) ? 0 : fileConfigs.hashCode());
        result = prime * result + ((results == null) ? 0 : results.hashCode());
        result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
        if (badContacts == null) {
            if (other.badContacts != null)
                return false;
        } else if (!badContacts.equals(other.badContacts))
            return false;
        if (count != other.count)
            return false;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (errors == null) {
            if (other.errors != null)
                return false;
        } else if (!errors.equals(other.errors))
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
        if (timeStamp == null) {
            if (other.timeStamp != null)
                return false;
        } else if (!timeStamp.equals(other.timeStamp))
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

    
    public String getTimeStamp() {
        return timeStamp;
    }

    
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    
    public List<FileConfig> getFileConfigs() {
        return fileConfigs;
    }

    
    public void setFileConfigs(List<FileConfig> fileConfigs) {
        this.fileConfigs = fileConfigs;
    }

    
    public Duration getDuration() {
        return duration;
    }

    
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
