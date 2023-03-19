package com.renan.minha_api_restful.entities;

import com.renan.minha_api_restful.enums.PerfilEnum;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UsuarioRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, unique = true)
    private PerfilEnum role;

    @Override
    public String getAuthority() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerfilEnum getRole() {
        return role;
    }

    public void setRole(PerfilEnum role) {
        this.role = role;
    }
}
