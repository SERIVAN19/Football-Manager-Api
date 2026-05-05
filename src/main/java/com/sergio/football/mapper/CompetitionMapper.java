package com.sergio.football.mapper;

import com.sergio.football.dto.CompetitionDTO;
import com.sergio.football.entity.Competition;

public class CompetitionMapper {

    public static CompetitionDTO toDTO(Competition competition){

        if (competition == null){
            return null;
        }

        return CompetitionDTO.builder()
                .id(competition.getId())
                .name(competition.getName())
                .prizeAmount(competition.getPrizeAmount())
                .startDate(competition.getStartDate())
                .endDate(competition.getEndDate())
                .build();
    }
}
