package com.revature.models;

import java.util.Objects;

public class Item {
	public int id;
	public String name;
	
	protected Item() {
		super();
	}

	protected Item(int itemId, String name) {
		super();
		this.id = itemId;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Item))
			return false;
		Item other = (Item) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	
}
