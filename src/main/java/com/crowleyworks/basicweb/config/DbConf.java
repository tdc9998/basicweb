package com.crowleyworks.basicweb.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConf {

	@Bean
	public DriverManagerDataSource dataSource() {		
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		Map<String,String> allEnv = System.getenv();
		String ipAddr = allEnv.get("DB_PORT"); // Will be something like: tcp://172.17.0.2:3306  Remove the tcp
		if ((ipAddr != null) && (ipAddr.length() > 4)) {
			ipAddr = ipAddr.substring(3);
		}
		String pw = allEnv.get("DB_ENV_MYSQL_ROOT_PASSWORD");
		String dbName = "/basicweb"; //allEnv.get("DB_NAME");
		String fullURL = "jdbc:mysql"+ipAddr+dbName;
		System.err.println("Full URL: " + fullURL);
		dmds.setUrl(fullURL);
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUsername("root");
		dmds.setPassword(pw);
		return dmds;
	}
}
