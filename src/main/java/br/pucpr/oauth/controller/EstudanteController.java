package br.pucpr.oauth.controller;

import br.pucpr.oauth.exception.EstudanteNotFoundException;
import br.pucpr.oauth.model.Estudante;
import br.pucpr.oauth.repository.EstudanteRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstudanteController {
    private final String BASE_URL = "/estudantes";
    private final EstudanteRepository repository;

    EstudanteController(EstudanteRepository repository) {
        this.repository = repository;
    }

    @GetMapping(BASE_URL)
    List<Estudante> all() {
        return repository.findAll();
    }

    @PostMapping(BASE_URL)
    Estudante create(@RequestBody Estudante estudante) {
        return repository.save(estudante);
    }

    @GetMapping(BASE_URL + "/{codigo}")
    Estudante get(@PathVariable Integer codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new EstudanteNotFoundException(codigo));
    }

    @PutMapping(BASE_URL + "/{codigo}")
    Estudante update(@RequestBody Estudante newEstudante, @PathVariable Integer codigo) {
        return repository.findById(codigo)
                .map(estudante -> {
                    estudante.setNome(newEstudante.getNome());
                    return repository.save(estudante);
                })
                .orElseThrow(() -> new EstudanteNotFoundException(codigo));
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
