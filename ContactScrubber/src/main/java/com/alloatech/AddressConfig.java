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
 *  Initial commit:  Sep 18, 20175:43:13 AM
 *  User:  thor 
 */
package com.alloatech;


/**
 * @author thor
 */
public class AddressConfig {
    private int index;
    private AddressType type;
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public AddressType getType() {
        return type;
    }
    
    public void setType(AddressType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AddressConfig [index=" + index + ", type=" + type + "]";
    }
}
