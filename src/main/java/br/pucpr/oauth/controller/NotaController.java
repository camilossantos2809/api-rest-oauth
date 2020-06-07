package br.pucpr.oauth.controller;

import br.pucpr.oauth.exception.DisciplinaNotFoundException;
import br.pucpr.oauth.exception.EstudanteNotFoundException;
import br.pucpr.oauth.exception.NotaNotFoundException;
import br.pucpr.oauth.model.Disciplina;
import br.pucpr.oauth.model.Estudante;
import br.pucpr.oauth.model.Nota;
import br.pucpr.oauth.repository.DisciplinaRepository;
import br.pucpr.oauth.repository.EstudanteRepository;
import br.pucpr.oauth.repository.NotaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotaController {
    private final String BASE_URL = "/notas";
    private final NotaRepository repository;
    private final DisciplinaRepository disciplinaRepository;
    private final EstudanteRepository estudanteRepository;

    NotaController(
            NotaRepository repository,
            DisciplinaRepository disciplinaRepository,
            EstudanteRepository estudanteRepository) {
        this.repository = repository;
        this.disciplinaRepository = disciplinaRepository;
        this.estudanteRepository = estudanteRepository;
    }

    @GetMapping(BASE_URL)
    List<Nota> all() {
        return repository.findAll();
    }

    @PostMapping(BASE_URL)
    Nota create(@RequestBody Nota nota) {
        return repository.save(nota);
    }

    @GetMapping(BASE_URL + "/{codigo}")
    Nota get(@PathVariable Integer codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new NotaNotFoundException(codigo));
    }

    @PutMapping(BASE_URL + "/{codigo}")
    Nota update(@RequestBody Nota newNota, @PathVariable Integer codigo) {
        int disciplinaCod = newNota.getDisciplina().getCodigo();
        Disciplina disciplina = disciplinaRepository.findById(disciplinaCod)
                .orElseThrow(() -> new DisciplinaNotFoundException(disciplinaCod));

        int estudanteCod = newNota.getEstudante().getCodigo();
        Estudante estudante = estudanteRepository.findById(estudanteCod)
                .orElseThrow(()->new EstudanteNotFoundException(estudanteCod));

        return repository.findById(codigo)
                .map(nota -> {
                    nota.setDisciplina(disciplina);
                    nota.setEstudante(estudante);
                    nota.setNota(newNota.getNota());
                    nota.setFrequencia(newNota.getFrequencia());
                    return repository.save(nota);
                })
                .orElseThrow(() -> new NotaNotFoundException(codigo));
    }

    @DeleteMapping(BASE_URL + "/{codigo}")
    ResponseEntity<Integer> delete(@PathVariable Integer codigo) {
        try {
            repository.deleteById(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
