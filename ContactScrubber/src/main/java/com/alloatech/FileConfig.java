/**
 * Proprietary and Confidential AlloaTech, LLC. This document contains material which is proprietary and confidential property of ThorCode. The right
 * to view, reproduce, modify, distribute, or in any way display this work is prohibited without the expressed written consent of ThorCode Copyright
 * &copy; 2017 Initial commit: Sep 18, 20175:42:13 AM User: thor
 */
package com.alloatech;

import java.util.List;

/**
 * @author thor
 */
public class FileConfig {

    private String fileName;
    private String fileWithPath;
    private List<AddressConfig> addressConfigs;
    private int contactCount;
    private long badContactCount;
    private double contactQuality;

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
        return "FileConfig [fileName=" + fileName + ", fileWithPath=" + fileWithPath + ", addressConfigs=" + addressConfigs
                + ", contactCount=" + contactCount + ", badContactCount=" + badContactCount + ", contactQuality=" + contactQuality
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressConfigs == null) ? 0 : addressConfigs.hashCode());
        result = prime * result + (int) (badContactCount ^ (badContactCount >>> 32));
        result = prime * result + contactCount;
        long temp;
        temp = Double.doubleToLongBits(contactQuality);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((fileWithPath == null) ? 0 : fileWithPath.hashCode());
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
        FileConfig other = (FileConfig) obj;
        if (addressConfigs == null) {
            if (other.addressConfigs != null)
                return false;
        } else if (!addressConfigs.equals(other.addressConfigs))
            return false;
        if (badContactCount != other.badContactCount)
            return false;
        if (contactCount != other.contactCount)
            return false;
        if (Double.doubleToLongBits(contactQuality) != Double.doubleToLongBits(other.contactQuality))
            return false;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        if (fileWithPath == null) {
            if (other.fileWithPath != null)
                return false;
        } else if (!fileWithPath.equals(other.fileWithPath))
            return false;
        return true;
    }

    public int getContactCount() {
        return contactCount;
    }

    public void setContactCount(int contactCount) {
        this.contactCount = contactCount;
    }

    public double getContactQuality() {
        return contactQuality;
    }

    public void setContactQuality(double contactQuality) {
        this.contactQuality = contactQuality;
    }

    public String getFileWithPath() {
        return fileWithPath;
    }

    public void setFileWithPath(String fileWithPath) {
        this.fileWithPath = fileWithPath;
    }

    public long getBadContactCount() {
        return badContactCount;
    }

    public void setBadContactCount(long badContactCount) {
        this.badContactCount = badContactCount;
    }
}
