package com.alloatech;

public class Contact {

	private int id;
	private String name;
	private String addressLine1;

	public Contact() {
	}

	public Contact(int id, String name, String addressLine1) {
		super();
		this.id = id;
		this.name = name;
		this.addressLine1 = addressLine1;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", addressLine1=" + addressLine1 + "]";
	}

}
