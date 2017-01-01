package com.electro.appconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
DataSource dataSource;
	
@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.jdbcAuthentication().dataSource(dataSource)
.usersByUsernameQuery("select userName,password, enabled from User where userName=?")
.authoritiesByUsernameQuery("select userName, roleName from User u,UserRole ur,Role r where u.userId=ur.userId and r.roleId=ur.roleId and userName=?");
	} 

@Override
protected void configure(HttpSecurity http) throws Exception {

http.authorizeRequests()
//.antMatchers("/log").access("hasRole('ROLE_ADMIN')")
.anyRequest().permitAll()
.and()
.formLogin().loginPage("/login").loginProcessingUrl("/perform_login").defaultSuccessUrl("/")
.usernameParameter("userName").passwordParameter("password")
.and()
.logout().logoutSuccessUrl("/login?logout") 
.and()
//.exceptionHandling()
//.and()
.csrf().disable();
}
}
	
	


