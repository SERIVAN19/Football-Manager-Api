package com.sergio.football.service.impl;

import com.sergio.football.dto.PlayerCreateDTO;
import com.sergio.football.dto.PlayerDTO;
import com.sergio.football.entity.Club;
import com.sergio.football.entity.Player;
import com.sergio.football.exception.ResourceNotFoundException;
import com.sergio.football.mapper.PlayerMapper;
import com.sergio.football.repository.ClubRepository;
import com.sergio.football.repository.PlayerRepository;
import com.sergio.football.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;

    //Inyeccion de dependencia por constructor
    public PlayerServiceImpl(PlayerRepository playerRepository,ClubRepository clubRepository){
        this.playerRepository = playerRepository;
        this.clubRepository = clubRepository;
    }

    //Metodo interno
    private Player findPlayerEntityById(Long id){
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
    }


    @Override
    public List<PlayerDTO> findAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toDTO)
                .toList();
    }

    @Override
    public PlayerDTO findPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
        return PlayerMapper.toDTO(player);
    }

    @Override
    public PlayerDTO createPlayer(PlayerCreateDTO playerCreateDTO) {
        Player player = Player.builder()
                .name(playerCreateDTO.getName())
                .lastName(playerCreateDTO.getLastName())
                .nationality(playerCreateDTO.getNationality())
                .age(playerCreateDTO.getAge())
                .position(playerCreateDTO.getPosition())
                .build();
        //Relacion con Club
        if (playerCreateDTO.getClubId() != null) {
            Club club = clubRepository.findById(playerCreateDTO.getClubId())
                    .orElseThrow(() -> new ResourceNotFoundException("Club not found"));
            player.setClub(club);
        }
            Player playerSave = playerRepository.save(player);
            return PlayerMapper.toDTO(playerSave);
    }

    @Override
    public PlayerDTO updatePlayer(Long id, PlayerCreateDTO playerCreateDTO) {
        Player player = findPlayerEntityById(id);

        player.setName(playerCreateDTO.getName());
        player.setLastName(playerCreateDTO.getLastName());
        player.setNationality(playerCreateDTO.getNationality());
        player.setAge(playerCreateDTO.getAge());

        Player playerSave = playerRepository.save(player);
        return PlayerMapper.toDTO(playerSave);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
