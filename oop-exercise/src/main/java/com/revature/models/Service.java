package com.revature.models;

public class Service {
	private String id;
	private String name;

	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Service(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Service))
			return false;
		Service other = (Service) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id){
		try {
			if(requested()) {
				this.id = id;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean requested() {
		return false;
		
	}
	

}
