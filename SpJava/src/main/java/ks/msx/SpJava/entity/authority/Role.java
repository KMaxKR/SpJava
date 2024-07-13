package ks.msx.SpJava.entity.authority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public enum Role {
    USER(Set.of(Permission.USER)),
    ADMIN(Set.of(Permission.ADMIN, Permission.USER)),
    ROOT(Set.of(Permission.ROOT, Permission.ADMIN, Permission.USER));

    @Getter
    public final Set<Permission> permissionSet;

    public List<SimpleGrantedAuthority> getAuthority(){
        var authorities =  new ArrayList<>(getPermissionSet()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
