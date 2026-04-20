package com.sergio.football.service.impl;

import com.sergio.football.dto.ClubCreateDTO;
import com.sergio.football.dto.ClubDTO;
import com.sergio.football.entity.Association;
import com.sergio.football.entity.Club;
import com.sergio.football.entity.Coach;
import com.sergio.football.exception.ResourceNotFoundException;
import com.sergio.football.mapper.ClubMapper;
import com.sergio.football.repository.AssociationRepository;
import com.sergio.football.repository.ClubRepository;
import com.sergio.football.repository.CoachRepository;
import com.sergio.football.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor    // Crea el constructor
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;
    private final CoachRepository coachRepository;
    private final AssociationRepository associationRepository;

    //Se crea el contructor con la anotation @RequiredArgsConstructor



    //Metodo Interno
    private Club findClubEntityById(Long id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found with id: " + id));
    }



    @Override
    public List<ClubDTO> findAllClubs() {
        return clubRepository.findAll()
                .stream()
                .map(ClubMapper::toDTO)
                .toList();
    }



    @Override
    public ClubDTO findClubById(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club not found"));

        return ClubMapper.toDTO(club);
    }



    @Override
    public ClubDTO createClub(ClubCreateDTO dto) {

        Club club = new Club();
        club.setName(dto.getName());

        // 🔹 Buscar Coach
        if (dto.getCoachId() != null) {
            Coach coach = coachRepository.findById(dto.getCoachId())
                    .orElseThrow(() -> new ResourceNotFoundException("Coach not found"));
            club.setCoach(coach);
        }

        // 🔹 Buscar Association
        if (dto.getAssociationId() != null) {
            Association association = associationRepository.findById(dto.getAssociationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Association not found"));
            club.setAssociation(association);
        }

        Club saved = clubRepository.save(club);

        return ClubMapper.toDTO(saved);
    }



    @Override
    public ClubDTO updateClub(Long id, ClubCreateDTO dto) {

        // 1. Buscamos el club existente
        Club existingClub = findClubEntityById(id);

        // 2. Actualizamos campos básicos
        existingClub.setName(dto.getName());
        /*
        // 3. Actualizamos el Coach (si se proporciona un ID)
        if (dto.getCoachId() != null) {
            Coach coach = coachRepository.findById(dto.getCoachId())
                    .orElseThrow(() -> new ResourceNotFoundException("Coach no encontrado"));
            existingClub.setCoach(coach);
        }

        // 4. Actualizamos la Association (si se proporciona un ID)
        if (dto.getAssociationId() != null) {
            Association association = associationRepository.findById(dto.getAssociationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Asociación no encontrada"));
            existingClub.setAssociation(association);
        }
        */
        Club updated = clubRepository.save(existingClub);
        return ClubMapper.toDTO(updated);
    }



    @Override
    public void deleteClub(Long id) {
        Club club = findClubEntityById(id);
        clubRepository.delete(club);
    }
}