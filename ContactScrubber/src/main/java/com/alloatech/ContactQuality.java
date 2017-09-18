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
 *  Initial commit:  Sep 18, 20175:20:50 AM
 *  User:  thor 
 */
package com.alloatech;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thor
 */
public class ContactQuality {
    private int score;
    private List<String> issues;
    
    
    public ContactQuality() {
        issues = new ArrayList<>();
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public List<String> getIssues() {
        return issues;
    }
    
    public void setIssues(List<String> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "ContactQuality [score=" + score + ", issues=" + issues + "]";
    }

    public void adjustScore(double adjustment) {
        score *= adjustment;
    }
}
