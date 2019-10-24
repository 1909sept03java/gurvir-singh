package com.revature.week6challenge.model;

public class SCourse {
	int id;
	String name;
	int cId;
	public SCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SCourse(int id, String name, int cId) {
		super();
		this.id = id;
		this.name = name;
		this.cId = cId;
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
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	@Override
	public String toString() {
		return "SCourse [id=" + id + ", name=" + name + ", cId=" + cId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cId;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SCourse other = (SCourse) obj;
		if (cId != other.cId)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
