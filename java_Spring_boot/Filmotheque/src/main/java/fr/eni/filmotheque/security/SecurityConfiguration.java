package fr.eni.filmotheque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        //.requestMatchers("/pageAdmin").hasRole("admin")
                        .requestMatchers("/films/nouveau","/genres","/participants").hasRole("admin")
                        .requestMatchers("/films/*/avis").authenticated()
                        .requestMatchers("/**").permitAll())
                // on effectue une authentification basique (user/mdp)
                .httpBasic(Customizer.withDefaults())
                // on utilise le formulaire par défaut de Spring
                .formLogin(Customizer.withDefaults())
                // quand on se déconnecte=> on redirige vers l'accueil
                .logout((logout) -> logout.logoutSuccessUrl("/"));
        return http.build();

    }

    @Bean // on définit un bean pour l'utilitaire d'encryption de mot de passe
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //@Bean  on définit un bean pour la gestion des utilisateurs en mémoire
    public InMemoryUserDetailsManager userDetailsService() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        userDetailsList.add( User.withUsername("membre").password(passwordEncoder().encode("membre123"))
                .roles("user").build());
        userDetailsList.add( User.withUsername("admin").password(passwordEncoder().encode("admin123"))
                .roles("admin", "user").build());
        return new InMemoryUserDetailsManager(userDetailsList);
    }

}
