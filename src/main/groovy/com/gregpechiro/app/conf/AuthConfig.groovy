package com.gregpechiro.app.conf

import com.gregpechiro.app.CustomAuthenticationSuccessHandler
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.security.web.util.matcher.RegexRequestMatcher
import org.springframework.security.web.util.matcher.RequestMatcher

import javax.servlet.http.HttpServletRequest
import javax.sql.DataSource
import java.util.regex.Pattern

@CompileStatic
@Configuration
@EnableWebMvcSecurity
class AuthConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN")

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
			.usersByUsernameQuery("SELECT username, password, active FROM user WHERE username=?")
			.authoritiesByUsernameQuery("SELECT username, role FROM user WHERE username=?")
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
		http.formLogin()
			.loginPage("/login").defaultSuccessUrl("/secure")
			.successHandler(new CustomAuthenticationSuccessHandler())
		http.httpBasic()
		http.logout()
			.invalidateHttpSession(true)
			.logoutSuccessUrl("/")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
		http.sessionManagement()
			.maximumSessions(1)
			.expiredUrl("/login?expired")
			.maxSessionsPreventsLogin(false)
			.and()
			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		http.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
			private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)\$");
			private RegexRequestMatcher apiMatcher = new RegexRequestMatcher("/rest/.*", null);

			@Override
			public boolean matches(HttpServletRequest request) {
				// No CSRF due to allowedMethod
				if(allowedMethods.matcher(request.getMethod()).matches())
					return false;

				// No CSRF due to api call
				if(apiMatcher.matches(request))
					return false;

				// CSRF for everything else that is not an API call or an allowedMethod
				return true;
			}
		});
	}
}