package com.sergio.football.mapper;

import com.sergio.football.dto.CoachDTO;
import com.sergio.football.entity.Coach;

public class CoachMapper {

    public static CoachDTO toDTO(Coach coach){
        return CoachDTO.builder()
                .id(coach.getId())
                .name(coach.getName())
                .lastName(coach.getLastName())
                .nationality(coach.getNationality())
                .age(coach.getAge())
                .build();
    }
}
