package ks.msx.SpJava.entity.authority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    USER("USER"),
    ADMIN("ADMIN"),
    ROOT("ROOT");

    @Getter
    public final String getPermission;
}
