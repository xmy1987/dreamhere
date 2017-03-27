package com.xmy.dh;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by qinyong on 2017/3/27.
 */
public class TomcatPoolsTest {
    public static void main(String[] args) throws SQLException {
        PoolProperties prop = new PoolProperties();
        prop.setUrl("jdbc:mysql://192.168.178.50:3358/pbs");
        prop.setDriverClassName("com.mysql.jdbc.Driver");
        prop.setUsername("pbs");
        prop.setPassword("pbs");
        prop.setJmxEnabled(true);
        prop.setTestOnBorrow(true);
        prop.setTestWhileIdle(false);
        prop.setValidationQuery("SELECT 1");
        prop.setValidationInterval(30000);
        prop.setTimeBetweenEvictionRunsMillis(30000);
        prop.setMaxActive(100);
        prop.setInitialSize(10);
        prop.setMaxWait(10000);
        prop.setRemoveAbandonedTimeout(60);
        prop.setMinEvictableIdleTimeMillis(30000);
        prop.setMinIdle(10);
        prop.setLogAbandoned(true);
        prop.setRemoveAbandoned(true);
//        prop.setJdbcInterceptors(
//                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
//                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        DataSource dataSource = new DataSource(prop);
        Connection conn = dataSource.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select plan_id,plan_name from buying_plan");
        while (rs.next()){
            System.out.println(String.format("planId=%s,plan_name",rs.getLong(1),rs.getString(2)));
        }
        rs.close();
        st.close();
        if (conn!=null) conn.close();
    }
}
