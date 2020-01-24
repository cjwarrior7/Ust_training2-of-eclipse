package com.ust.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EmployeeDTO {
	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(generator="auto")
	private int eid;
	private String ename;
	private double esal;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "cid")
	private CompanyDTO cdto;
	public CompanyDTO getCdto() {
		return cdto;
	}
	public void setCdto(CompanyDTO cdto) {
		this.cdto = cdto;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsal() {
		return esal;
	}
	public void setEsal(double esal) {
		this.esal = esal;
	}
	

}
