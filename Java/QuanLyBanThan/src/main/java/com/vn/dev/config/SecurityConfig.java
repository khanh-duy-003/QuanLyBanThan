package com.vn.dev.config;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vn.dev.entity.Account;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	  
//	@Autowired
//	AccountService accountService;
    
	private PasswordEncoder pe;
	
	public Account findAcc(String username) {
		List<Account> acc = new ArrayList<Account>();
		acc.add(new Account("admin","123","ADMIN"));
		acc.add(new Account("user","123","USER"));
		acc.add(new Account("pm","123","PM"));

		for (Account account : acc) {
	        if (account.getUsername().equals(username)) {
	            return account;
	        }
	    }
		
		return null;
	}

	// Cung cấp nguồn dữ liệu đăng nhập
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(username -> {
//			try {
//				Account user = accountService.findById(username);
//				String password = pe.encode(user.getPassword());
//				String[] roles = user.getAuthorities().stream().map(er -> er.getRole().getId())
//						.collect(Collectors.toList()).toArray(new String[0]);
//				return User.withUsername(username).password(password).roles(roles).build();
//			} catch (NoSuchElementException e) {
//				throw new UsernameNotFoundException(username + "not found!");
//			}
//		});
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			List<String> autho = new ArrayList<>();
			autho.add("ADMIN");
			autho.add("PM");
			autho.add("USER");
			try {
				Account user = findAcc(username);
				String password = pe.encode(user.getPassword());
				String[] roles = autho.stream().map(er -> er)
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username + "not found!");
			}
		});
	}

	// Phân quyền sử dụng
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/admin/**")
				.hasAnyRole("ADMIN", "PM").antMatchers("/rest/authorities").hasRole("USER").anyRequest().permitAll();

		http.formLogin().loginPage("/login").loginProcessingUrl("/login")
				.defaultSuccessUrl("/login/success", false).failureUrl("/login/error");

		http.rememberMe().tokenValiditySeconds(86400);

		http.exceptionHandling().accessDeniedPage("/security/unauthoried");

		http.logout().logoutUrl("/security/logoff").logoutSuccessUrl("/security/logoff/success");
		
	}
		
		

	// Cơ chế mã hóa mật khẩu
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Cho phép truy xuất REST API từ bên ngoài (domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
}