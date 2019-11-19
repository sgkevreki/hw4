package com.candidjava;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

/**
 * Entity implementation class for Entity: User
 *
 */
public class Users implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	 
	private Integer id; 
	
	private String name; 
	private String userid; 
	private String password;
	private static final long serialVersionUID = 1L;	
	

	public Users( int id,String name, String userid,String password) {
	      super( );
	      this.id= id;
	      this.name = name;
	      this.userid = userid;
	      this.password = password;
	   }
	   
	
	public Users() {
		super();
	} 
	
	public Integer getId() {
 		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	   
	public String getName() {
 		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	   
	public String getUserid() {
 		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	   
	public String getPassword() {
 		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
