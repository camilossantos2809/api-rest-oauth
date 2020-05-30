package br.pucpr.oauth.controller;

import br.pucpr.oauth.exception.DisciplinaNotFoundException;
import br.pucpr.oauth.repository.DisciplinaRepository;
import br.pucpr.oauth.model.Disciplina;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisciplinaController {
    private final String BASE_URL = "/disciplinas";
    private final DisciplinaRepository repository;

    DisciplinaController(DisciplinaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(BASE_URL)
    List<Disciplina> all() {
        return repository.findAll();
    }

    @PostMapping(BASE_URL)
    Disciplina create(@RequestBody Disciplina disciplina) {
        return repository.save(disciplina);
    }

    @GetMapping(BASE_URL + "/{codigo}")
    Disciplina get(@PathVariable Integer codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new DisciplinaNotFoundException(codigo));
    }

    @PutMapping(BASE_URL + "/{codigo}")
    Disciplina update(@RequestBody Disciplina newDisciplina, @PathVariable Integer codigo) {
        return repository.findById(codigo)
                .map(disciplina -> {
                    disciplina.setNome(newDisciplina.getNome());
                    return repository.save(disciplina);
                })
                .orElseThrow(() -> new DisciplinaNotFoundException(codigo));
    }

    @DeleteMapping(BASE_URL + "/{codigo}")
    ResponseEntity<Integer> delete(@PathVariable Integer codigo) {
        try {
            repository.deleteById(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EmptyResultDataAccessException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
