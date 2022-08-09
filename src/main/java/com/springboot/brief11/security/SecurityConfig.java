package com.springboot.brief11.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = passwordEncoder();
		
		String encodPWD = passwordEncoder().encode("admin");
		System.out.println(encodPWD);
		
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http.formLogin()
	/*.loginPage("/login")*/;
	
	http.authorizeRequests().antMatchers("/","/delete/{id}/**", "/updateForm/{id}/**", "/saveEmployee/**", "/showNewEmployeeForm/**").hasRole("ADMIN");
	http.authorizeRequests().antMatchers("/index/**").hasRole("ADMIN");
	http.authorizeRequests().anyRequest().authenticated();
	http.exceptionHandling().accessDeniedPage("/403");
	
	}
	
	

@Bean
PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
	
//	private PasswordEncoder passwordEncoder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
