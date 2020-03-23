package util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
		public static Properties readProperties() {
			ClassLoader classLoader =  Thread.currentThread().getContextClassLoader();
			Properties properties = new Properties();
			try {
				properties.load(classLoader.getResourceAsStream("/config/database.properties"));
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Catch ban eh");
			}
			return properties;
		}
}
