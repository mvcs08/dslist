package com.marcosdev.services;

import com.marcosdev.dto.GameDTO;
import com.marcosdev.dto.GameMinDTO;
import com.marcosdev.entities.Game;
import com.marcosdev.projections.GameMinProjection;
import com.marcosdev.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }
    @Transactional(readOnly = true) // Transactional garante que a operação com o banco ocorrerá segundo o princípio ACID
    public GameDTO findById(long id) {
        var game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result =  gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }


}
