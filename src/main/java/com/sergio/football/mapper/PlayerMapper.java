package com.sergio.football.mapper;

import com.sergio.football.dto.PlayerDTO;
import com.sergio.football.entity.Player;

public class PlayerMapper {

    public static PlayerDTO toDTO(Player player){
        return PlayerDTO.builder()
                .id(player.getId())
                .name(player.getName())
                .lastName(player.getLastName())
                .nationality(player.getNationality())
                .age(player.getAge())
                .position(player.getPosition())
                .clubName(
                        player.getClub() != null ? player.getClub().getName() : null
                )
                .build();
    }
}
