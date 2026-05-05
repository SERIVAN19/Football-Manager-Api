package com.sergio.football.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionDTO {

    private Long id;

    private String name;

    private Integer prizeAmount;

    private LocalDate startDate;

    private LocalDate endDate;

}
