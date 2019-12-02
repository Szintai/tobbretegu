package com.uni.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Authors")
@SequenceGenerator(name = "default_gen", sequenceName = "author_seq", allocationSize = 1)
public class Author extends BaseEntity{

	@Column(nullable = false)
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
