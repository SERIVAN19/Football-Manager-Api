package com.sergio.football.service.impl;

import com.sergio.football.dto.CoachCreateDTO;
import com.sergio.football.dto.CoachDTO;
import com.sergio.football.entity.Coach;
import com.sergio.football.exception.ResourceNotFoundException;
import com.sergio.football.mapper.CoachMapper;
import com.sergio.football.repository.CoachRepository;
import com.sergio.football.service.CoachService;
//port lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;


    //Inyeccion de dependencias por constructor
    public CoachServiceImpl(CoachRepository coachRepository){
        this.coachRepository = coachRepository;
    }


    //Metodo Interno
    private Coach findCoachEntityById(Long id) {
        return coachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coach not found with id: " + id));
    }


    @Override
    public List<CoachDTO> findAllCoachs() {
        return coachRepository.findAll()
                .stream()
                .map(CoachMapper::toDTO)
                .toList();
    }


    @Override
    //@SneakyThrows
    public CoachDTO findCoachById(Long id) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coach not found with id: " + id));
        return CoachMapper.toDTO(coach);
    }


    @Override
    public CoachDTO createCoach(CoachCreateDTO dto) {
        Coach coach =  Coach.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .nationality(dto.getNationality())
                .age(dto.getAge())
                .build();
        Coach CoachSaved = coachRepository.save(coach);
        return CoachMapper.toDTO(CoachSaved);
    }


    @Override
    public CoachDTO updateCoach(Long id, CoachCreateDTO dto) {
        Coach coach = findCoachEntityById(id);

        coach.setName(dto.getName());
        coach.setLastName(dto.getLastName());
        coach.setNationality(dto.getNationality());
        coach.setAge(dto.getAge());

        Coach CoachSaved = coachRepository.save(coach);
        return CoachMapper.toDTO(CoachSaved);
    }


    @Override
    public void deleteCoach(Long id) {
        Coach coach =  coachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coach not found with id: " + id));
        coachRepository.delete(coach);
    }
}
