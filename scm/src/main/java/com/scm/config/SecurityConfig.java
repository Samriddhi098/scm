package com.scm.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig {
//create user and login java code within memo service
// @Bean
// public UserDetailsService userDetailsService(){
//    UserDetails user1=User
//    .withDefaultPasswordEncoder()
//    .username("admin123")
//    .password("admin123")
//    .roles("ADMIN","USER")
//    .build();
// UserDetails user2=User
// .withUsername("user123")
// .password("password321")
// // .roles(null)
// .build();
//     var inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//     return inMemoryUserDetailsManager;
// }

public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
    //user service ka object
    
     daoAuthenticationProvider.setUserDetailsService(null);
    
     //password encoder ka object
     daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    
 return daoAuthenticationProvider;
}
@Bean
public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}



}
