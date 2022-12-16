package me.dio.gameawards.service.impl;

import me.dio.gameawards.model.Game;
import me.dio.gameawards.model.GameRepository;
import me.dio.gameawards.service.GameService;
import me.dio.gameawards.service.exception.BusinessException;
import me.dio.gameawards.service.exception.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository repository;

    @Override
    public List<Game> findAll() {
        //lista os jogos pela quantidade de votos recebidos
        List<Game> games = repository.findAll(Sort.by(Sort.Direction.DESC, "votes"));
        return games;
    }
    @Override
    public Game findById(Long id) {
        //pode não encontrar nada, talvez encontre ...
        Optional<Game> game = repository.findById(id);
        return game.orElseThrow(() -> new NoContentException());
        /*if (game.isPresent()){
            return game.get();
        } else {
            throw new NoContentExceptiom();
        }*/
    }
    @Override
    public void insert(Game game) {
        //caso o o jogo já exista no banco
        //if (game.getId() != null){
        if (Objects.nonNull(game.getId())){
            throw new BusinessException("O ID é diferente de NULL na inclusão.");
        }
        repository.save(game);
    }
    @Override
    public void update(Long id, Game game) {
        Game gameDb = findById(id);
        if (gameDb.getId().equals(game.getId())){
            repository.save(game);
        } else {
            throw new BusinessException("Os Ids para alteração são divergentes.");
        }
    }
    @Override
    public void delete(Long id) {
        Game gameDb = findById(id);
        repository.delete(gameDb);
    }
    @Override
    public void vote(Long id) {
        Game gameDb = findById(id);
        gameDb.setVotes(gameDb.getVotes() + 1);

        update(id, gameDb);
    }
}
