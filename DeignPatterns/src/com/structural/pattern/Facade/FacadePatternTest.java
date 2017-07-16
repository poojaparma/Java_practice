package com.structural.pattern.Facade;

import java.sql.Connection;
import java.util.Observable;
import java.util.Observer;

public class FacadePatternTest {
	public static void main(String[] args) {
        String tableName="Employee";
         
        //generating MySql HTML report and Oracle PDF report without using Facade
        Connection con = MysqlHelper.getMySqlDBConnection();
        MysqlHelper mySqlHelper = new MysqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);
         
        Connection con1 = OraclHelper.getOracleDBConnection();
        OraclHelper oracleHelper = new OraclHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);
         
        //generating MySql HTML report and Oracle PDF report using Facade
        Facade.generateReport(Facade.DBTypes.MYSQL, Facade.ReportTypes.HTML, tableName);
        Facade.generateReport(Facade.DBTypes.ORACLE, Facade.ReportTypes.PDF, tableName);
    }
}
