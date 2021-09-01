package com.example.Login.Config;

import com.example.Login.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login","/signup/**")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateUser")
                .defaultSuccessUrl("/home")
                .and()
                .logout().permitAll()
                .and()
                .sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                //.sessionAuthenticationStrategy(sessionAuthenticationStrategy())
                .maximumSessions(1)
                ;


    }

//    @Bean
//    public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//        ConcurrentSessionControlAuthenticationStrategy sessionControlAuthenticationStrategy
//                =new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
//        sessionControlAuthenticationStrategy.setMaximumSessions(1);
//        sessionControlAuthenticationStrategy.setExceptionIfMaximumExceeded(true);
//        return sessionControlAuthenticationStrategy;
//    }

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher(){
        return new HttpSessionEventPublisher();
    }
//    @Bean
//    public SessionRegistry sessionRegistry(){
//        return new SessionRegistryImpl();
//    }

}
