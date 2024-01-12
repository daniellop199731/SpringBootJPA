package com.bolsadeideas.springboot.web.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_persons")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cl_id")
	private Long id;
	
	@Column(name = "cl_name")
	private String name;
	
	@Column(name = "cl_lastname")
	private String lastname;
	
	@Column(name = "cl_programmingLanguage")
	private String programmingLanguage;
	
	//Si se tiene un construtctor personalizado como este, se debe tener un constructor vacio
	public Person(Long id, String name, String lastname, String programmingLanguage) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.programmingLanguage = programmingLanguage;
	}
	
	//Soy el constructor vacio
	public Person() {}	
	
	//Pero si no se necesita un constructor personlizado, la definicion del contructor vacio sobra

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgramingLanguage(String programingLanguage) {
		this.programmingLanguage = programingLanguage;
	}

	@Override
	public String toString() {
		return "id: " + this.id + " : name : " + this.name + " : lastaname : " + 
				this.lastname + " : programming languaje : " + this.programmingLanguage;
	}		
 	
}
