package fr.eni.filmotheque.security;

import fr.eni.filmotheque.bo.Membre;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jspecify.annotations.Nullable;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class UtilisateurSpringSecurity implements UserDetails {

    private Membre membre;

    // autority = permission, un role est composé d'une pour plusieurs permissions
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(membre.isAdmin()){
            return List.of(new SimpleGrantedAuthority("ROLE_admin"));
        }else{
        return List.of(new SimpleGrantedAuthority("ROLE_user"));
        }
    }

    @Override
    public @Nullable String getPassword() {
        return membre.getPassword();
    }

    @Override
    public String getUsername() {
        return membre.getPseudo();
    }
}
