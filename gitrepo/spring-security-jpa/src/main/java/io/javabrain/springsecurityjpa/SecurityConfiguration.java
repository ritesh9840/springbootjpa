package io.javabrain.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	
	//MyUserDetailService  userDetailsService;
	
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		auth.userDetailsService(userDetailsService);
	}

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("admin").hasRole("ADMIN")
		.antMatchers("user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and().formLogin();
		
	}
	
	// This bean annotation is necessary
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return  NoOpPasswordEncoder.getInstance();
	}
}
