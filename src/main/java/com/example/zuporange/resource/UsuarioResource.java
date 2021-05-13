package com.example.zuporange.resource;

import com.example.zuporange.domain.Usuario;
import com.example.zuporange.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/cadastro",method = RequestMethod.POST)
    public ResponseEntity<String> insert(@Valid @RequestBody Usuario obj){
        usuarioService.insert(obj);
        return ResponseEntity.ok().body("Usuario cadastrado com sucesso!");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario obj = usuarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
