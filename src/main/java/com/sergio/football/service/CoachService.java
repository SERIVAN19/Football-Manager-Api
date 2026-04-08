package com.sergio.football.service;


import com.sergio.football.dto.CoachCreateDTO;
import com.sergio.football.dto.CoachDTO;

import java.util.List;

public interface CoachService {

    List<CoachDTO> findAllCoachs();

    CoachDTO findCoachById(Long id);

    CoachDTO createCoach(CoachCreateDTO dto);

    CoachDTO updateCoach(Long id, CoachCreateDTO dto);

    void deleteCoach(Long id);
}
