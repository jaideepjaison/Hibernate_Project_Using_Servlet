package infinite.JSPDev;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Request;


public class PersonDAO {
	Connection connection;
	PreparedStatement pst;
	
	public Person[] showPersonData() throws ClassNotFoundException, SQLException
	{
		connection=ConnectionHelper.getConnection();
		String q="select * from person";
		pst=connection.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		List<Person> pslist=new ArrayList<Person>();
		Person per=null;
		while(rs.next())
		{
			per=new Person();
			per.setSsn(rs.getInt("ssn"));
			per.setId(rs.getInt("id"));
			per.setPersonname(rs.getString("personname"));
			per.setDob(rs.getDate("dob"));
			per.setGender(rs.getString("gender"));
			pslist.add(per);
		}
			
		return pslist.toArray(new Person[pslist.size()]);
	}
	

	public Person searchEmploy(int ssn) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from person where ssn=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, ssn);
		ResultSet rs = pst.executeQuery();
		Person employ = null;
		if (rs.next()) {
			employ = new Person();
			employ.setSsn(rs.getInt("ssn"));
			employ.setId(rs.getInt("id"));
			employ.setPersonname(rs.getString("personname"));
			employ.setGender(rs.getString("gender"));
						
		}
		return employ;
	}
	
	public String UpdatePerson(Person employ) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update person set personname=?, id=?, gender=? where ssn=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, employ.getPersonname());
		pst.setInt(2, employ.getId());
		pst.setString(3, employ.getGender());
		pst.setInt(4, employ.getSsn());
		//pst.setInt(6, employ.getEmpno());
		pst.executeUpdate();
		return null;
	}
	
	public String insertdata(Person emp) throws ClassNotFoundException, SQLException
	
	{
		connection=ConnectionHelper.getConnection();
		String cmd="insert into person(id,personname,gender,dob) values(?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setInt(1, emp.getId());
		pst.setString(2, emp.getPersonname());
		pst.setString(3, emp.getGender());
		pst.setDate(4, emp.getDob());
		pst.executeUpdate();
		return "inseted";
		
	}
	
	public String deletePerson(int ssn) throws ClassNotFoundException, SQLException
	{
		connection=ConnectionHelper.getConnection();
		String q="delete from person where ssn=?";
		pst=connection.prepareStatement(q);
		pst.setInt(1, ssn);
		pst.executeUpdate();
		return null;
		
	}
}
