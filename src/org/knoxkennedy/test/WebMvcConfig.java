package org.knoxkennedy.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
// scan for controllers
@ComponentScan(basePackages = { "org.knoxkennedy.test" })
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	//Logger logger = Logger
		//	.getLogger(WebMvcConfig.class.getCanonicalName());
	/**
	 * @return the view resolver
	 */
	@Bean
	public ViewResolver viewResolver() {
		//logger.log(Level.DEBUG, "setting up view resolver");
		//logger.log(Level.DEBUG, "");

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		//logger.debug("configureDefaultServletHandling");
		// if the spring dispatcher is mapped to / then forward non handled
		// requests
		// (e.g. static resource) to the container's "default servlet"
		configurer.enable();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/").addResourceLocations(
				"/resources/**");
	}
	
}