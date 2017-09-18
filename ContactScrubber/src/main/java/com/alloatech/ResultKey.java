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
 *  Initial commit:  Sep 17, 20177:03:12 PM
 *  User:  thor 
 */
package com.alloatech;


/**
 * @author thor
 */
public class ResultKey {
    private String fromId;
    private String toId;
    
    public ResultKey(String fromId, String toId) {
        super();
        this.fromId = fromId;
        this.toId = toId;
    }

    public String getFromId() {
        return fromId;
    }
    
    public void setFromId(String fromId) {
        this.fromId = fromId;
    }
    
    public String getToId() {
        return toId;
    }
    
    public void setToId(String toId) {
        this.toId = toId;
    }

    @Override
    public String toString() {
        return "ResultKey [fromId=" + fromId + ", toId=" + toId + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fromId == null) ? 0 : fromId.hashCode());
        result = prime * result + ((toId == null) ? 0 : toId.hashCode());
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
        ResultKey other = (ResultKey) obj;
        if (fromId == null) {
            if (other.fromId != null)
                return false;
        } else if (!fromId.equals(other.fromId))
            return false;
        if (toId == null) {
            if (other.toId != null)
                return false;
        } else if (!toId.equals(other.toId))
            return false;
        return true;
    }
}
