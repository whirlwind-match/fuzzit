/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fuzzydb.samples.mvc.config;

import java.util.List;

import javax.inject.Inject;

import org.fuzzydb.samples.social.ConnectedToHandlerInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.mobile.device.DeviceWebArgumentResolver;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

import com.wwm.attrs.converters.RefToStringConverter;
import com.wwm.attrs.converters.StringToRefConverter;

@Configuration
@ComponentScan("org.fuzzydb.samples.mvc")
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Inject
	private ConnectionRepository connectionRepository;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ConnectedToHandlerInterceptor(connectionRepository));		
		registry.addInterceptor(new DeviceResolverHandlerInterceptor());
	}

	// TODO: BLOG THIS - It's really useful for Spring Mobile users to know how to do it in JavaConfig
	@Override
	protected void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ServletWebArgumentResolverAdapter(new DeviceWebArgumentResolver()));
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		super.addFormatters(registry);
		registry.addConverter(new StringToRefConverter());
		registry.addConverter(new RefToStringConverter());
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// for spring-js dojo
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/META-INF/web-resources/", "/static/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login");
		registry.addViewController("/mobile/home");
		registry.addViewController("/mobile/grid");
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}
	
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/WEB-INF/messages/messages");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }
    
	@Override
	@Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
    	RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
    	adapter.setIgnoreDefaultModelOnRedirect(true);
    	return adapter;
    };

    @Bean
    public ViewResolver viewResolver() {
    	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    	viewResolver.setPrefix("/WEB-INF/views/");
    	viewResolver.setSuffix(".jsp");
    	return viewResolver;
    }
    
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {
				"/WEB-INF/layouts/tiles.xml",
				"/WEB-INF/views/**/tiles.xml"                           
		});
		configurer.setCheckRefresh(true);
		return configurer;
	}
		
	@Bean
	public ViewResolver tilesViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		viewResolver.setOrder(4);
		return viewResolver;
	}
}
