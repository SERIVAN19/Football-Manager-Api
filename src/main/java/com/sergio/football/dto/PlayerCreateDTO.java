package com.sergio.football.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @NotBlank(message = "La nacionalidad es obligatoria")
    private String nationality;

    @NotNull(message = "la edad es obligatoria")
    private Integer age;

    @NotBlank(message = "La posicion es obligatoria")
    private String position;

    private Long clubId;
}
