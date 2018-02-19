package com.monapp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login/log").permitAll().defaultSuccessUrl("/matiere/listMatiere");

		http.csrf().disable();
		http.headers().frameOptions().disable();
	}

	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.inMemoryAuthentication()
	// .withUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build());
	// auth.inMemoryAuthentication()
	// .withUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
	//
	// }

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enable from users where username=?")
				.authoritiesByUsernameQuery("select user_id, role from user_roles where user_id=?");
	}
}
