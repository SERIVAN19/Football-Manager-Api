package com.sergio.football.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoachDTO {

    private Long id;
    private String name;
    private String lastName;
    private String nationality;
    private Integer age;
}
