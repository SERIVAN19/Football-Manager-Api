package com.sergio.football.mapper;

import com.sergio.football.dto.ClubDTO;
import com.sergio.football.entity.Club;

import java.util.stream.Collectors;

public class ClubMapper {

    public static ClubDTO toDTO(Club club) {

        return ClubDTO.builder()
                .id(club.getId())
                .name(club.getName())
                .coachName(
                        club.getCoach() != null ? club.getCoach().getName() : null
                )
                .associationName(
                        club.getAssociation() != null ? club.getAssociation().getName() : null
                )
                .players(
                        club.getPlayers() != null ?
                                club.getPlayers().stream()
                                        .map(player -> player.getName())
                                        .collect(Collectors.toList())
                                : null
                )
                .competitions(
                        club.getCompetitions() != null ?
                                club.getCompetitions().stream()
                                        .map(comp -> comp.getName())
                                        .collect(Collectors.toList())
                                : null
                )
                .build();
    }
}
