package infinite.JSPDev;

import java.sql.Date;

public class Person {
	private int ssn;
	private int id;
	private String personname;
	private Date dob;
	private String gender;
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date date) {
		this.dob = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [ssn=" + ssn + ", id=" + id + ", personname=" + personname + ", dob=" + dob + ", gender="
				+ gender + "]";
	}
	
}
