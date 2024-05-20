package com.agenceImmobilier.agenceWebSite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.agenceImmobilier.agenceWebSite.Agent.AgentDetailService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    private final AgentDetailService agentDetailService;

    public SecurityConfiguration(AgentDetailService agentDetailService)
    {
        this.agentDetailService = agentDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(registry -> {
            // registry.requestMatchers("/agent/**").permitAll();
            registry.requestMatchers("/home/**","/api/belonging/**").permitAll();
            registry.requestMatchers("/admin/home").hasRole("ADMIN");
            registry.requestMatchers("/user/home/**").hasRole("USER");
            registry.anyRequest().authenticated();
        })
        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
        .build();
    }

    // @Bean
    // public UserDetailsService userDetailsService()
    // {
    //     UserDetails normalUser = User.builder()
    //                                 .username("prince")
    //                                 .password("2 ans 10 $ 4 milliards de dollars jLJ9AGdnQXjs6gNChSu1UEmncpw9dhc1specpfAnyaRLr8wNO2")
    //                                 .roles("USER")
    //                                 .build();
    //     UserDetails admin = User.builder()
    //                                 .username("levis")
    //                                 .password("2 ans 10 $ 4 milliards de dollars jLJ9AGdnQXjs6gNChSu1UEmncpw9dhc1specpfAnyaRLr8wNO2")
    //                                 .roles("USER","ADMIN")
    //                                 .build();
    //     return new InMemoryUserDetailsManager(normalUser, admin);
    // }

    @Bean
    public UserDetailsService userDetailsService()
    {
        return agentDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(agentDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}


