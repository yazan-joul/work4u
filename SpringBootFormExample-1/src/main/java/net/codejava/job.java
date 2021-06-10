package net.codejava;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "job")
@Table(name = "jobs")
public class job implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String location;
	@Column
	private String name;
	@Column
	private String details;
	@Column
	private Integer phonenum;
	@Column
	private Integer iduser;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(Integer phonenum) {
		this.phonenum = phonenum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public job() {
		super();
	}
	public job(Integer id, String location, String name, String details, Integer phonenum) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.details = details;
		this.phonenum = phonenum;
	}
	public int getIduser() {
		return iduser;
	}
	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}
	@Override
	public String toString() {
		return "job [id=" + id + ", location=" + location + ", name=" + name + ", details=" + details + ", phonenum="
				+ phonenum + "]";
	}
}
