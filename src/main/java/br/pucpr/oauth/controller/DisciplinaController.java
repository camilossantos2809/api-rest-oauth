package br.pucpr.oauth.controller;

import br.pucpr.oauth.repository.DisciplinaRepository;
import br.pucpr.oauth.model.Disciplina;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DisciplinaController {
    private final DisciplinaRepository repository;

    DisciplinaController(DisciplinaRepository repository){
        this.repository = repository;
    }

    @GetMapping("/disciplinas")
    List<Disciplina> all(){
        return repository.findAll();
    }
}
