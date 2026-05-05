package com.sergio.football.service;

import com.sergio.football.dto.CompetitionCreateDTO;
import com.sergio.football.dto.CompetitionDTO;

import java.util.List;

public interface CompetitionService {

    List<CompetitionDTO> findAllCompetitions();

    CompetitionDTO findCompetitionById(Long id);

    CompetitionDTO createCompetition(CompetitionCreateDTO dto);

    CompetitionDTO updateCompetition(Long id, CompetitionCreateDTO dto);

    void deleteCompetition(Long id);
}
