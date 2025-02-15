package com.coletas.coletas.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BuildInfo {
	 public static void printBuildDetails() {
	        try (InputStream input = BuildInfo.class.getClassLoader()
	                .getResourceAsStream("META-INF/build-info.properties")) {
	            if (input == null) {
	                System.out.println("Build information not found.");
	                return;
	            }
	            Properties prop = new Properties();
	            prop.load(input);

	            System.out.println("=== Build Information ===");
	            prop.forEach((key, value) -> System.out.println(key + ": " + value));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
