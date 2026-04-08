package com.sergio.football.service;

import com.sergio.football.dto.ClubCreateDTO;
import com.sergio.football.dto.ClubDTO;

import java.util.List;

public interface ClubService {

    List<ClubDTO> findAllClubs();

    ClubDTO findClubById(Long id);

    ClubDTO createClub(ClubCreateDTO clubCreateDTO);

    ClubDTO updateClub(Long id, ClubCreateDTO clubCreateDTO);

    void deleteClub(Long id);

}
