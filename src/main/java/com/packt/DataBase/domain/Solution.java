package com.packt.DataBase.domain;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "solution")
    private List<Defect> defects;
	
	String name;
	String description;

//-------------------------------------------------constructors-------------------------------------------------------------------------
	
	public Solution() { }
	
	
	public Solution(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	

//-------------------------------------------------getters and setters-------------------------------------------------------------------------
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
