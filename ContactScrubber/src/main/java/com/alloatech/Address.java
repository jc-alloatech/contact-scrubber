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
 *  Initial commit:  Sep 18, 20175:39:01 AM
 *  User:  thor 
 */
package com.alloatech;


/**
 * @author thor
 */
public class Address {
    private AddressType type;
    private String Address;
    
    public AddressType getType() {
        return type;
    }
    
    public void setType(AddressType type) {
        this.type = type;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Address [type=" + type + ", Address=" + Address + "]";
    }
    
}
