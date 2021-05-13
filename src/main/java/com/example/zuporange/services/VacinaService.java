package com.example.zuporange.services;

import com.example.zuporange.domain.Vacina;
import com.example.zuporange.repositories.VacinaRepository;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository){
        this.vacinaRepository = vacinaRepository;
    }

    public void Insert(Vacina obj){
        vacinaRepository.save(obj);
    }
}
