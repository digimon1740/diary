package com.example.diary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
				.loginPage("/").loginProcessingUrl("/login").failureUrl("/login-error")
				.defaultSuccessUrl("/main", true)
				.usernameParameter("username")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
				.logoutSuccessUrl("/").and().csrf().disable().httpBasic();
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
				.antMatchers("/login.html")
				.antMatchers("/robots.txt");
	}

	@Bean(name = "UserAuthenticationProvider")
	public UserAuthenticationProvider UserAuthenticationProvider() {
		return new UserAuthenticationProvider();
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER");
//	}
}
