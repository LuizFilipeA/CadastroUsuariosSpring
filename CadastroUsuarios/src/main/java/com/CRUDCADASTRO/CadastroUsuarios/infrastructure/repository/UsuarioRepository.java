package com.CRUDCADASTRO.CadastroUsuarios.infrastructure.repository;

import com.CRUDCADASTRO.CadastroUsuarios.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

    //findBy por padrao, "Email" tem que corresponder a uma coluna da tabela de usuarios e obrigatoriamente com a primeira letra em maiusculo = findByEmail
   Optional<Usuario> findByEmail(String email);
}
