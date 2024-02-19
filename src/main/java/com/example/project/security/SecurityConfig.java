package com.example.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
public class SecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select benutzer, pw, active from sicherheit where benutzer=?");

        // define query to retrieve a user by roll
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select benutzer, rolle from mitglieder where benutzer=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/projekte/save").hasRole("ADMIN")
                        .requestMatchers("/projekte/delete").hasRole("ADMIN")
                        .requestMatchers("/projekte/update").hasRole("ADMIN")
                        .requestMatchers("/projekte/anlegen").hasRole("ADMIN")

                        .requestMatchers("/aufgaben/anlegen").hasRole("ADMIN")
                        .requestMatchers("/aufgaben/save").hasRole("ADMIN")
                        .requestMatchers("/aufgaben/delete").hasRole("ADMIN")
                        .requestMatchers("/aufgaben/update").hasRole("ADMIN")

                        .anyRequest().authenticated())
                        .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/error"));

     /*   http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());*/

        return http.build();
    }


}
