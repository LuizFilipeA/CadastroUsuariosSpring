package com.CRUDCADASTRO.CadastroUsuarios.business.UsuarioService;

import com.CRUDCADASTRO.CadastroUsuarios.infrastructure.entity.Usuario;
import com.CRUDCADASTRO.CadastroUsuarios.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    //A injecao de dependencia poderia ter sido feita utilizando o @Autowired, porem, iremos fazer de forma manual
    private final UsuarioRepository repository;

    //Criando construtor
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    //Create
    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }


    //Update
    public void atualizarUsuarioPorEmail (String email, Usuario usuario){
        Usuario usuarioEntity = buscarUsuarioPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(email)
                .nome(usuario.getNome() != null? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }

    //Read
    public Usuario buscarUsuarioPorEmail (String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email nao encontrado")
        );
    }

    //Delete
    public void deletarUsuarioPorEmail (String email){
        repository.deleteByEmail(email);
    }

    public Optional<Usuario> buscarUsuarioPorId (Integer id){
        return repository.findById(id);
    }

}
