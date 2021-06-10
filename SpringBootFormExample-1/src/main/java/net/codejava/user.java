package net.codejava;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "user")
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class user implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String rptpassword;

	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRptpassword() {
		return rptpassword;
	}
	public void setRptpassword(String rptpassword) {
		this.rptpassword = rptpassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setId(int id) {
		this.id = id;
	}
	public user(int id, String username, String password, String rptpassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rptpassword = rptpassword;
	}
	public user() {
		super();
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", rptpassword=" + rptpassword
+		 "]";
	}
}
