package fr.eni.filmotheque.security;

import fr.eni.filmotheque.bo.Membre;
import fr.eni.filmotheque.dal.MembreDao;
import fr.eni.filmotheque.service.MembreService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class ServicePersonaliseAuthentification implements UserDetailsService {

    MembreService membreService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Membre m = membreService.consulterMembreByUsername(username);
        return new UtilisateurSpringSecurity(m);
    }
}
