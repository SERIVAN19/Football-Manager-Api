package com.sergio.football.service.impl;

import com.sergio.football.dto.CompetitionCreateDTO;
import com.sergio.football.dto.CompetitionDTO;
import com.sergio.football.entity.Competition;
import com.sergio.football.exception.ResourceNotFoundException;
import com.sergio.football.mapper.CompetitionMapper;
import com.sergio.football.repository.CompetitionRepository;
import com.sergio.football.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    //Metodo interno que retorna una entidad competition
    private Competition findCompetitionEntityById(Long id){
        return competitionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Competition not found with id: " + id));
    }

    @Override
    public List<CompetitionDTO> findAllCompetitions() {
        return competitionRepository.findAll()
                .stream()
                .map(CompetitionMapper::toDTO)
                .toList();
    }

    @Override
    public CompetitionDTO findCompetitionById(Long id) {
        Competition competition = competitionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Competition not found with id: " + id));
        return CompetitionMapper.toDTO(competition);
    }

    @Override
    public CompetitionDTO createCompetition(CompetitionCreateDTO dto) {
        Competition competition = Competition.builder()
                .name(dto.getName())
                .prizeAmount(dto.getPrizeAmount())
                .build();
        //Simplificado
        return CompetitionMapper.toDTO(
                competitionRepository.save(competition)
        );
    }

    @Override
    public CompetitionDTO updateCompetition(Long id, CompetitionCreateDTO dto) {
        Competition competition = findCompetitionEntityById(id);

        competition.setName(dto.getName());
        competition.setPrizeAmount(dto.getPrizeAmount());

        Competition competitionSaved = competitionRepository.save(competition);
        return CompetitionMapper.toDTO(competitionSaved);
    }

    @Override
    public void deleteCompetition(Long id) {
        Competition competition = findCompetitionEntityById(id);
        competitionRepository.delete(competition);
    }
}
