package com.concess.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.concess.api.models.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

}
