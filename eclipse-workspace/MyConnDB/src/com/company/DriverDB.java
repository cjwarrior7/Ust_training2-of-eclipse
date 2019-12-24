package com.company;
import com.derby.*;
import com.mysql.*;
import com.oracle.*;

public class DriverDB  {
	public static Connection getConnection(String str) {
		if(str.equalsIgnoreCase("Mysql")) {
			return new Mysql();
		}
		else if(str.equalsIgnoreCase("Oracle")) {
			return new Oracle();
		}
	    else if(str.equalsIgnoreCase("Derby")){
	    	return new Derby();
		}
		
		return null;
	}
	

}
