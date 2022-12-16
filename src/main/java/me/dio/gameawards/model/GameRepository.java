package me.dio.gameawards.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
//interface de acesso ao BD através do JpaRepository que implementa um CRUD para a entidade Game e seu tipo de id
}
