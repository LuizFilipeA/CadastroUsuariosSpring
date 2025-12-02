package com.CRUDCADASTRO.CadastroUsuarios.infrastructure.repository;

import com.CRUDCADASTRO.CadastroUsuarios.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
}
