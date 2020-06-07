package br.pucpr.oauth.repository;

import br.pucpr.oauth.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {
}
