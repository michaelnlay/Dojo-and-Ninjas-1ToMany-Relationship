package com.ml.dojoninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

//this entity and at table name book is to tell compilier that we will build a table in mysql call book
@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 30, message="The name must be no less than 3, and not over 30!")
    private String firstname;
    
    @NotNull
    @Size(min = 3, max = 30, message="The name must be no less than 3, and not over 30!")
    private String lastname;
    
    @NotNull
    @Max(value=100, message="Must be less than 100!")
    @Min(value=0, message="Must be higher than 0!")
    private Integer age ;
    
    
    
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //Creating the many to one relationship with Dojo class
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
//CONSTRUCTORS=========================================================================================================
    
    public Ninja() {
    	
    }

    

	public Ninja(
	String firstname,
		String lastname,
		 Integer age) {
	
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
}


	public Ninja(Long id,
			 String firstname,
			String lastname,
			Integer age,
			Date createdAt, Date updatedAt, Dojo dojo) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.dojo = dojo;
	}


	//GETTER & SETTERS==========================================================================================================

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Dojo getDojo() {
		return dojo;
	}



	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}


	
	
	//==============================================================
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		

		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	
}
    
    
    