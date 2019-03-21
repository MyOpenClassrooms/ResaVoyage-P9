package com.ms.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity 	// Enable security config. This annotation denotes config for spring security.
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JwtConfig jwtConfig;
 
	@Override
  	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and()
            .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                // Add a filter to validate the tokens with every request
                .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
                // authorization requests config
                .authorizeRequests()
                // allow all who are accessing "auth" service
                .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll()
                // must be an admin if trying to access admin area (authentication is also required here)
                .antMatchers("/comments/admin/**").hasRole("ADMIN")
                .antMatchers("/categories/admin/**").hasRole("ADMIN")
                .antMatchers("/adventures/admin/**").hasRole("ADMIN")
                .antMatchers("/adventures/sessions/admin/**").hasRole("ADMIN")
                .antMatchers("/users/api/admin/**").hasRole("ADMIN")
                .antMatchers("/images/api/admin/**").hasRole("ADMIN")
                .antMatchers("/images/api/adventure/admin/**").hasRole("ADMIN")
                .antMatchers("/images/api/category/admin/**").hasRole("ADMIN")
                .antMatchers("/images/api/user/admin/**").hasRole("ADMIN")
                .antMatchers("/orders/api/admin/**").hasRole("ADMIN")
                .antMatchers("/orders/api/demands/admin/**").hasRole("ADMIN")                // Any other request must be authenticated
                .anyRequest().authenticated();
    }
	
	@Bean
  	public JwtConfig jwtConfig() {
    	   return new JwtConfig();
  	}

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addExposedHeader("Authorization");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("PATCH");
        corsConfiguration.addAllowedMethod("DELETE");

        source.registerCorsConfiguration("/**", corsConfiguration.applyPermitDefaultValues());

        return source;
    }
}