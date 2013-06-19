package org.knoxkennedy.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.knoxkennedy.test" })
public class RootConfig {
 
   //@Bean public SomeClass someClass() { 
   //   return someInstance;
   //}
	
	@Bean public String someClass() {
		return "Beanie";
	}
 
}