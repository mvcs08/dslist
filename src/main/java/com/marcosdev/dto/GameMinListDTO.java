package com.marcosdev.dto;

import com.marcosdev.projections.GameMinProjection;

public record GameMinListDTO(Long id, String title, Integer year, String imgUrl, String shortDescription, Integer position) {

    public GameMinListDTO(GameMinProjection projection) {
        this(projection.getId(), projection.getTitle(), projection.getYear(), projection.getImgUrl(), projection.getShortDescription(), projection.getPosition());
    }
}
