package com.example.zuporange.resource;

import com.example.zuporange.domain.Vacina;
import com.example.zuporange.services.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/vacinas")
public class VacinaResource {

    @Autowired
    private VacinaService vacinaService;

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<Vacina> insert(@Valid @RequestBody Vacina obj) {
        vacinaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
