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
 *  Initial commit:  Sep 17, 20177:34:19 PM
 *  User:  thor 
 */
package com.alloatech;

/**
 * @author  thor
 */
public class ScrubbingResultData {

    public String key;
    public String fieldName;
    public String fieldValue;
    public int simpleRatio;
    public int partialRatio;
    public int tokenSortRatio;
    public int tokenSetRatio;
    public int weightedRation;

    public ScrubbingResultData() {}

    
    public String getKey() {
        return key;
    }

    
    public void setKey(String key) {
        this.key = key;
    }

    
    public String getFieldName() {
        return fieldName;
    }

    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    
    public String getFieldValue() {
        return fieldValue;
    }

    
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    
    public int getSimpleRatio() {
        return simpleRatio;
    }

    
    public void setSimpleRatio(int simpleRatio) {
        this.simpleRatio = simpleRatio;
    }

    
    public int getPartialRatio() {
        return partialRatio;
    }

    
    public void setPartialRatio(int partialRatio) {
        this.partialRatio = partialRatio;
    }

    
    public int getTokenSortRatio() {
        return tokenSortRatio;
    }

    
    public void setTokenSortRatio(int tokenSortRatio) {
        this.tokenSortRatio = tokenSortRatio;
    }

    
    public int getTokenSetRatio() {
        return tokenSetRatio;
    }

    
    public void setTokenSetRatio(int tokenSetRatio) {
        this.tokenSetRatio = tokenSetRatio;
    }

    
    public int getWeightedRation() {
        return weightedRation;
    }

    
    public void setWeightedRation(int weightedRation) {
        this.weightedRation = weightedRation;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
        result = prime * result + ((fieldValue == null) ? 0 : fieldValue.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + partialRatio;
        result = prime * result + simpleRatio;
        result = prime * result + tokenSetRatio;
        result = prime * result + tokenSortRatio;
        result = prime * result + weightedRation;
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
        ScrubbingResultData other = (ScrubbingResultData) obj;
        if (fieldName == null) {
            if (other.fieldName != null)
                return false;
        } else if (!fieldName.equals(other.fieldName))
            return false;
        if (fieldValue == null) {
            if (other.fieldValue != null)
                return false;
        } else if (!fieldValue.equals(other.fieldValue))
            return false;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (partialRatio != other.partialRatio)
            return false;
        if (simpleRatio != other.simpleRatio)
            return false;
        if (tokenSetRatio != other.tokenSetRatio)
            return false;
        if (tokenSortRatio != other.tokenSortRatio)
            return false;
        if (weightedRation != other.weightedRation)
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "\n\t\tScrubbingResultData [key=" + key + ", fieldName=" + fieldName + ", fieldValue=" + fieldValue + ", simpleRatio="
                + simpleRatio + ", partialRatio=" + partialRatio + ", tokenSortRatio=" + tokenSortRatio + ", tokenSetRatio="
                + tokenSetRatio + ", weightedRation=" + weightedRation + "]";
    }
}