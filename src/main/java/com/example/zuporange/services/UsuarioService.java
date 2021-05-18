package com.example.zuporange.services;

import com.example.zuporange.domain.Usuario;
import com.example.zuporange.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void insert(Usuario obj) {
        usuarioRepository.save(obj);
    }

}
