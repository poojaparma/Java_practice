package com.structural.pattern.Facade;

import java.sql.Connection;

public class Facade {
//Provide a unified interface to a set of interfaces in a subsystem. Facade Pattern defines a
	//higher-level interface that makes the subsystem easier to use.
	 public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName){
	        Connection con = null;
	        switch (dbType){
	        case MYSQL: 
	            con = MysqlHelper.getMySqlDBConnection();
	            MysqlHelper mySqlHelper = new MysqlHelper();
	            switch(reportType){
	            case HTML:
	                mySqlHelper.generateMySqlHTMLReport(tableName, con);
	                break;
	            case PDF:
	                mySqlHelper.generateMySqlPDFReport(tableName, con);
	                break;
	            }
	            break;
	        case ORACLE: 
	            con = OraclHelper.getOracleDBConnection();
	            OraclHelper oracleHelper = new OraclHelper();
	            switch(reportType){
	            case HTML:
	                oracleHelper.generateOracleHTMLReport(tableName, con);
	                break;
	            case PDF:
	                oracleHelper.generateOraclePDFReport(tableName, con);
	                break;
	            }
	            break;
	        }
	         
	    }
	     
	    public static enum DBTypes{
	        MYSQL,ORACLE;
	    }
	     
	    public static enum ReportTypes{
	        HTML,PDF;
	    }
}
