package com.marcosdev.dto;

import com.marcosdev.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(){}
    public GameListDTO(GameList gameList){
        this.id = gameList.getId();
        this.name = gameList.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
