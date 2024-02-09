package com.antobevi.javawebappeducacionit.config;

import com.antobevi.javawebappeducacionit.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

// Configuraciones de seguridad
@Configuration
@EnableWebSecurity//(debug = true) // Me va a mostrar mas logs
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.formLogin().loginPage("/nombreVista"); Si queremos usar nuestro propio login y no el que nos provee Spring
        // Si queremos filtrar por rol este es el lugar
        // Si bien hay metodos deprecados es mejor agregarlos por las dudas, podria fallar
        // Aca indicamos que salvo signup y login (cualquiera puede entrar a esas vistas), para el resto se requiere estar autenticado

        return http.formLogin().defaultSuccessUrl("/pets/list").permitAll().and()
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/signup").permitAll()) // si necesitamos exceptuar otra vista copiamos esta linea
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/error").permitAll())
                .authorizeHttpRequests().anyRequest().authenticated().and().build();
        /*
        return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/signup").permitAll();
            auth.anyRequest().authenticated();})
                .formLogin().defaultSuccessUrl("/pets/list").permitAll().and().build();
        */
    }

    // Forma en que se crea el encoding
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}