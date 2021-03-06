package com.realstate.doa;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.realstate.person.Client;
import com.realstate.property.Property;



public class ClientDAO extends DAObase {
	public void findAll() {
		ResultSet rs=exec("");
	}
	
	public Client getClientObject(int clientId) {
		Client per = new Client();
		String query = "Select p.id as id,p.address as address,p.name as name from person p join client o on o.personID=p.id where o.id =" + clientId;
		ResultSet rs = this.exec(query);
		try {
			while (rs.next()) {
				per.setId(Integer.parseInt(rs.getString("id")));
				per.setAddress(rs.getString("address"));
				per.setName(rs.getString("name"));
//				per.setPhone((rs.getString("phone")));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(per);
		return per;
	}
}
