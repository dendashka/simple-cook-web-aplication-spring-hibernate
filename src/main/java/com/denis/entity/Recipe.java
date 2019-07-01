package com.denis.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String text;
	private String tag;
	private String filename;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User author;
		

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recipe(String text, String tag, User user) {
		super();
		this.author = user;
		this.text = text;
		this.tag = tag;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public String getAuthorName() {
		return author !=null? author.getUsername():"<none>";
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
		

}
