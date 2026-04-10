package com.sergio.football.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {

    private Long id;
    private String name;
    private String lastName;
    private String nationality;
    private Integer age;

    private String clubName;
}
