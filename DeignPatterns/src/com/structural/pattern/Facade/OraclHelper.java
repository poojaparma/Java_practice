package com.structural.pattern.Facade;

import java.sql.Connection;

public class OraclHelper {

    public static Connection getOracleDBConnection(){
        //get Oracle DB connection using connection parameters
        return null;
    }
     
    public void generateOraclePDFReport(String tableName, Connection con){
        //get data from table and generate pdf report
    }
     
    public void generateOracleHTMLReport(String tableName, Connection con){
        //get data from table and generate pdf report
    }
}
