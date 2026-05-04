package com.sergio.football.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociationDTO {

    private Long id;

    private String name;

    private String country;

    private String ceo;

    private List<String> clubNames;
}
