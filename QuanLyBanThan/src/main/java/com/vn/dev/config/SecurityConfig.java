package com.vn.dev.config;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vn.dev.entity.Account;
import com.vn.dev.service.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AccountService accountService;

	private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

	// Cung cấp nguồn dữ liệu đăng nhập
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				Account user = accountService.findById(username);
				String password = pe.encode(user.getPassword());
				return User.withUsername(username).password(password)
						.authorities(new SimpleGrantedAuthority("ROLE_USER"))
						.accountLocked(user.getActive()).disabled(user.getLdapFlag()).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username + "not found!");
			}
		});
	}

	// Phân quyền sử dụng
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/task/**").authenticated().anyRequest().permitAll();

		http.formLogin().loginPage("/login").loginProcessingUrl("/login")
				.defaultSuccessUrl("/login/success", false).failureUrl("/login/error");

		http.rememberMe().tokenValiditySeconds(86400);

		http.exceptionHandling().accessDeniedPage("/unauthoried");

		http.logout().logoutUrl("/logoff").logoutSuccessUrl("/login/logoff/success");

	}

	// Cơ chế mã hóa mật khẩu
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Cho phép truy xuất REST API từ bên ngoài (domain khác)
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}

}