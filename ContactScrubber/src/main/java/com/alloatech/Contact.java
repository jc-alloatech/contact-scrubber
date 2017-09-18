package com.alloatech;

import java.util.List;

public class Contact {

    private String id;
    private String name;
    private List<Address> addresses;

    public Contact() {}

    public Contact(String id, String name, List<Address> addresses) {
        super();
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
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
}
