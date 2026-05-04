package com.sergio.football.service;

import com.sergio.football.dto.AssociationDTO;
import com.sergio.football.dto.CreateAssociationDTO;

import java.util.List;

public interface AssociationService {

    List<AssociationDTO> findAllAssociations();

    AssociationDTO findAssociationById(Long id);

    AssociationDTO createAssociation(CreateAssociationDTO dto);

    AssociationDTO uddateAssociation(Long id, CreateAssociationDTO dto);

    void deleteAssociation(Long id);

}
