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
 *  Initial commit:  Sep 18, 20175:42:13 AM
 *  User:  thor 
 */
package com.alloatech;

import java.util.List;

/**
 * @author thor
 */
public class FileConfig {
    private String fileName;
    private List<AddressConfig> addressConfigs;
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public List<AddressConfig> getAddressConfigs() {
        return addressConfigs;
    }
    
    public void setAddressConfigs(List<AddressConfig> addressConfigs) {
        this.addressConfigs = addressConfigs;
    }

    @Override
    public String toString() {
        return "FileConfig [fileName=" + fileName + ", addressConfigs=" + addressConfigs + "]";
    }
}
