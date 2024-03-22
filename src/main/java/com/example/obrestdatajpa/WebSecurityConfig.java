package com.example.obrestdatajpa;

import com.example.obrestdatajpa.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;




import java.util.Arrays;
import java.util.List;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

    private final UserRepository userRepository;
    public WebSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        return (web) -> web.ignoring()

                // Spring Security should completely ignore URLs starting with /hola

                .requestMatchers("/hola");

    }


//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER", "ADMIN")
//                .and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
//    }

//ESTA FORMA DE DEFINIR USUARIO FUNCIONA PERO ESTÁ DEPRECADO withDefaultPasswordEncoder
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("password")
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    public UserDetailsService userDetailsService() {

        return new CustomUserDetailsService(userRepository);
    }

//    private UserDetails createUser(String username, String password, String... roles) {
//        return User.builder()
//                .username(username)
//                .password(passwordEncoder().encode(password))
//                .roles(roles)
//                .build();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        List<UserDetails> users = Arrays.asList(
//                createUser("admin", "admin", "USER", "ADMIN"),
//                createUser("user", "user", "USER")
//        );
//
//        return new InMemoryUserDetailsManager(users);
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        UserDetails user = User.builder()
//                .username("user")
//                .password(encoder.encode("password"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(encoder.encode("password"))
//                .roles("USER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public HttpFirewall looseHttpFirewall(){
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowSemicolon(true);
        return firewall;
    }

}