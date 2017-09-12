package com.example.diary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/css/**", "/").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/user/**").hasRole("USER")
				.and()
				.formLogin()
				.loginPage("/").loginProcessingUrl("/login").failureUrl("/login-error");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers(HttpMethod.OPTIONS, "*//**")
				.antMatchers("/assets*//**")
				.antMatchers("/css*//**")
				.antMatchers("/fonts*//**")
				.antMatchers("/img*//**")
				.antMatchers("/js*//**")
				.antMatchers("/font-awesome*//**")
				.antMatchers("/main.html")
				.antMatchers("/robots.txt");
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER");
//	}
}
