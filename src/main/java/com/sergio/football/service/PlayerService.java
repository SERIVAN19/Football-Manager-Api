package com.sergio.football.service;

import com.sergio.football.dto.PlayerCreateDTO;
import com.sergio.football.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {

    List<PlayerDTO> findAllPlayers();

    PlayerDTO findPlayerById(Long id);

    PlayerDTO createPlayer(PlayerCreateDTO playerCreateDTO);

    PlayerDTO updatePlayer(Long id, PlayerCreateDTO playerCreateDTO);

    void deletePlayer(Long id);

}
