package com.alloatech;

import java.util.List;

public class Contact {

    private String id;
    private String name;
    private List<Address> addresses;
    private ContactQuality quality;

    public Contact() {}

    public Contact(String id, String name, List<Address> addresses) {
        super();
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", addresses=" + addresses + ", quality=" + quality + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    
    public ContactQuality getQuality() {
        return quality;
    }

    
    public void setQuality(ContactQuality quality) {
        this.quality = quality;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((quality == null) ? 0 : quality.hashCode());
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
        Contact other = (Contact) obj;
        if (addresses == null) {
            if (other.addresses != null)
                return false;
        } else if (!addresses.equals(other.addresses))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (quality == null) {
            if (other.quality != null)
                return false;
        } else if (!quality.equals(other.quality))
            return false;
        return true;
    }
}
