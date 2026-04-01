package com.sergio.football.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubDTO {   //Response

    private Long id;
    private String name;

    private String coachName;

    private String associationName;

    private List<String> players;

    private List<String> competitions;
}
