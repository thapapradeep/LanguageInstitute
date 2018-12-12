package com.soft.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

//this class is the heart of the system that will configure overall security
@Component
@Configuration // configuration
@EnableWebSecurity // enabling web security
@EnableGlobalMethodSecurity(securedEnabled = true) // global method security
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { // extending WebSecurityConfigurerAdapter

	// autowiring url Handler class present in spring repository bin
	@Autowired
	private CustomUrlSuccessHandler urlHandler;

	// autowiring user login service present in spring repository bin
	@Autowired
	private com.soft.app.service.UserLoginService userLoginService;

	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/admin**").access("hasRole('ROLE_ADMIN')"). // secured url if role
																									// is admin
				antMatchers("/addUser").access("hasRole('ROLE_ADMIN')").antMatchers("/add-addUser")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/users").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/updateUser").access("hasRole('ROLE_ADMIN')").antMatchers("/update-updateUser")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/deleteUser").access("hasRole('ROLE_ADMIN')").
				antMatchers("/manager**").access("hasRole('ROLE_MANAGER')").and()
				.formLogin().loginPage("/").loginProcessingUrl("/j_spring_security_check") // login page url and login
																							// processing url
				.usernameParameter("email").passwordParameter("password") // username and password parameter
				.successHandler(urlHandler).failureUrl("/?error") // login error url
				.and().logout().logoutSuccessUrl("/?logout").and() // logout url
				.exceptionHandling().accessDeniedPage("/403").and().csrf().disable(); // access denied page 403
		
	}

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userLoginService);

	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
