package com.revature.models;

public class Service {
	private int id;
	private String name;
	private int skillLevel;
	private String category;

	public Service() {
		
	}

	protected Service(int id, String name, int skillLevel, String category) {
		super();
		this.id = id;
		this.name = name;
		this.skillLevel = skillLevel;
		this.category = category;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + skillLevel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Service))
			return false;
		Service other = (Service) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (skillLevel != other.skillLevel)
			return false;
		return true;
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

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int serviceGrade() {
		int res = 0;
		if(skillLevel >= 3) {
			
		}
		return res;
	}
	
	public boolean request() {
		return false;
	}
}
