package com.learnjava.cronerservce.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Slf4j
public class ManualQueryOperations {
    @Value("${application.mysqlConfigOrderSystem.jdbcUrl}")
    private String jdbcUrl;

    @Value("${application.mysqlConfigOrderSystem.user}")
    private String userName;

    @Value("${application.mysqlConfigOrderSystem.password}")
    private String password;

    @Value("${application.mysqlConfigOrderSystem.driverClass}")
    private String driverClass;


    public Boolean executeRequestedQuery(String query) {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(jdbcUrl, userName, password);
            stmt = con.createStatement();
            int updatedRecordCount = stmt.executeUpdate(query);
            if (updatedRecordCount > 0) {
                log.info("Query: {} executed successfully", query);
                return true;
            }
        } catch (Exception e) {
            log.error("Exception occurred while executing query. Query :{} and exception :{}", query, e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception ex) {
                log.error("Exception occurred while closing sql connection.Exception :{}", ex.getMessage());
            }
        }
        return false;
    }
}
