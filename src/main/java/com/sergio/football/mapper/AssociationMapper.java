package com.sergio.football.mapper;

import com.sergio.football.dto.AssociationDTO;
import com.sergio.football.entity.Association;

import java.util.Collections;
import java.util.stream.Collectors;

public class AssociationMapper {

    public static AssociationDTO toDTO(Association association){

        return AssociationDTO.builder()
                .id(association.getId())
                .name(association.getName())
                .country(association.getCountry())
                .ceo(association.getCeo())
                .clubNames(
                        association.getClubs() != null ?
                                association.getClubs().stream()
                                        .map(club -> club.getName())
                                        .toList()
                                : Collections.emptyList()
                )
                .build();
    }
}
