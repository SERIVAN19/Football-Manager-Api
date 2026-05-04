package com.sergio.football.service.impl;

import com.sergio.football.dto.AssociationDTO;
import com.sergio.football.dto.CreateAssociationDTO;
import com.sergio.football.entity.Association;
import com.sergio.football.exception.ResourceNotFoundException;
import com.sergio.football.mapper.AssociationMapper;
import com.sergio.football.repository.AssociationRepository;
import com.sergio.football.service.AssociationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssociationServiceImpl implements AssociationService {

    private final AssociationRepository associationRepository;


    //Metodo interno
    private Association findAssociationEntityById(Long id){
        return associationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Association not found with id: " + id));
    }

    @Override
    public List<AssociationDTO> findAllAssociations() {
        return associationRepository.findAll()
                .stream()
                .map(AssociationMapper::toDTO)
                .toList();
    }

    @Override
    public AssociationDTO findAssociationById(Long id) {
        Association association = associationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Association not found with id: " + id));
        return AssociationMapper.toDTO(association);
    }

    @Override
    public AssociationDTO createAssociation(CreateAssociationDTO dto) {
        Association association = Association.builder()
                .name(dto.getName())
                .country(dto.getCountry())
                .ceo(dto.getCeo())
                .build();
        Association associationSaved = associationRepository.save(association);
        return AssociationMapper.toDTO(associationSaved);
    }

    @Override
    public AssociationDTO uddateAssociation(Long id, CreateAssociationDTO dto) {
        Association association = findAssociationEntityById(id);

        association.setName(dto.getName());
        association.setCountry(dto.getCountry());
        association.setCeo(dto.getCeo());

        Association associationSaved = associationRepository.save(association);
        return AssociationMapper.toDTO(associationSaved);
    }

    @Override
    public void deleteAssociation(Long id) {
        Association association = findAssociationEntityById(id);
        associationRepository.delete(association);
    }
}
