package com.structural.pattern.Facade;

import java.sql.Connection;

public class MysqlHelper {
	 public static Connection getMySqlDBConnection(){
	        //get MySql DB connection using connection parameters
	        return null;
	    }
	     
	    public void generateMySqlPDFReport(String tableName, Connection con){
	        //get data from table and generate pdf report
	    }
	     
	    public void generateMySqlHTMLReport(String tableName, Connection con){
	        //get data from table and generate pdf report
	    }
}
