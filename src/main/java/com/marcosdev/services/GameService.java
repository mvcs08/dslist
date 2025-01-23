package com.marcosdev.services;

import com.marcosdev.dto.GameMinDTO;
import com.marcosdev.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> getAllGames() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();

    }
}
