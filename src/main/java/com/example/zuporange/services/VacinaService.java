package com.example.zuporange.services;

import com.example.zuporange.domain.Vacina;
import com.example.zuporange.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    public void Insert(Vacina obj) {
        vacinaRepository.save(obj);
    }
}
