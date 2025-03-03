package ks.msx.SpJava.entity;

import jakarta.persistence.*;
import ks.msx.SpJava.entity.authority.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "user_db")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "authenticated")
    private boolean authenticated;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    /* token represent an uuid generated then creating and saving
    user to database, after this token will be used to confirm
    account from email message
    **/
    @Column(name = "auth_token")
    private String auth_token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthority();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive & authenticated;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive & authenticated;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive & authenticated;
    }

    @Override
    public boolean isEnabled() {
        return isActive & authenticated;
    }
}
