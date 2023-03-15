package com.renan.minha_api_restful.security;

import com.renan.minha_api_restful.enums.PerfilEnum;
import org.springframework.security.core.GrantedAuthority;
import sun.misc.Perf;

public class UserAuthority implements GrantedAuthority {

    private PerfilEnum role;

    public UserAuthority(PerfilEnum role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + role.name();
    }
}
