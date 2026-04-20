package com.sergio.football.controller;

import com.sergio.football.dto.PlayerCreateDTO;
import com.sergio.football.dto.PlayerDTO;
import com.sergio.football.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    public PlayerDTO createPlayer(@Valid @RequestBody PlayerCreateDTO dto){
        return playerService.createPlayer(dto);
    }

    @GetMapping
    public List<PlayerDTO> findAllsPlayers(){
        return playerService.findAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerDTO findPlayerById(@PathVariable Long id){
        return playerService.findPlayerById(id);
    }

    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(@PathVariable Long id,
                            @Valid @RequestBody PlayerCreateDTO dto) {
        return playerService.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

}
