package com.alloatech;

public class Contact {

	private String id;
	private String name;
	private String addressLine1;

	public Contact() {
	}

	public Contact(String id, String name, String addressLine1) {
		super();
		this.id = id;
		this.name = name;
		this.addressLine1 = addressLine1;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", addressLine1=" + addressLine1 + "]";
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

    
    public String getAddressLine1() {
        return addressLine1;
    }

    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

}
