package com.ust.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class VenderDTO {
	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator="auto")
	private int vid;
	 private String vname;
	 private String vtype;
	 @ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="ven_cus",joinColumns=@JoinColumn(name="vid"),inverseJoinColumns=@JoinColumn(name="cid"))
	 private List<CustomerDTO> lcustomer;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public List<CustomerDTO> getLcustomer() {
		return lcustomer;
	}
	public void setLcustomer(List<CustomerDTO> lcustomer) {
		this.lcustomer = lcustomer;
	}
	 
	

}
