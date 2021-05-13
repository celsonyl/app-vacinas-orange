package com.example.zuporange.services;

import com.example.zuporange.domain.Usuario;
import com.example.zuporange.repositories.UsuarioRepository;
import com.example.zuporange.services.exceptions.ObjectNotFound;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public void insert(Usuario obj){
        usuarioRepository.save(obj);
    }

    public Usuario findById(Integer id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFound("Usuario não encontrado: "+id));
    }

}
