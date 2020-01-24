package com.ust.onetomanyrel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;




@Entity
public class FacultyDTO {
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
private int fid;
private String fname;
//ctrl+alt+<> to select line
//cascade persistence

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(referencedColumnName="fid")
private List<StudentDTO> slist;
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public List<StudentDTO> getSlist() {
	return slist;
}
public void setSlist(List<StudentDTO> slist) {
	this.slist = slist;
}
	
}
